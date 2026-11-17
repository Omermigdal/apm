---
description: "Core Spring and Spring Boot conventions."
applyTo: "**/*.java,**/application*.properties,**/application*.yml,**/application*.yaml"
---

# Spring

Apply these rules only when working with Spring components, configuration, clients, web endpoints, persistence, or Spring tests.

- Use constructor injection for required dependencies, with final fields and Lombok `@RequiredArgsConstructor`; write a constructor explicitly when custom constructor logic is required.
- Use feature-oriented packaging and interfaces for major service or integration boundaries. Keep controllers thin, services stateless, and infrastructure concerns separated. Preserve existing contracts and avoid unrelated restructuring.
- Validate input at boundaries. Use centralized exception handling where appropriate; map failures to suitable HTTP responses without exposing internals. Translate exceptions only when adding meaningful context, preserving the cause, and avoid duplicate logging.
- Use Jackson 3 as the JSON library in Spring projects: import core and databind types from `tools.jackson` and annotations from `com.fasterxml.jackson.annotation`. Preserve existing serialization and unknown-field contracts. If migration or dependencies are needed, report that and obtain authorization rather than silently changing the project.
- Use YAML for new application configuration; preserve an existing properties-based application unless YAML migration is requested. Bind related settings to validated `@ConfigurationProperties`, following the existing namespace and naming conventions.
- Protect secrets and sensitive data; apply parameterized queries, authorization, CSRF, CORS, and output encoding appropriate to the application's threat model and clients.
- For each service change, ensure structured logs and correlation, Micrometer metrics, OpenTelemetry tracing, and health, readiness, and liveness probes are present. Reuse existing infrastructure; if a required capability is absent, report the gap and seek authorization before adding infrastructure or dependencies.
- For every Spring task or review, include a concise Green/Yellow/Red assessment of API contract, validation/errors, service separation, data access, security, observability, test coverage, and configuration. Mark unexamined areas as not assessed.
- Use the `spring-development` skill when available for task-specific guidance. Core rules remain here because skill activation can vary by client.