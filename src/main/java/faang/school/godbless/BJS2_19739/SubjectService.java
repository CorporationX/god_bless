package faang.school.godbless.BJS2_19739;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class SubjectService {

    private final Map<Subject, List<Student>> subjects;

    public SubjectService(Map<Subject, List<Student>> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject, List<Student> students) {
        if (subjects.containsKey(subject)) {
            for (Student student : students) {
                if (!subjects.get(subject).contains(student)) {
                    subjects.get(subject).add(student);
                }
            }
        } else {
            subjects.put(subject, students);
        }
    }

    public void addStudent(Subject subject, Student student) {
        if (!subjects.containsKey(subject)) {
            throw new IllegalArgumentException("Subject " + subject + " does not exist");
        }
        subjects.get(subject).add(student);
    }

    public void removeStudent(Subject subject, Student student) {
        if (!subjects.containsKey(subject)) {
            throw new IllegalArgumentException("Subject " + subject + " does not exist");
        }
        subjects.get(subject).remove(student);
    }

    public void printSubjects() {
        subjects.forEach((subject, students) -> System.out.println(subject + ": " + students));
    }


}
