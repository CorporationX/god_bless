package school.faang.task_45005.project;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class ProjectValidator {
    private static final String ERROR_NAME = "The project name must not be null or blank.";
    private static final String ERROR_SKILLS = "The required skills set must not be null or empty.";
    private static final String ERROR_SKILLS_ITEMS = "The skills set must not contain null or blank entries.";

    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            log.error(ERROR_NAME);
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    public static void validateRequiredSkills(Set<String> requiredSkills) {
        if (requiredSkills == null || requiredSkills.isEmpty()) {
            log.error(ERROR_SKILLS);
            throw new IllegalArgumentException(ERROR_SKILLS);
        }
        if (requiredSkills.stream().anyMatch(skill -> skill == null || skill.isBlank())) {
            log.error(ERROR_SKILLS_ITEMS);
            throw new IllegalArgumentException(ERROR_SKILLS_ITEMS);
        }
    }
}