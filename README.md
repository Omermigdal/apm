# Omer APM — Java & Spring guidance registry

A single, versioned source of GitHub Copilot instructions and Agent Skills for Java/Spring repositories. [TRACEABILITY.md](TRACEABILITY.md) preserves the decisions behind this guidance.

## Contents

| Source (in this registry) | Consumer output (`--target copilot`) | Use |
| --- | --- | --- |
| `.apm/instructions/project-workflow.instructions.md` | `.github/instructions/project-workflow.instructions.md` | Cross-cutting change discipline |
| `.apm/instructions/java.instructions.md` | `.github/instructions/java.instructions.md` | Java 25 implementation/tests |
| `.apm/instructions/spring.instructions.md` | `.github/instructions/spring.instructions.md` | Spring Boot 4.x conventions |
| `.apm/skills/spring-development/` | `.agents/skills/spring-development/` | On-demand Spring workflow and 3 references |

**Ownership:** Only `.apm/` is the source of installable guidance in this repository. Consumers commit the generated directories and `apm.lock.yaml`; they must not maintain parallel handwritten copies of these files.

**Versions.** The guidance covers Java 25 and Spring Boot 4.x. In consumer projects, follow the configured Spring Boot minor and patch versions. Check the matching release documentation before using an API, starter, or configuration property. Framework upgrades and infrastructure changes require explicit authorization.

## Install in a consumer

Install the [Microsoft APM CLI](https://github.com/microsoft/apm) (the reusable workflows pin `apm-cli` to `0.35.0`), then in the consumer repository:

```bash
apm install Omermigdal/apm#v1.0.0 --target copilot --no-trust-bin
apm audit --ci
```

The `v1.0.0` tag must be created **after** the initial registry checks pass; until then use a reviewed exact registry commit SHA instead of the tag. Commit `apm.yml`, `apm.lock.yaml`, and deployed `.github/instructions/` and `.agents/skills/` files. Check the diff and reconcile any existing Copilot instructions before adopting. APM can skip edited/colliding files instead of silently overwriting them.

For reproducible downstream installs, keep `targets: [copilot]` in the consumer manifest; don't depend on machine-specific auto-detection. Confirm your Copilot client discovers `.github/instructions/*.instructions.md` and `.agents/skills/`.

## Updating consumers

The recommended update model is **consumer pull, not registry push**:

1. Maintain one versioned registry, with reviewed changes to `.apm/` and GitHub releases/tags.
2. In each consumer, call [the reusable `sync-consumer.yml` workflow](.github/workflows/sync-consumer.yml) on a schedule or manual dispatch. It runs `apm update Omermigdal/apm --yes` (first-party dependency only), verifies the deployment with `apm audit --ci`, and opens/updates a PR containing the regenerated lockfile and files.
3. The workflow **requires a GitHub App installation token** (Contents and Pull requests write) so the PR's normal CI will run. It intentionally does not fall back to `GITHUB_TOKEN` and silently create untested PRs.
4. Require the consumer's APM audit and application tests as branch checks. Review agent-text changes before merge, particularly external sources. Auto-merge only for your reviewed first-party package if your policies allow it.

The repository includes [an example caller](examples/sync-caller.yml.example). Keep its `uses:` ref on an immutable tag or SHA; replace the placeholder with a published tag. The production sync job is not activated simply by creating this registry.

## Registry validation

CI in [validate-apm.yml](.github/workflows/validate-apm.yml) pins the APM CLI, verifies primitive structure, installs to the Copilot target, and audits its output. It does not change committed files. To validate locally:

```bash
apm compile --validate
apm install --target copilot --only apm --no-trust-bin
apm audit --ci
```

Version changes require a deliberate edit to `apm.yml` and a matching Git tag after validation. No production repositories are touched automatically by this producer.
