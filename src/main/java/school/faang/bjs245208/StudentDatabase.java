package school.faang.bjs245208;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StudentDatabase {
    public Map<Student, Map<Subject, Integer>> studentsScores = new HashMap<>();
    public Map<Subject, List<Student>> subjectsStudents = new HashMap<>();


    public void addStudent(String studentName, Map<Subject, Integer> studentSubjectsAndMarks) {
        if (notEmptyParamCheck(studentName, "Student name") && notEmptyParamCheck(studentSubjectsAndMarks, "Subjects and marks")) {
            Student student = new Student(studentName);
            studentsScores.put(student, studentSubjectsAndMarks);
        }
    }

    public void addStudentSubject(String studentName, UUID studentId, Map.Entry<Subject, Integer> subjectAndMark) {
        if (notEmptyParamsCheck(studentName, studentId) && notEmptyParamCheck(subjectAndMark, "Subject and marks")) {
            Student student = new Student(studentName);//TODO
            Map<Subject, Integer> subjectsAndMarks = studentsScores.get(student);
            subjectsAndMarks.put(subjectAndMark.getKey(), subjectAndMark.getValue());
        }
    }

    public void removeStudent(String studentName, UUID studentId) {
        if (notEmptyParamsCheck(studentName, studentId)) {
            Student student;
            if (studentId != null) {
//                student = new Student(studentId);
//                studentsScores.remove(student);
            } else {
                student = new Student(studentName);
                studentsScores.remove(student);
            }
        }
    }

    public void printAllStudentsWithScores() {
        if (notEmptyParamCheck(studentsScores, "Students data")) {
            studentsScores.forEach((student, scores) -> {
                System.out.println(student);
                scores.forEach((subject, score) -> System.out.println("Subject: " + subject + " Score: " + score));
            } );
        }
    }

    public void addSubject(String subjectName, List<Student> studentsOnCourse) {
        if (notEmptyParamCheck(subjectName, "SubjectName name") && notEmptyParamCheck(studentsOnCourse, "Students registered on course")) {
            Subject subject = new Subject(subjectName);
            subjectsStudents.put(subject, studentsOnCourse);
        }
    }

    public void addSubjectStudent(String subjectName, UUID subjectId, Student studentOnCourse) {
        if (notEmptyParamsCheck(subjectName, subjectId) && notEmptyParamCheck(studentOnCourse, "Student registered on course")) {
            Subject subject = new Subject(subjectName);//TODO
            List<Student> students = subjectsStudents.get(subject);
            subjectsStudents.put(subject, students);
        }
    }

    public void removeSubjectStudent(String subjectName, UUID subjectId, Student studentOnCourse) {

    }

    public void printAllSubjectsWithStudents() {
        if (notEmptyParamCheck(subjectsStudents, "Subjects data")) {
            subjectsStudents.forEach((subject, students) -> {
                System.out.println(subject);
                students.forEach(student -> System.out.println("Student: " + student));
            } );
        }
    }

    private boolean notEmptyParamsCheck(Object... toCheck) {

        boolean allAreEmpty = true;

        for (Object obj : toCheck) {
            if (obj != null) {
                if (!(obj instanceof String) || !((String) obj).isEmpty()) {
                    allAreEmpty = false;
                    break;
                }
            }
        }

        if (allAreEmpty) {
            System.out.println("Cannot operate request as all required fields are not set!");
            return false;
        }

        return true;
    }

    private <T> boolean notEmptyParamCheck(T toCheck, String name) {
        if (toCheck == null) {
            System.out.printf("Cannot operate request as %s is not set!\n", name);
            return false;
        }

        if (toCheck instanceof String && ((String) toCheck).isEmpty()) {
            System.out.printf("Cannot operate request as %s is not set!\n", name);
            return false;
        }

        return true;
    }
}
