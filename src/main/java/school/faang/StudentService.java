package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StudentService {
    public static void addStudent(Student student, Subject subject, int grade,
                                  Map<Student, Map<Subject, Integer>> subjectsAndGradesMap,
                                  Map<Subject, List<Student>> studentSubjectMap) {
        subjectsAndGradesMap.putIfAbsent(student, Map.of(subject, grade));
        if (!studentSubjectMap.containsKey(subject)) {
            studentSubjectMap.put(subject, new ArrayList<>());
            List<Student> streamEventList = new ArrayList<>();
            streamEventList.add(student);
            studentSubjectMap.put(subject, streamEventList);
        } else {
            List<Student> streamEventList = studentSubjectMap.get(subject);
            streamEventList.add(student);
            studentSubjectMap.put(subject, streamEventList);
        }
    }

    public static void addSubjectsAndGrades(Student student, Subject subject, int grade,
                                            Map<Student, Map<Subject, Integer>> subjectsAndGradesMap) {
        if (subjectsAndGradesMap.containsKey(student)) {
            Map<Subject, Integer> gradesMap = subjectsAndGradesMap.get(student);
            if (gradesMap == null) {
                gradesMap = new HashMap<>();
                subjectsAndGradesMap.put(student, gradesMap);
            }
            gradesMap.put(subject, grade);
        } else {
            System.out.println("user not found");
        }
    }

    public static void removeStudent(Student student, Map<Student, Map<Subject, Integer>> subjectsAndGradesMap,
                                     Map<Subject, List<Student>> studentSubjectMap){
        subjectsAndGradesMap.remove(student);
        for (Map.Entry<Subject, List<Student>> pair : studentSubjectMap.entrySet()) {
            List<Student> studentList = pair.getValue();
            Iterator<Student> iterator = studentList.iterator();

            while (iterator.hasNext()) {
                Student studentI = iterator.next();

                if (studentI.equals(student)) {
                    iterator.remove();
                }
            }
        }

    }

    public static void viewAllStudents(Map<Student, Map<Subject, Integer>> subjectsAndGradesMap,
                                       Map<Subject, List<Student>> studentSubjectMap) {
        studentSubjectMap.forEach((k, v) -> {
            System.out.println(k.getName() + ": " + subjectsAndGradesMap.toString());
        });
    }
}
