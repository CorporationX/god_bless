package cashcash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
public class Subject {
    private int id;
    private String name;

    public static void addSubject(Map<Subject, List<Student>> subjectListMap, Subject subject, List<Student> studentList) {
        if(!subjectListMap.containsKey(subject)) {
            subjectListMap.put(subject,studentList);
        } else {
            System.out.println("Предмет уже зарегестрирован в базе!");
        }
    }

    public static void addStudentToSubjectList(Map<Subject, List<Student>> subjectListMap, Student student, Subject subject) {
        if(subjectListMap.containsKey(subject)) {
            subjectListMap.get(subject).add(student);
        } else {
            System.out.println("Предмет не найде!");
        }
    }

    public static void removeStudentFromSubjectList(Map<Subject, List<Student>> subjectListMap, Student student, Subject subject) {
        subjectListMap.get(subject).remove(student);
    }

    public static void outputAllSubjects(Map<Subject, List<Student>> subjectListMap) {
        for (Map.Entry<Subject, List<Student>> pair : subjectListMap.entrySet()) {
            System.out.println(pair.getKey().getName() + ": " + pair.getValue());
        }
    }
}
