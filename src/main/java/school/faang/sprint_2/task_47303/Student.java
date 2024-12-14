package school.faang.sprint_2.task_47303;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
public class Student {
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    private final Map<String, List<Integer>> subjects;

    @JsonCreator
    public Student(@JsonProperty("firstName") @NonNull String firstName,
                   @JsonProperty("lastName") @NonNull String lastName,
                   @JsonProperty("subjects") @NonNull Map<String, List<Integer>> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public void addCourse(@NonNull String courseName, @NonNull List<Integer> courseDegrees) {
        subjects.put(courseName, courseDegrees);
    }

    public void removeCourse(@NonNull String courseName) {
        subjects.remove(courseName);
    }

    public Map<String, List<Integer>> getSubjects() {
        return Map.copyOf(subjects);
    }
}
