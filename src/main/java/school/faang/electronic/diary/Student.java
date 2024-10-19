package school.faang.electronic.diary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> courses;

    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("subjects") Map<String, List<Integer>> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
