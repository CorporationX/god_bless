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
        subjectListMap.put(subject,studentList);
    }

    public static void addStudentToSubjectList(Map<Subject, List<Student>> subjectListMap, Student student, Subject subject) {
       subjectListMap.get(subject).add(student);
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
