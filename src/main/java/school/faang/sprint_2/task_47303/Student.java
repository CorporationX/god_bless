package school.faang.sprint_2.task_47303;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Student {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    private final Map<String, List<Integer>> subjects;

    @JsonCreator
    public Student(@JsonProperty("firstName") @NonNull String firstName,
                   @JsonProperty("lastName") @NonNull String lastName,
                   @JsonProperty("subjects") @NonNull Map<String, List<Integer>> subjects) {
        this.id = idGenerator.getAndIncrement();
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
