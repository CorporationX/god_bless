package faang.school.godbless.Maps.BJS2_19970;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private final int id;
    private String name;
    @EqualsAndHashCode.Exclude
    private Map<Subject, Integer> grades = new HashMap<>();

    public Student(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public Map<Subject, Integer> addSubject(Subject subject, int grade) {
        grades.putIfAbsent(subject, grade);
        return grades;
    }

    public Map<Subject, Integer> addSubject(Map<Subject, Integer> subjects) {
        subjects.forEach(grades::putIfAbsent);
        return grades;
    }

    public void printGrades() {
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
