package school.faang.bjs245208;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static school.faang.bjs245208.Helpers.notEmptyParamCheck;
import static school.faang.bjs245208.Helpers.notEmptyParamsCheck;
import static school.faang.bjs245208.Helpers.objectEqualsUuidOrString;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentsScores = new HashMap<>();
    private final Map<Subject, List<Student>> subjectsStudents = new HashMap<>();

    public void addStudent(String studentName, Map<Subject, Integer> studentSubjectsAndMarks) {
        notEmptyParamCheck(studentName, "Student name");
        notEmptyParamCheck(studentSubjectsAndMarks, "Subjects and marks");

        Student student = new Student(studentName);
        studentsScores.put(student, studentSubjectsAndMarks);

        //Optional can bind with addSubject if needed
    }

    public void addStudentSubject(String studentName, UUID studentId, Map.Entry<Subject, Integer> subjectAndMark) {
        notEmptyParamsCheck(studentName, studentId);
        notEmptyParamCheck(subjectAndMark, "Subject and marks");

        Student student = studentsScores.keySet().stream()
                .filter(existingStudent -> objectEqualsUuidOrString(existingStudent.getId(),
                        existingStudent.getName(), studentId, studentName))
                .findFirst()
                .orElse(new Student(studentName));
        Map<Subject, Integer> subjectsAndMarks = studentsScores.get(student);
        subjectsAndMarks.put(subjectAndMark.getKey(), subjectAndMark.getValue());
        studentsScores.put(student, subjectsAndMarks);

        //Optional can bind with addSubjectStudent if needed
        //Optional can bind with addSubject if needed
    }

    public void removeStudent(String studentName, UUID studentId) {
        notEmptyParamsCheck(studentName, studentId);

        Set<Student> studentsToRemove = studentsScores.keySet().stream()
                .filter(student -> objectEqualsUuidOrString(student.getId(),
                        student.getName(), studentId, studentName))
                .collect(Collectors.toSet());
        studentsToRemove.forEach(studentsScores::remove);
    }

    public void printAllStudentsWithScores() {
        notEmptyParamCheck(studentsScores, "Students data");

        studentsScores.forEach((student, scores) -> {
            System.out.println(student);
            scores.forEach((subject, score) -> System.out.println("Subject: " + subject
                    + " Score: " + score));
        });
    }

    public void addSubject(String subjectName, List<Student> studentsOnCourse) {
        notEmptyParamCheck(subjectName, "SubjectName name");
        notEmptyParamCheck(studentsOnCourse, "Students registered on course");

        Subject subject = new Subject(subjectName);
        subjectsStudents.put(subject, studentsOnCourse);

        //Optional can bind with addStudent if needed
    }

    public void addSubjectStudent(String subjectName, UUID subjectId, Student studentOnCourse) {
        notEmptyParamsCheck(subjectName, subjectId);
        notEmptyParamCheck(studentOnCourse, "Student registered on course");

        Subject subject = subjectsStudents.keySet().stream()
                .filter(existingSubject -> objectEqualsUuidOrString(existingSubject.getId(),
                        existingSubject.getName(), subjectId, subjectName))
                .findFirst()
                .orElse(new Subject(subjectName));

        List<Student> students = subjectsStudents.get(subject);
        students.add(studentOnCourse);
        subjectsStudents.put(subject, students);

        //Optional can bind with addStudentSubject if needed
        //Optional can bind with addStudent if needed
    }

    public void removeStudentFromSubject(String subjectName, UUID subjectId, Student studentOnCourse) {
        notEmptyParamsCheck(subjectName, subjectId, studentOnCourse);

        Set<Subject> correspondingSubjects = subjectsStudents.keySet().stream()
                .filter(subject -> objectEqualsUuidOrString(subject.getId(),
                        subject.getName(), subjectId, subjectName))
                .collect(Collectors.toSet());

        correspondingSubjects.forEach(subject -> {
            List<Student> students = subjectsStudents.get(subject);
            if (students.remove(studentOnCourse)) {
                System.out.printf("Student: %s is not registered to course: %s",
                        studentOnCourse, subject.getName());
            } else {
                System.out.printf("Student: %s unregistered from course: %s",
                        studentOnCourse, subject.getName());
            }
        });
    }

    public void printAllSubjectsWithStudents() {
        notEmptyParamCheck(subjectsStudents, "Subjects data");

        subjectsStudents.forEach((subject, students) -> {
            System.out.println(subject);
            students.forEach(student -> System.out.println("Student: " + student));
        });
    }
}
