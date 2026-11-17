# Consolidation traceability

This is a topic-level map of the six source files, not a claim that every example or sentence was copied. The decisions below identify intentionally changed, generalized, or omitted guidance. Original files remain unchanged.

## Destination key

- **Workflow**: `.github/copilot-instructions.md`
- **Java**: `.github/instructions/java.instructions.md`
- **Spring**: `.github/instructions/spring.instructions.md`
- **Web**: `.github/skills/spring-development/references/web-api.md`
- **Data**: `.github/skills/spring-development/references/data-and-transactions.md`
- **Reliability**: `.github/skills/spring-development/references/reliability.md`

## Source coverage

| Original | Sections | Destination or disposition |
|---|---|---|
| java-instructions-1 | General/static analysis | Workflow; mandatory Sonar setup, fallback installation, and issue creation removed by decision. |
| java-instructions-1 | Best practices, naming, bugs, smells | Java; project formatting and conditional idioms replace blanket style and feature mandates. |
| java-instructions-1 | Build and verification | Workflow; authorized, focused checks replace mandatory clean install/build. |
| java-instructions-2 | Workflow and Maven | Workflow and skill; product-specific skill and module references removed, exact Maven flags not mandatory. |
| java-instructions-2 | Testing | Java; libraries, touched-test alignment, naming, test structure, slices, async waiting, and guard tests incorporated with user-selected changes. |
| java-instructions-2 | Change hygiene | Java and Data; 500 lines is a signal, deprecated APIs allow compatibility exceptions, shared-consumer verification requires authorization. |
| java-instructions-2 | Java, Jackson, Lombok | Java and Spring; enum fallback and date/time rules generalized, Jackson 3 and selected Lombok restrictions retained. |
| java-instructions-2 | Logging and exceptions | Java and Spring; project logging style and central handling replace mandatory message prefix and duplicate logging. |
| spring-instructions-1 | General, dependency injection, configuration | Workflow, Java, Spring, and Reliability; constructor injection retained, YAML for new projects, existing properties preserved unless migration requested. |
| spring-instructions-1 | Organization, service, logging, security | Spring and Web; feature organization and interfaces for major boundaries required, parameterized queries and context-sensitive security retained. |
| spring-instructions-1 | Build and useful commands | Workflow; command table omitted, validation follows user/project permissions. |
| spring-instructions-2 | Controller design and dependency injection | Spring and Web; field injection and JSON-map mandates replaced by constructor injection and appropriate contracts. |
| spring-instructions-2 | Form binding, validation, exceptions | Web and Spring; safe binding and validation retained, central exception handling replaces controller-wide catches. |
| spring-instructions-2 | Session, REST, security, performance, logging | Web, Data, Reliability, Java; session and security guidance conditional; response envelope, blanket CSRF, global JSON setting, and blanket caching changed by decision. |
| spring-instructions-2 | Request parameters and status codes | Web; retain contract-based defaults, validation, and appropriate statuses instead of mandatory parameter defaults and a status table. |
| spring-instructions-2 | Redirect and forms | Web; conditional server-rendered form and session guidance retained. |
| spring-instructions-2 | Content negotiation, WebMvcConfigurer, conversion, internationalization | Detailed infrastructure and localization guidance omitted by decision 28B; safe form binding remains under decision 19B. |
| spring-instructions-2 | CORS | Web; context-sensitive trust and credential guidance replaces blanket rules. |
| spring-instructions-2 | Async | Reliability; bounded execution and timeouts retained; legacy `web.xml` and old-style examples omitted by decision. |
| spring-instructions-2 | Idempotency and review checklist | Data, Java, and Spring; conditional duplicate protection and a requested review rubric replace universal POST tokens. |
| spring-instructions-3 | Architecture, API, validation, services | Spring and Web; retain principles with user-selected feature packaging, interfaces, documentation, and validation rules. |
| spring-instructions-3 | Data access and transactions | Data; technology details remain conditional rather than mandating specific databases. |
| spring-instructions-3 | Security, configuration, observability | Spring, Web, and Reliability; JWT controls, configuration and security retained; instrumentation and probes required for service changes. |
| spring-instructions-3 | Testing, performance, delivery | Java and Reliability; test libraries and focused tests retained, performance and CI tooling conditional. |
| spring-instructions-3 | Adoption, output expectations, anti-patterns, rubric | Java, Spring, skill, and Reliability; Java 25/current Spring replace older baseline, review rubric required, virtual threads conditional. |
| spring-instructions-4 | Injection and configuration | Spring; Lombok injection retained, format migration and property naming made context-sensitive. |
| spring-instructions-4 | Layering, REST controllers and clients | Spring and Web; exception translation allowed, redundant Swagger interfaces removed, typed `RestClient` bodies required. |

