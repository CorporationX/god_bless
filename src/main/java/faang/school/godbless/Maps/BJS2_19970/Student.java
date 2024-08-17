package faang.school.godbless.Maps.BJS2_19970;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@ToString

public class Student {
    private final int id;
    private String name;
    private Map<Subject, Integer> grades = new HashMap<>();

    public Student(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Map<Subject, Integer> addSubject(Subject subject, int grade){
        grades.putIfAbsent(subject, grade);
        return grades;
    }
    public Map<Subject, Integer> addSubject(Map<Subject, Integer> subjects){
        subjects.forEach(grades::putIfAbsent);
        return grades;
    }

    public void printGrades(){
        for(Map.Entry<Subject , Integer> entry : grades.entrySet()){
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
