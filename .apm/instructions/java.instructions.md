---
description: "Java 25 conventions for implementation and tests."
applyTo: "**/*.java,**/pom.xml,**/*.gradle,**/*.gradle.kts"
---

# Java 25

## Code

- Follow the project's configured formatter, naming, architecture, and public contracts. Search existing code before introducing new types or abstractions.
- Use top-level types and normal imports; do not use nested classes, wildcard imports, or fully qualified class names in code. Remove unused imports and code made obsolete by the change.
- Prefer records for new DTOs. When a data carrier needs changes, convert it to a record when compatible with its contract and framework requirements; do not rewrite unrelated carriers.
- Favor immutable state and final fields/classes where appropriate. Use immutable collection factories and `Stream.toList()` only when their semantics fit. Use streams, lambdas, and method references when they improve clarity.
- Prefer pattern matching, text blocks, and `getFirst()` when they improve clarity. Use `var` only when the initializer makes the type obvious. Do not use preview features unless enabled and appropriate for the task.
- Avoid introducing nulls; use `Optional` where it fits and preserve existing nullability contracts. Choose `java.time` types for the required temporal semantics. Choose enum lookup and unknown-value behavior according to the API contract.
- Compare enums with `==` and other objects by value when appropriate. Close owned resources with try-with-resources. Avoid unchecked casts, unreachable conditions, broad catches, and hidden failures.
- Keep methods cohesive and parameter lists understandable; reduce unnecessary branching and use named constants for meaningful repeated values. Treat a file exceeding 500 lines as a signal to consider extraction, not an automatic split.
- Prefer supported APIs over deprecated ones; allow a documented exception when required for compatibility or no suitable replacement exists.
- Follow the project's SLF4J logging style and select levels by operational significance. Use parameterized messages; include the throwable when logging exceptions. Avoid duplicate logs, secrets, sensitive data, and log injection.
- Lombok: use `@Data` only for mutable carriers; `@Builder` only for types with more than one field; `@Slf4j` for logging; `@UtilityClass` for utility and constant-holder classes; and `@SneakyThrows` only with an explicit exception type.

## Tests

- Align every touched test with the testing conventions below. Use JUnit 5, Mockito, and AssertJ for new and changed tests. Name test methods `given...When...Then...` in camelCase and place helper methods after tests.
- Prefer explicitly constructing the class under test; allow `@InjectMocks` where appropriate. Use constructor injection for Spring-managed test dependencies; Mockito `@Mock` fixtures are not Spring injection.
- Prefer unit tests or Spring slices. Use a full application context only when required to verify the behavior. Cover changed behavior and relevant boundary, authorization, and error cases.
- Avoid timing-dependent sleeps. Use deterministic synchronization such as futures or latches, and Awaitility for condition polling when appropriate.
- When introducing or changing an idempotency guard, test both the successful recording of the key or flag and the subsequent duplicate being skipped.