package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrade(String studentName, List<GradedItem> gradedItems) {
        Student currentStudent = new Student(studentName);
        Map<Subject, Integer> currentStudentGrade = studentSubjects.get(currentStudent) == null
                ? new HashMap<>() : studentSubjects.get(currentStudent);
        for (GradedItem gradedItem : gradedItems) {
            Subject currentSubject = new Subject(gradedItem.subjectName());
            currentStudentGrade.put(currentSubject, gradedItem.mark());
            subjectStudents.computeIfAbsent(currentSubject, sub -> new HashSet<>())
                    .add(currentStudent);
        }
        studentSubjects.put(currentStudent, currentStudentGrade);
    }

    public void addSubjectWithStudents(String subjectName, List<String> studentNames) {
        Subject currentSubject = new Subject(subjectName);
        Set<Student> studentBySubject = subjectStudents.get(currentSubject) == null
                ? new HashSet<>() : subjectStudents.get(currentSubject);
        for (String studentName : studentNames) {
            Student currentStudent = new Student(studentName);
            studentBySubject.add(currentStudent);
            studentSubjects.computeIfAbsent(currentStudent,
                    student -> new HashMap<>()).putIfAbsent(currentSubject, null);
        }
        subjectStudents.put(currentSubject, studentBySubject);
    }

    public void deleteStudentByName(String studentName) {
        Student studentForDeleting = new Student(studentName);
        if (studentSubjects.containsKey(studentForDeleting)) {
            Set<Subject> subjectByStudent = studentSubjects.get(studentForDeleting).keySet();
            for (Subject subject : subjectByStudent) {
                subjectStudents.get(subject).remove(studentForDeleting);
            }
            studentSubjects.remove(studentForDeleting);
        }
    }

    public void deleteStudentFromSubject(String studentName, String subjectName) {
        Student studentForDeleting = new Student(studentName);
        Subject currentSubject = new Subject(subjectName);
        if (studentSubjects.containsKey(studentForDeleting)) {
            studentSubjects.get(studentForDeleting).remove(currentSubject);
        }
        if (subjectStudents.containsKey(currentSubject)) {
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
        for (Map.Entry<Subject, Set<Student>> entry : subjectStudents.entrySet()) {
            resultList.append(entry.getKey().getName()).append(": ").append(entry.getValue().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", ")));
            resultList.append("\n");
        }
        System.out.println(resultList);
    }


}
