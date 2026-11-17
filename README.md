# Reusable Java and Spring agent guidance

This bundle consolidates the supplied Java and Spring guidance and the user's recorded decisions. It contains no application-specific paths, APIs, or business-domain assumptions.

## Installation

Copy the contents of `.github/` into a repository, merging with existing instructions and skills rather than overwriting them. Review and remove or reconcile conflicting legacy instructions.

The target is Java 25 and Spring Boot 4.1.2, pinned until deliberately updated. Spring Boot's published system requirements list Java 25 as compatible. Do not silently migrate an existing project or add required dependencies without authorization. Review the conventions before sharing with a team.

## Contents

- `.github/copilot-instructions.md`: repository-wide workflow.
- `.github/instructions/java.instructions.md`: Java and test conventions.
- `.github/instructions/spring.instructions.md`: essential Spring rules and review rubric.
- `.github/skills/spring-development/SKILL.md`: on-demand workflow and three focused references.
- `TRACEABILITY.md`: source coverage and deliberately changed or excluded guidance.

Client support and skill activation vary. Confirm that your client discovers the instructions and skill. The documents are guidance, not a guarantee of agent behavior.

References: [Spring Boot system requirements](https://docs.spring.io/spring-boot/system-requirements.html), [Spring Boot JSON](https://docs.spring.io/spring-boot/reference/features/json.html), [Copilot custom instructions](https://docs.github.com/en/copilot/concepts/prompting-and-context/custom-instructions), and [Agent Skills](https://agentskills.io/specification).
