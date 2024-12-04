package school.faang.task_45228;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsDatabase {
    private static final Map<Student, Map<Subject, Integer>> studentsSubjectsPerGrade = new HashMap<>();
    private static final Map<Subject, List<Student>> studentsPerSubjects = new HashMap<>();

    public static void addStudentsWithGrades(String nameOfStudent, Map<Subject, Integer> gradesPerSubjects) {
        if (nameOfStudent.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (gradesPerSubjects.isEmpty()) {
            throw new IllegalArgumentException("There are no grades!");
        }

        Student student = new Student(studentsSubjectsPerGrade.size() + 1, nameOfStudent);
        studentsSubjectsPerGrade.put(student, gradesPerSubjects);

        for (Map.Entry<Subject, Integer> entry : gradesPerSubjects.entrySet()) {
            studentsPerSubjects.computeIfAbsent(entry.getKey(), (p) -> new ArrayList<>()).add(student);
        }
    }

    public static void addNewSubjectToStudent(int id, String nameOfSubject, int grade, String nameOfStudent) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade is under 0!");
        }
        if (nameOfStudent.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (nameOfSubject.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Subject request = new Subject(id, nameOfSubject);
        Student student = null;

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsSubjectsPerGrade.entrySet()) {
            String nameOfFindingStudent = entry.getKey().getName();
            if (nameOfFindingStudent.equals(nameOfStudent)) {
                student = entry.getKey();
                break;
            }
        }

        studentsSubjectsPerGrade.get(student).put(request, grade);

        if (studentsPerSubjects.containsKey(request)) {
            studentsPerSubjects.get(request).add(student);
        } else {
            studentsPerSubjects.computeIfAbsent(request, (k) -> new ArrayList<>()).add(student);
        }
    }

    public static void deleteStudentsWithSubjects(String nameOfStudent) {
        if (nameOfStudent.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Student student = null;
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsSubjectsPerGrade.entrySet()) {
            String nameOfFindingStudent = entry.getKey().getName();
            if (nameOfFindingStudent.equals(nameOfStudent)) {
                student = entry.getKey();
                break;
            }
        }

        studentsSubjectsPerGrade.remove(student);

        for (Map.Entry<Subject, List<Student>> entry : studentsPerSubjects.entrySet()) {
            List<Student> students = entry.getValue();
            int index = students.indexOf(student);

            int indexOfLastOne = students.size() - 1;
            if (index != -1) {
                students.set(index, students.get(indexOfLastOne));
            }

            students.remove(indexOfLastOne);
        }
    }

    public static void printStudentsAndSubjects() {
        studentsSubjectsPerGrade.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }

    public static void addSubjectWithListOfStudent(int id, String nameOfSubject, List<Student> students) {
        if (id < 0) {
            throw new IllegalArgumentException("Id is under 0!");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
        if (nameOfSubject.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Subject request = new Subject(id, nameOfSubject);
        studentsPerSubjects.put(request, students);

        for (Student student : students) {
            studentsSubjectsPerGrade.computeIfAbsent(student, (l) -> new HashMap<>()).put(request, -1);
        }
    }

    public static void addStudentToExistingSubject(String nameOfStudent, String existingSubject, int gradeOfSubject) {
        if (gradeOfSubject < 0) {
            throw new IllegalArgumentException("Grade is under 0!");
        }
        if (nameOfStudent.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (existingSubject.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Student student = null;
        for (Student s : studentsSubjectsPerGrade.keySet()) {
            if (s.getName().equals(nameOfStudent)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            throw new IllegalArgumentException("Student was not found!");
        }

        Subject subject = null;
        for (Map.Entry<Subject, List<Student>> entry : studentsPerSubjects.entrySet()) {
            String findingSubject = entry.getKey().getName();
            if (findingSubject.equals(existingSubject)) {
                subject = entry.getKey();
                studentsPerSubjects.get(entry.getKey()).add(student);
                break;
            }
        }

        if (subject == null) {
            throw new IllegalArgumentException("Subject was not found!");
        }

        studentsSubjectsPerGrade.get(student).put(subject, gradeOfSubject);
    }

    public static void deleteStudentFromSubject(String studentName, String subjectName) {
        if (studentName.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (subjectName.isBlank()) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Subject requestedSubject = null;
        for (Map.Entry<Subject, List<Student>> entry : studentsPerSubjects.entrySet()) {
            String findingSubject = entry.getKey().getName();
            if (findingSubject.equals(subjectName)) {
                requestedSubject = entry.getKey();
                break;
            }
        }

        if (requestedSubject == null) {
            throw new IllegalArgumentException("Subject was not found!");
        }

        List<Student> students = studentsPerSubjects.get(requestedSubject);
        Student requestedStudent = null;
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                requestedStudent = student;
                break;
            }
        }

        if (requestedStudent == null) {
            throw new IllegalArgumentException("Student was not found!");
        }

        studentsPerSubjects.get(requestedSubject).remove(requestedStudent);
        studentsSubjectsPerGrade.get(requestedStudent).remove(requestedSubject);
    }

    public static void printAllSubjectsWithinStudents() {
        studentsPerSubjects.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }
}