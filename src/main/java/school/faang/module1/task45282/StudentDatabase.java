package school.faang.module1.task45282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();

    private final Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public void addStudentWithSubjects(final Student student, final Map<Subject, Integer> subjects) {
        //Положили в map по ключу студента и значению мапы
        studentMap.put(student, subjects);

        //из subjects вытаскиваем keySet() получается Subject
        //проходимся по нему
        for (final Subject subject : subjects.keySet()) {
            subjectMap.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
		/*if (!subjectMap.containsKey(subject)) {
			subjectMap.put(subject, new ArrayList<>());
		}
		subjectMap.get(subject).add(student);*/
        }
    }

    public void addSubject(final Student student, final Subject subject, final Integer grade) {
        if (!studentMap.containsKey(student)) {
            throw new IllegalArgumentException("..");
        }
        studentMap.get(student).put(subject, grade);
        subjectMap.putIfAbsent(subject, new ArrayList<>());
        if (!subjectMap.get(subject).contains(student)) {
            subjectMap.get(subject).add(student);
        }
    }

    public void removeStudent(final Student student) {
        final Map<Subject, Integer> studentSubjects = studentMap.remove(student);
        for (final Subject subject : studentSubjects.keySet()) {
            //Optional.ofNullable(subjectMap.get(subject)).ifPresent(students -> students.remove(student));
            if (subjectMap.get(subject) != null) {
                subjectMap.get(subject).remove(student);
                if (subjectMap.get(subject).isEmpty()) {
                    subjectMap.remove(subject);
                }
            }
        }
    }

    public void printStudents() {
        studentMap.entrySet().stream()
                .map(e -> String.format("%s - %s", e.getKey(), mapValue(e.getValue())))
                .forEach(System.out::println);
    }

    private String mapValue(final Map<Subject, Integer> subjects) {
        return subjects.entrySet().stream()
                .map(e -> String.format("%s - %d", e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));
    }
}
