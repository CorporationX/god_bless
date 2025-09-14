package school.faang.bjs2_86940_1_1_3_4_double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    private Map<Student, >

    public void addNewStudentInfo(Student student, Map<Subject, Integer> info) {
        studentSubjects.put(student, info);
        for (Map.Entry<Subject, Integer> entry : info.entrySet()) {
            subjectStudents.putIfAbsent(entry.getKey(), new ArrayList<Student>());
            subjectStudents.get(entry.getKey()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.putIfAbsent(student, new HashMap<Subject, Integer>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<Student>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudent(Student student){

    }

}
