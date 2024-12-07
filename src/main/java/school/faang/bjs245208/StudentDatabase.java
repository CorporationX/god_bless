package school.faang.bjs245208;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static school.faang.bjs245208.Helpers.*;

public class StudentDatabase {
    public Map<Student, Map<Subject, Integer>> studentsScores = new HashMap<>();
    public Map<Subject, List<Student>> subjectsStudents = new HashMap<>();


    public void addStudent(String studentName, Map<Subject, Integer> studentSubjectsAndMarks) {
        if (notEmptyParamCheck(studentName, "Student name")
                && notEmptyParamCheck(studentSubjectsAndMarks, "Subjects and marks")) {
            Student student = new Student(studentName);
            studentsScores.put(student, studentSubjectsAndMarks);
        }
        //Optional can bind with addSubject if needed
    }

    public void addStudentSubject(String studentName, UUID studentId, Map.Entry<Subject, Integer> subjectAndMark) {
        if (notEmptyParamsCheck(studentName, studentId)
                && notEmptyParamCheck(subjectAndMark, "Subject and marks")) {
            Student student = studentsScores.keySet().stream()
                    .filter(existingStudent -> studentId != null
                            ? Objects.equals(existingStudent.getId(), studentId)
                            : Objects.equals(existingStudent.getName(), studentName))
                    .findFirst()
                    .orElse(new Student(studentName));
            Map<Subject, Integer> subjectsAndMarks = studentsScores.get(student);
            subjectsAndMarks.put(subjectAndMark.getKey(), subjectAndMark.getValue());
            studentsScores.put(student, subjectsAndMarks);
        }
        //Optional can bind with addSubjectStudent if needed
        //Optional can bind with addSubject if needed
    }

    public void removeStudent(String studentName, UUID studentId) {
        if (notEmptyParamsCheck(studentName, studentId)) {
            Set<Student> studentsToRemove = studentsScores.keySet().stream()
                    .filter(student -> studentId != null
                            ? Objects.equals(student.getId(), studentId)
                            : Objects.equals(student.getName(), studentName))
                    .collect(Collectors.toSet());

            studentsToRemove.forEach(studentsScores::remove);
        }
    }

    public void printAllStudentsWithScores() {
        if (notEmptyParamCheck(studentsScores, "Students data")) {
            studentsScores.forEach((student, scores) -> {
                System.out.println(student);
                scores.forEach((subject, score) -> System.out.println("Subject: " + subject
                        + " Score: " + score));
            });
        }
    }

    public void addSubject(String subjectName, List<Student> studentsOnCourse) {
        if (notEmptyParamCheck(subjectName, "SubjectName name")
                && notEmptyParamCheck(studentsOnCourse, "Students registered on course")) {
            Subject subject = new Subject(subjectName);
            subjectsStudents.put(subject, studentsOnCourse);
        }
        //Optional can bind with addStudent if needed
    }

    public void addSubjectStudent(String subjectName, UUID subjectId, Student studentOnCourse) {
        if (notEmptyParamsCheck(subjectName, subjectId)
                && notEmptyParamCheck(studentOnCourse, "Student registered on course")) {
            Subject subject = subjectsStudents.keySet().stream()
                    .filter(existingSubject -> subjectId != null
                            ? Objects.equals(existingSubject.getId(), subjectId)
                            : Objects.equals(existingSubject.getName(), subjectName))
                    .findFirst()
                    .orElse(new Subject(subjectName));

            List<Student> students = subjectsStudents.get(subject);
            students.add(studentOnCourse);
            subjectsStudents.put(subject, students);
        }
        //Optional can bind with addStudentSubject if needed
        //Optional can bind with addStudent if needed
    }

    public void removeStudentFromSubject(String subjectName, UUID subjectId, Student studentOnCourse) {
        if (notEmptyParamsCheck(subjectName, subjectId, studentOnCourse)) {
            Set<Subject> correspondingSubjects = subjectsStudents.keySet().stream()
                    .filter(subject -> subjectId != null
                            ? Objects.equals(subject.getId(), subjectId)
                            : Objects.equals(subject.getName(), subjectName))
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
    }

    public void printAllSubjectsWithStudents() {
        if (notEmptyParamCheck(subjectsStudents, "Subjects data")) {
            subjectsStudents.forEach((subject, students) -> {
                System.out.println(subject);
                students.forEach(student -> System.out.println("Student: " + student));
            });
        }
    }
}
