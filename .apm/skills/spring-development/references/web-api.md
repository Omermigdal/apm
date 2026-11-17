# Web APIs and security

## Controllers and contracts

- Keep request mapping, validation, delegation, and response construction at the web boundary; keep business and persistence logic out of controllers. Use HTTP-specific types such as `ResponseEntity` at that boundary where practical.
- Preserve existing endpoint, JSON, status, and error contracts. For new APIs, choose response types and envelopes appropriate to the use case rather than imposing one universal envelope. Use DTOs where needed to prevent accidental exposure of entities or sensitive fields.
- For new APIs, prefer version-first paths where appropriate, plural kebab-case resource names, descriptive path parameters, and clear action segments. Preserve existing paths and standard HTTP method semantics.
- Keep OpenAPI documentation aligned with the implementation or spec. Do not create a separate Swagger interface for information already deducible from annotations; put additional non-deduced documentation in a separate interface and avoid boilerplate in controllers.
- Use typed DTO responses with `RestClient`; do not use `body(String.class)`. Handle HTTP and transport failures explicitly and configure timeouts according to the integration's requirements.

## Validation and handling

- Validate request bodies and parameters at the boundary with Jakarta Bean Validation where applicable, plus domain checks. Return all validation errors together; use dedicated validators for complex validation rules. Preserve established error contracts.
- Bind forms to dedicated input objects and restrict writable fields. Place `BindingResult` immediately after its corresponding bound parameter. Use appropriate Spring conversion and binding facilities rather than ad hoc controller parsing.
- Choose parameter requiredness, defaults, and path constraints according to the endpoint contract. Validate untrusted path, query, header, and cookie values; never trust a header for authorization without server-side validation.
- Map expected errors to deterministic HTTP status codes and safe responses; return a 400 for malformed requests when consistent with the API contract. Do not expose stack traces, internal details, or success-shaped responses for failures.
- Follow the application's servlet or reactive stack. Do not block reactive execution paths. Preserve existing media type contracts.

## Security and forms

- Apply authentication and authorization at the appropriate boundaries. When using JWTs, validate signatures, issuer, audience, and relevant claims.
- Apply CSRF protection according to the authentication and client architecture. Restrict CORS origins, methods, headers, and credentials according to the trust model; never combine wildcard origins with credentials. Validate redirects and encode output for its actual context.
- Avoid logging sensitive data or uncontrolled user input; prevent log injection with the project's appropriate controls.
- For server-rendered forms, use post/redirect/get after successful submission where appropriate and flash attributes for one-time messages. Validate redirects, keep session state minimal, and remove it when no longer needed.