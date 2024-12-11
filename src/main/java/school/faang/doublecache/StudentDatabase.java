package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    Map<Student, Map<Subject, Integer>> students;
    Map<Subject, List<Student>> subjects;

    public StudentDatabase(Map<Student, Map<Subject, Integer>> studentsGradesMap,
                           Map<Subject, List<Student>> subjectStudentsMap) {
        this.students = studentsGradesMap;
        this.subjects = subjectStudentsMap;
    }

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        // Добавляем студента, предметы и оценки в Map
        students.put(student, grades);

        // По каждому предмету добавляем данного студента в список студентов
        for (Subject subject : grades.keySet()) {
            subjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        // Добавление предмета и оценку в мапу студента
        Map<Subject, Integer> grades = students.getOrDefault(student, new HashMap<>());
        grades.put(subject, grade);

        // Добавление студента в список студентов предмета
        subjects.getOrDefault(subject, new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = students.getOrDefault(student, new HashMap<>());
        for (Subject subject : grades.keySet()) {
            List<Student> studentList = subjects.getOrDefault(subject, new ArrayList<>());
            studentList.remove(student);
        }
        students.remove(student);
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : students.entrySet()) {
            System.out.println(entry);
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> studentList) {
        subjects.put(subject, studentList);
        for (Student s : studentList) {
            students.put(s, new HashMap<>());
            students.get(s).put(subject, null);
        }
    }

    public void addStudentForSubject(Subject subject, Student student) {
        subjects.getOrDefault(subject, new ArrayList<>()).add(student);
        students.getOrDefault(student, new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> studentList = subjects.getOrDefault(subject, new ArrayList<>());
        if (student != null) {
            studentList.remove(student);
        }
        Map<Subject, Integer> grades = students.getOrDefault(student, new HashMap<>());
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjects.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

}