## Recorded decisions

These are the selections from the decision sheet, including free-form clarifications:

1. Align every touched test with the test standard.
2. Change touched tests; do not use a full context when it is not needed.
3. Keep write-side and read-side idempotency tests when guards are introduced or changed.
4. Prefer records for new DTOs; convert touched data carriers that need changing, subject to compatibility.
5. Avoid introducing nulls; use `Optional` where appropriate and preserve contracts.
6. Make immutability, collection, and stream idioms conditional on semantics and readability.
7. Prefer supported replacements; allow a documented compatibility exception for deprecated APIs.
8. Follow project formatting and naming conventions.
9. Treat maintainability guidance and the 500-line threshold as context-sensitive.
10. Assess shared-library consumers and verify them subject to validation permissions.
11. Require Jackson 3 for Spring projects.
12. Preserve existing unknown-JSON-field behavior and API contracts.
13. Prevent log injection without mandating an encoder library.
14. Keep HTTP-specific response types at the web boundary where practical.
15. Select a response contract suitable for the use case rather than imposing one envelope.
16. Recommend the original REST path conventions for new APIs where appropriate.
17. Avoid Swagger interfaces for deducible information; put additional non-deduced documentation in a separate interface and avoid boilerplate controllers.
18. Require typed `RestClient` responses; do not use `body(String.class)`.
19. Return all validation errors together; use dedicated validators for complex rules.
20. Select request defaults, requiredness, and constraints based on the endpoint contract.
21. Apply CSRF and CORS according to architecture and trust requirements.
22. Apply authorization at appropriate boundaries and validate JWTs when used.
23. Retain MongoDB and relational persistence advice as conditional references.
24. Select transactions and cross-system consistency strategies according to actual requirements.
25. Add duplicate protection when the operation and retries require it.
26. Retain server-rendered form and session guidance conditionally.
27. Avoid legacy-style coding; retain modern async and timeout guidance.
28. Omit detailed MVC infrastructure and localization guidance.
29. Retain profiles and configuration-properties guidance conditionally.
30. Apply performance and resilience techniques according to workload.
31. Require structured logging, Micrometer, OpenTelemetry, and probes for service changes.
32. Recommend CI/security checks only with project and user authorization.
33. Require feature-oriented packaging and interfaces for major boundaries.
34. Require a Green/Yellow/Red rubric for every Spring task or review.
35. Pin Spring Boot 4.1.2 until intentionally updated.
36. Use relevant skills only when available; keep essential rules in instructions.

The user also selected constructor injection with `@RequiredArgsConstructor`, the listed Lombok restrictions, JUnit 5/Mockito/AssertJ, camelCase `given...When...Then...` names, test helpers after tests, deterministic async synchronization, authorized focused validation, no per-task static-analysis setup prompt, project logging style, YAML for new projects or requested migrations, project property namespaces, contract-driven enum lookup and date/time types, and context-sensitive modern Java idioms.

## Operational boundaries

Requiring Jackson 3, Lombok, or observability may conflict with an existing project's dependencies. The bundle directs agents to report the gap and seek authorization before introducing dependencies or migrations; it does not pretend those requirements have been met. Existing APIs and configuration are not silently migrated.
