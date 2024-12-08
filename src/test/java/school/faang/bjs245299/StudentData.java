package school.faang.bjs245299;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum StudentData {
    STUDENT1("STUDENT1", Map.of(
            new Subject("Math"), 5,
            new Subject("Lang"), 4
    )),
    STUDENT2("STUDENT2", Map.of(
            new Subject("Math"), 3,
            new Subject("Info"), 5
    )),
    STUDENT3("STUDENT3", Map.of(
            new Subject("Java"), 10,
            new Subject("Lang"), 4
    ));

    private final String name;
    private final Map<Subject, Integer> subjects;

    StudentData(String name, Map<Subject, Integer> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Student createStudent() {
        return new Student(this.name);
    }

    public Map<Subject, Integer> getSubjects() {
        return this.subjects;
    }
}
