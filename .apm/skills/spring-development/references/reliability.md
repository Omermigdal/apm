# Reliability, configuration, and delivery

- Externalize configuration and secrets. Bind related settings to validated configuration properties; fail clearly for missing required settings. Use profiles where useful without unnecessary profile proliferation.
- Keep singleton components free of request-specific mutable state. For asynchronous work, use current Spring and Java mechanisms; bound executors and queues where appropriate, set timeouts, and handle timeout and failure outcomes explicitly.
- Consider virtual threads for suitable blocking workloads after measuring the effect; they do not replace timeouts, resource limits, or deterministic test synchronization.
- Apply pagination, caching, batching, streaming, connection-pool tuning, and query/client timeouts according to the workload. Retry only when the failure mode and operation make it safe; consider idempotency, backoff, limits, and cancellation.
- Reuse existing structured logs, correlation, Micrometer metrics, OpenTelemetry tracing, and health/readiness/liveness infrastructure as required by the core Spring rules. Do not log secrets or sensitive data.
- Recommend appropriate CI formatting, static analysis, dependency and image vulnerability checks, secret scanning, and failure thresholds. Do not configure tools or infrastructure without authorization.
- Use the project's available testing skill when relevant; do not assume a particular skill exists. Apply the Java test rules and user/project validation permissions.