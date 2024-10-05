package school.faang.doublecache_BJS2_32438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRegistration {

    private HashMap<Student, Map<Subject, Integer>> studentsMap = new HashMap<>();
    private HashMap<Subject, List<Student>> subjectsMap = new HashMap<>();

    public void addStudent(Student newStudent, Map<Subject, Integer> newSubjects) {

        var curSubjects = studentsMap.computeIfAbsent(newStudent, (k) -> new HashMap<>());

        for (Map.Entry<Subject, Integer> subjectIntegerEntry : newSubjects.entrySet()) {
            if (subjectsMap.containsKey(subjectIntegerEntry.getKey())) {
                curSubjects.put(subjectIntegerEntry.getKey(), subjectIntegerEntry.getValue());
                addToSubjectsMap(subjectIntegerEntry.getKey(), newStudent);
            }
        }
    }

    public void addSubjectForExistStudent(Student student, Subject subject, Integer rating) {

        if (!studentsMap.containsKey(student)) {
            return;
        }

        if (!subjectsMap.containsKey(subject)) {
            studentsMap.get(student).put(subject, rating);
            addToSubjectsMap(subject, student);
        }
    }

    private void addToSubjectsMap(Subject subject, Student newStudent) {

        var students = subjectsMap.computeIfAbsent(subject, k -> new ArrayList<>());
        if (!students.contains(newStudent)) {
            students.add(newStudent);
        }
    }

    public void removeStudent(Student student) {

        if (!studentsMap.containsKey(student)) {
            return;
        }
        studentsMap.remove(student);
    }

    public void printStudents() {
        for (var studentMapEntry : studentsMap.entrySet()) {
            System.out.println(studentMapEntry.getKey());
            System.out.println("\t\t" + studentMapEntry.getValue());
        }
    }

    public void addSubjectWithStudents(Subject newSubject, List<Student> newStudents) {
        var students = subjectsMap.computeIfAbsent(newSubject, k -> new ArrayList<>());
        newStudents.forEach(s -> {
            if (!students.contains(s)) {
                students.add(s);
            }
        });
    }

    public void pushStudentsToSubjects(Student newStudent, Subject subject) {

        if (!subjectsMap.containsKey(subject)) {
            return;
        }

        var studentsList = subjectsMap.get(subject);
        if (!studentsList.contains(newStudent)) {
            studentsList.add(newStudent);
        }
    }

    public void extractStudentsFromSubjects(Student student, Subject subject) {
        if (!subjectsMap.containsKey(subject)) {
            return;
        }

        if (studentsMap.containsKey(student)) {
            var subjMap = studentsMap.get(student);
            if (subjMap.containsKey(subject)) {
                return;
            }
        }

        var studentsList = subjectsMap.get(subject);

        studentsList.remove(student);
    }

    public void printSubjects() {
        for (Map.Entry<Subject, List<Student>> subjectListEntry : subjectsMap.entrySet()) {
            System.out.println(subjectListEntry.getKey());
            System.out.println("\t\t" + subjectListEntry.getValue());
        }
    }

    public HashMap<Student, Map<Subject, Integer>> getStudentsMap() {
        return studentsMap;
    }

    public HashMap<Subject, List<Student>> getSubjectsMap() {
        return subjectsMap;
    }
}