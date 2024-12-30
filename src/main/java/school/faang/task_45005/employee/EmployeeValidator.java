package school.faang.task_45005.employee;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class EmployeeValidator {
    public static final String ERROR_NAME = "Name cannot be null or blank";
    public static final String ERROR_SKILLS = "Skills cannot be null or empty";
    public static final String ERROR_SKILLS_ITEMS = "Skills cannot contain null or blank strings";

    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            log.error(ERROR_NAME);
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    public static void validateSkills(Set<String> skills) {
        if (skills == null || skills.isEmpty()) {
            log.error(ERROR_SKILLS);
            throw new IllegalArgumentException(ERROR_SKILLS);
        }
        if (skills.stream().anyMatch(skill -> skill == null || skill.isBlank())) {
            log.error(ERROR_SKILLS_ITEMS);
            throw new IllegalArgumentException(ERROR_SKILLS_ITEMS);
        }
    }
}