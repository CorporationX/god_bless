package school.faang.task_45228;

import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentsDatabase {
    @Getter
    private final Map<Student, Map<Subject, Integer>> studentsSubjectsPerGrade = new HashMap<>();
    @Getter
    private final Map<Subject, List<Student>> studentsPerSubjects = new HashMap<>();

    private final AtomicInteger studentsIdMaker = new AtomicInteger(1);
    private final AtomicInteger subjectIdMaker = new AtomicInteger(1);

    public void addStudentsWithGrades(String nameOfStudent, Map<Subject, Integer> gradesPerSubjects) {
        if (StringUtils.isBlank(nameOfStudent)) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (MapUtils.isEmpty(gradesPerSubjects)) {
            throw new IllegalArgumentException("There are no grades!");
        }

        int studentId = studentsIdMaker.getAndIncrement();
        Student student = new Student(studentId, nameOfStudent);
        studentsSubjectsPerGrade.put(student, gradesPerSubjects);

        gradesPerSubjects.forEach((k, v) -> studentsPerSubjects
                .computeIfAbsent(k, (p) -> new ArrayList<>())
                .add(student));
    }

    public void addNewSubjectToStudent(String nameOfSubject, int grade, String nameOfStudent) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade is under 0!");
        }
        if (StringUtils.isBlank(nameOfStudent)) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (StringUtils.isBlank(nameOfSubject)) {
            throw new IllegalArgumentException("Subject is blank!");
        }

        int id = subjectIdMaker.getAndIncrement();
        Subject request = new Subject(id, nameOfSubject);
        Student student = studentsSubjectsPerGrade.keySet().stream()
                .filter(s -> s.name().equals(nameOfStudent))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student was not found!"));

        studentsSubjectsPerGrade
                .computeIfAbsent(student, s -> new HashMap<>())
                .put(request, grade);

        studentsPerSubjects.computeIfAbsent(request, k -> new ArrayList<>()).add(student);
    }

    public void deleteStudentsWithSubjects(String nameOfStudent) {
        if (StringUtils.isBlank(nameOfStudent)) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Student student = studentsSubjectsPerGrade.keySet().stream()
                .filter(s -> s.name().equals(nameOfStudent))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student was not found!"));

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

    public void printStudentsAndSubjects() {
        studentsSubjectsPerGrade.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }

    public void addSubjectWithListOfStudent(String nameOfSubject, List<Student> students) {
        if (CollectionUtils.isEmpty(students)) {
            throw new IllegalArgumentException("List is empty!");
        }
        if (StringUtils.isBlank(nameOfSubject)) {
            throw new IllegalArgumentException("Name is blank!");
        }

        int id = subjectIdMaker.getAndIncrement();
        Subject request = new Subject(id, nameOfSubject);
        studentsPerSubjects.put(request, students);

        for (Student student : students) {
            studentsSubjectsPerGrade.computeIfAbsent(student, (l) -> new HashMap<>()).put(request, -1);
        }
    }

    public void addStudentToExistingSubject(String nameOfStudent, String existingSubject, int gradeOfSubject) {
        if (gradeOfSubject < 0) {
            throw new IllegalArgumentException("Grade is under 0!");
        }
        if (StringUtils.isBlank(nameOfStudent)) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (StringUtils.isBlank(existingSubject)) {
            throw new IllegalArgumentException("Subject is blank!");
        }

        Student student = studentsSubjectsPerGrade.keySet().stream()
                .filter(s -> s.name().equals(nameOfStudent))
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new IllegalArgumentException("Student was not found!");
        }

        Subject subject = studentsPerSubjects.entrySet().stream()
                .filter(s -> s.getKey().name().equals(existingSubject))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        if (subject == null) {
            throw new IllegalArgumentException("Subject was not found!");
        }

        studentsPerSubjects.get(subject).add(student);

        studentsSubjectsPerGrade.get(student).put(subject, gradeOfSubject);
    }

    public void deleteStudentFromSubject(String studentName, String subjectName) {
        if (StringUtils.isBlank(studentName)) {
            throw new IllegalArgumentException("Name is blank!");
        }
        if (StringUtils.isBlank(subjectName)) {
            throw new IllegalArgumentException("Name is blank!");
        }

        Subject requestedSubject = studentsPerSubjects.keySet().stream()
                .filter(students -> students.name().equals(subjectName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Subject was not found!"));

        List<Student> students = studentsPerSubjects.get(requestedSubject);
        Student requestedStudent = students.stream()
                .filter(s -> s.name().equals(studentName))
                .findFirst()
                .orElse(null);

        if (requestedStudent == null) {
            throw new IllegalArgumentException("Student was not found!");
        }

        studentsPerSubjects.get(requestedSubject).remove(requestedStudent);
        studentsSubjectsPerGrade.get(requestedStudent).remove(requestedSubject);
    }

    public void printAllSubjectsWithinStudents() {
        studentsPerSubjects.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }
}