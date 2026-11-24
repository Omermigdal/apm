---
description: "Repository workflow and change-safety rules for Java and Spring development."
applyTo: "**"
---

# Project workflow

- Inspect the relevant code, build, and tests before changing behavior. Reuse existing components and avoid unrelated changes.
- Preserve public contracts unless a change is requested. For changes to shared APIs or schemas, assess compatibility and consuming applications.
- Target Java 25. For Spring Boot projects, this guidance covers Spring Boot 4.x. Use the project's configured minor and patch versions and verify API, starter, and configuration changes against that release's documentation. Keep dependency versions managed by the Spring Boot parent or BOM where applicable. Report incompatibilities and seek authorization before changing the platform version.
- Follow user and project validation permissions. When validation is authorized, run the smallest relevant check and report failures or checks not performed. Prefer quiet, noninteractive Maven output when appropriate.
- Use existing static-analysis tools only when relevant and authorized; do not prompt to set up tools for every task. Do not silently add tools, dependencies, or CI configuration.
- Keep secrets and sensitive data out of code, logs, fixtures, and responses.
