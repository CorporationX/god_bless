package school.faang.task_45005.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("EmployeeValidatorTest: Validation tests for EmployeeValidator")
class EmployeeValidatorTest {

    @Test
    @DisplayName("validateSkills: should throw IllegalArgumentException when skills are null")
    void validateSkills_shouldThrowExceptionWhenSkillsAreNull() {
        Set<String> skills = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeValidator.validateSkills(skills), "Expected exception for null skills was not thrown");
        assert exception.getMessage().equals(EmployeeValidator.ERROR_SKILLS) : "Unexpected error message";
    }

    @Test
    @DisplayName("validateSkills: should throw IllegalArgumentException when skills are empty")
    void validateSkills_shouldThrowExceptionWhenSkillsAreEmpty() {
        Set<String> skills = Set.of();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeValidator.validateSkills(skills), "Expected exception for empty skills was not thrown");
        assert exception.getMessage().equals(EmployeeValidator.ERROR_SKILLS) : "Unexpected error message";
    }

    @Test
    @DisplayName("validateSkills: should throw IllegalArgumentException when skills contain null or blank strings")
    void validateSkills_shouldThrowExceptionWhenSkillsContainNullOrBlankStrings() {
        Set<String> skills = new HashSet<>();
        skills.add("Java");
        skills.add(" ");
        skills.add(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        EmployeeValidator.validateSkills(skills),
                "Expected exception for null or blank entries in skills was not thrown");
        assert exception.getMessage().equals(EmployeeValidator.ERROR_SKILLS_ITEMS) : "Unexpected error message";
    }

    @Test
    @DisplayName("validateSkills: should not throw exception when skills are valid")
    void validateSkills_shouldNotThrowExceptionWhenSkillsAreValid() {
        Set<String> skills = Set.of("Java", "Kotlin", "Python");

        try {
            EmployeeValidator.validateSkills(skills);
        } catch (Exception e) {
            assert false : "Exception was thrown for valid skills: " + e.getMessage();
        }
    }
}