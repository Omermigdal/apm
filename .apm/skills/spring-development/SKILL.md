---
name: spring-development
description: "Implement, review, or troubleshoot Spring and Spring Boot applications, including web APIs, security, persistence, integration, reliability, and Spring tests."
---

# Spring development

Use this skill for Spring work and follow the applicable repository and Java instructions. The core Spring rules are in `.github/instructions/spring.instructions.md` when installed in a repository.

1. Inspect the affected code, tests, configuration, framework versions, web stack, dependencies, and public contracts.
2. Read only the references relevant to the task:
   - [Web APIs](references/web-api.md): endpoints, validation, security, forms, and clients.
   - [Data and transactions](references/data-and-transactions.md): persistence, consistency, and idempotency.
   - [Reliability](references/reliability.md): configuration, concurrency, observability, performance, and delivery.
3. Implement a focused change using current APIs supported by the project. Apply Jakarta APIs where required, without assuming all `javax` packages have Jakarta replacements.
4. Follow user and project permissions for validation. Report failures, unperformed checks, compatibility risks, and any required but unauthorized infrastructure or dependency changes.