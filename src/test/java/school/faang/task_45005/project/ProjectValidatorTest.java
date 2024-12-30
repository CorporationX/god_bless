package school.faang.task_45005.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ProjectValidatorTest: Tests for ProjectValidator class")
class ProjectValidatorTest {

    @Test
    @DisplayName("validateRequiredSkills: should throw exception when requiredSkills is null")
    void validateRequiredSkills_shouldThrowExceptionWhenRequiredSkillsIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ProjectValidator.validateRequiredSkills(null),
                "validateRequiredSkills should throw an exception when requiredSkills is null.");
        assert (exception.getMessage().contains("The required skills set must not be null or empty.")) :
                "Expected error message to include 'The required skills set must not be null or empty.'";
    }

    @Test
    @DisplayName("validateRequiredSkills: should throw exception when requiredSkills is empty")
    void validateRequiredSkills_shouldThrowExceptionWhenRequiredSkillsIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ProjectValidator.validateRequiredSkills(Set.of()),
                "validateRequiredSkills should throw an exception when requiredSkills is empty.");
        assert (exception.getMessage().contains("The required skills set must not be null or empty.")) :
                "Expected error message to include 'The required skills set must not be null or empty.'";
    }

    @Test
    @DisplayName("validateRequiredSkills: should throw exception when requiredSkills contains null skill")
    void validateRequiredSkills_shouldThrowExceptionWhenRequiredSkillsContainsNullSkill() {
        Set<String> skillsWithNull = new HashSet<>();
        skillsWithNull.add("Java");
        skillsWithNull.add(null);
        skillsWithNull.add("Python");

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ProjectValidator.validateRequiredSkills(skillsWithNull),
                "validateRequiredSkills should throw an exception when requiredSkills contains null elements.");
        assertTrue(exception.getMessage().contains("The skills set must not contain null or blank entries."),
                "Expected error message to include 'The skills set must not contain null or blank entries.'");
    }

    @Test
    @DisplayName("validateRequiredSkills: should throw exception when requiredSkills contains blank skill")
    void validateRequiredSkills_shouldThrowExceptionWhenRequiredSkillsContainsBlankSkill() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ProjectValidator.validateRequiredSkills(Set.of("Java", "  ", "Python")),
                "validateRequiredSkills should throw an exception when requiredSkills contains blank elements.");
        assert (exception.getMessage().contains("The skills set must not contain null or blank entries.")) :
                "Expected error message to include 'The skills set must not contain null or blank entries.'";
    }

    @Test
    @DisplayName("validateRequiredSkills: should pass when all requiredSkills are valid")
    void validateRequiredSkills_shouldPassWhenAllRequiredSkillsAreValid() {
        Set<String> validSkills = Set.of("Java", "Python", "AWS");

        try {
            ProjectValidator.validateRequiredSkills(validSkills);
        } catch (Exception e) {
            assert false : "validateRequiredSkills should not throw an exception when all skills are valid.";
        }
    }
}