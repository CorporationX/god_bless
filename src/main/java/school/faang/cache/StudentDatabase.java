package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    // локальная база для поиска по имени
    private final Map<String, Student> studentLocalDatabase = new HashMap<>();
    private final Map<String, Subject> subjectLocalDatabase = new HashMap<>();


    public void addStudentWithGrade(String studentName, List<GradedItem> gradedItems) {
        Student currentStudent = studentLocalDatabase.computeIfAbsent(studentName, name -> new Student(studentName));
        Map<Subject, Integer> currentStudentGrade = studentSubjects.get(currentStudent) == null ? new HashMap<>() : studentSubjects.get(currentStudent);
        for (GradedItem gradedItem : gradedItems) {
            Subject currentSubject = subjectLocalDatabase.computeIfAbsent(gradedItem.subjectName(), name -> new Subject(gradedItem.subjectName()));
            currentStudentGrade.put(currentSubject, gradedItem.mark());
            List<Student> students = subjectStudents.computeIfAbsent(currentSubject, sub -> new ArrayList<>());
            if (!students.contains(currentStudent)) {
                students.add(currentStudent);
            }
        }
        studentSubjects.put(currentStudent, currentStudentGrade);
    }

    public void addSubjectWithStudents(String subjectName, List<String> studentNames) {
        Subject currentSubject = subjectLocalDatabase.computeIfAbsent(subjectName, name -> new Subject(subjectName));
        List<Student> studentBySubject = subjectStudents.get(currentSubject) == null ? new ArrayList<>() : subjectStudents.get(currentSubject);
        for (String studentName : studentNames) {
            Student currentStudent = studentLocalDatabase.computeIfAbsent(studentName, name -> new Student(studentName));
            if (!studentBySubject.contains(currentStudent)) {
                subjectStudents.computeIfAbsent(currentSubject, sub -> new ArrayList<>()).add(currentStudent);
            }
            studentSubjects.computeIfAbsent(currentStudent, student -> new HashMap<>()).putIfAbsent(currentSubject, null);
        }
    }

    public void deleteStudentByName(String studentName) {
        Student studentForDeleting = studentLocalDatabase.get(studentName);
        if (studentForDeleting != null) {
            Set<Subject> subjectByStudent = studentSubjects.get(studentForDeleting).keySet();
            for (Subject subject : subjectByStudent) {
                subjectStudents.get(subject).remove(studentForDeleting);
            }
        }
        studentSubjects.remove(studentForDeleting);
    }

    public void deleteStudentFromSubject(String studentName, String subjectName) {
        Student studentForDeleting = studentLocalDatabase.get(studentName);
        if (studentForDeleting != null) {
            Subject currentSubject = subjectLocalDatabase.computeIfAbsent(subjectName, name -> new Subject(subjectName));
            studentSubjects.get(studentForDeleting).remove(currentSubject);
            subjectStudents.get(currentSubject).remove(studentForDeleting);
        }
    }


    public void printStudentWithGrade() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            StringBuilder resultList = new StringBuilder(entry.getKey().getName()).append(" [");
            entry.getValue().forEach((key, value) -> {
                resultList.append(key.getName()).append(": ");
                resultList.append(value).append(" ");
            });
            resultList.append("] ");
            System.out.println(resultList);
        }
    }

    public void printSubjectWithStudents() {
        StringBuilder resultList = new StringBuilder();
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            resultList.append(entry.getKey().getName()).append(": ").append(entry.getValue().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", ")));
            resultList.append("\n");
        }
        System.out.println(resultList);
    }


}
