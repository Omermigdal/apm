# Spring Boot APM consumer — standalone-ready example

This is a **separate APM consumer project** stored under `examples/` for
demonstration. Copy this directory to the root of a **new GitHub repository**
to give it an independent application lifecycle. It does **not** publish an
additional APM package and does not duplicate central instruction sources.

## Prerequisites

- Java 25, Maven 3.9+ and the pinned APM CLI 0.35.0.
- Network access for the Maven dependencies and the public `Omermigdal/apm` repo.

## Try the consumer

From this example directory (not the registry root):

```bash
apm install --target copilot --only apm --no-trust-bin
apm audit --ci
mvn -B test
mvn spring-boot:run
curl 'http://localhost:8080/api/v1/greetings?name=Omer'
# {"message":"Hello, Omer!"}
curl 'http://localhost:8080/actuator/health'
```

The `apm.yml` dependency points at the **exact, reviewed merge commit**
`003f5bd5270d6bf407de6335cbe8712e491ae7e3` because `v1.0.0`
is **not published yet**. Unlike a mutable branch, this is reproducible.
After the registry publishes a tested `v1.0.0` tag, you can explicitly
change the ref and re-install.

For an independent consumer repo, **commit the generated outputs**:

```bash
git add apm.yml apm.lock.yaml .github/instructions/ .agents/skills/ AGENTS.md
git commit -m 'chore: install centralized APM guidance'
```

Then enable `.github/workflows/apm-audit.yml.example` by removing
`.example`. It verifies committed files rather than silently regenerating
them, and should be a required check alongside the Maven test workflow.

To automate weekly updates, enable `.github/workflows/apm-sync.yml.example`.
It calls the registry's SHA-pinned reusable workflow and uses a GitHub App
token to create genuine PRs. Set repository variable
`APM_AUTOMATION_APP_CLIENT_ID` and secret
`APM_AUTOMATION_APP_PRIVATE_KEY`. The App requires Contents and Pull
requests write permissions. Updates require review; no auto-merge.

## API and design

`GET /api/v1/greetings?name=Omer` returns a typed JSON response.
The implementation shows a feature-oriented package, thin controller,
service interface, DTO record, Jakarta input validation, Actuator,
structured JSON logging, and focused JUnit/AssertJ/Mockito tests.
There is no persistent data store or authentication requirement in this
minimal public demo.

The central rules are **not** copied by hand into this template; APM
deploys them from the registry. This directory lives outside the registry's
`.apm/` publication boundary.
