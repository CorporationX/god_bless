package school.faang;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
public class Job {
    private final String position;
    private final List<String> requirements;
    private final int salary;
    private final String location;
    private final LocalDate datePosted;

    @JsonCreator
    public Job(
            @JsonProperty("position") String position,
            @JsonProperty("requirements") List<String> requirements,
            @JsonProperty("salary") int salary,
            @JsonProperty("location") String location,
            @JsonProperty("datePosted") LocalDate datePosted) {

        validateString(position, "position");
        validateString(location, "location");
        validateSalary(salary);
        validateLocalDate(datePosted);
        validateRequirements(requirements);

        this.position = position;
        this.requirements = requirements;
        this.salary = salary;
        this.location = location;
        this.datePosted = datePosted;
    }

    private void validateString(String string, String name) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("The " + name + " can't be null or blank.");
        }
    }

    private void validateSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("The salary can't be less than 0.");
        }
    }

    private void validateLocalDate(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException("The date can't be null.");
        } else if (localDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The date can't be from future.");
        }
    }

    private void validateRequirements(List<String> requirements) {
        if (requirements == null) {
            throw new IllegalArgumentException("The requirement list can't be null.");
        }
    }
}
