package derschrank.sprint01.task10.bjstwo_45209;

import java.util.*;

public class StudentDatabase implements  StudentDatabaseInterface {
    private final Map<Student, Map<Subject, Integer>> studentGraidsBySubject;
    private final Map<Subject, Set<Student>> subjectStudents;

    public StudentDatabase() {
        this(new HashMap<>(), new HashMap<>());
    }

    public StudentDatabase(Map<Student, Map<Subject, Integer>> studentAndNotes,
                           Map<Subject, Set<Student>> subjectAndStudents) {
        this.studentGraidsBySubject = studentAndNotes;
        this.subjectStudents = subjectAndStudents;
    }

    private void addStudentToStudentGraids(Student student) {
        studentGraidsBySubject.computeIfAbsent(student, k -> new HashMap<>());
    }

    @Override
    public void addOneNoteToStudent(Student student, Subject subject, Integer note) {
        addOneNoteToStudentOnly(student, subject, note);
        addOneStudentToSubjectOnly(subject, student);
    }

    private void addOneNoteToStudentOnly(Student student, Subject subject, Integer note) {
        addStudentToStudentGraids(student);
        studentGraidsBySubject.get(student).put(subject, note);
        addOneStudentToSubjectOnly(subject, student);
    }

    @Override
    public void addStudentAndHisNotes(Student student, Map<Subject, Integer> newNote) {
        addStudentAndHisNotesOnly(student, newNote);
        for (Subject subject : newNote.keySet()) {
            addOneStudentToSubjectOnly(subject, student);
        }
    }

    private void addStudentAndHisNotesOnly(Student student, Map<Subject, Integer> newNotes) {
        addStudentToStudentGraids(student);
        studentGraidsBySubject.get(student).putAll(newNotes);
    }


    private void addStudentAndHisNotesWithSubjectWithOutNote(Student student, Subject subject) {
        addStudentAndHisNotesOnly(student, (Map.of(subject, 0)));
    }

    @Override
    public void deleteStudent(Student student) {
        deleteStudentFromStudentGraidsBySubjectOnly(student);
        for (Subject subject : (new HashSet<>(subjectStudents.keySet()))) {
            deleteStudentFromSubjectOnly(student, subject);
        }
    }

    private void deleteStudentFromStudentGraidsBySubjectOnly(Student student) {
        studentGraidsBySubject.remove(student);
    }

    @Override
    public void printAllStudentsWithNotes() {
        System.out.println(getStringToPrintAllStudentsWithNotes());
    }

    private String getStringToPrintAllStudentsWithNotes() {
        int count = 0;

        String stringFormatCountAndStudent = "[%" + (studentGraidsBySubject.size() / 10 + 1) + "d] %s\n";

        StringBuilder result = new StringBuilder("All students with their  notes:\n");

        for (Student student : studentGraidsBySubject.keySet()) {
            result.append(String.format(stringFormatCountAndStudent, ++count, student));

            Map<Subject, Integer> subjectsNoteMapOfStudent = studentGraidsBySubject.get(student);
            for (Subject subject : subjectsNoteMapOfStudent.keySet()) {
                result.append(" - ");
                result.append(subject);
                result.append(": ");
                result.append(subjectsNoteMapOfStudent.get(subject));
            }
            result.append("\n");
        }
        return result.toString();
    }



    private void addSubject(Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
    }

    @Override
    public void addOneStudentToSubject(Subject subject, Student student) {
        addOneStudentToSubjectOnly(subject, student);
        addStudentAndHisNotesWithSubjectWithOutNote(student, subject);
    }

    private void addOneStudentToSubjectOnly(Subject subject, Student student) {
        addSubject(subject);
        subjectStudents.get(subject).add(student);
    }

    @Override
    public void addSubjectAndHisStudents(Subject subject, Set<Student> students) {
        addSubjectAndHisStudentsOnly(subject, students);
        for (Student student : students) {
            addStudentAndHisNotesWithSubjectWithOutNote(student, subject);
        }
    }

    private void addSubjectAndHisStudentsOnly(Subject subject, Set<Student> students) {
        addSubject(subject);
        subjectStudents.get(subject).addAll(students);
    }

    @Override
    public void deleteStudentFromSubject(Student student, Subject subject) {
        deleteStudentFromSubjectOnly(student, subject);
        deleteStudentFromStudentGraidsBySubjectOnly(student);
    }

    private void deleteStudentFromSubjectOnly(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        if (subjectStudents.get(subject).isEmpty()) {
            subjectStudents.remove(subject);
        }
    }

    @Override
    public void printAllSubjectsWithStudents() {
        System.out.println(getStringToPrintAllSubjectsWithStudents());
    }

    private String getStringToPrintAllSubjectsWithStudents() {
        int count = 0;

        String stringFormatCountAndSubject = "[%" + (subjectStudents.size() / 10 + 1) + "d] %s: ";

        StringBuilder result = new StringBuilder("All subjects with their students: \n");

        for (Subject subject : subjectStudents.keySet()) {
            result.append(String.format(stringFormatCountAndSubject, ++count, subject));

            Set<Student> studentsList = subjectStudents.get(subject);
            for (Student student : studentsList) {
                result.append(student);
                result.append(", ");
            }
            result.deleteCharAt(result.length() - 2);
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getStringToPrintAllStudentsWithNotes());
        result.append("\n");
        result.append(getStringToPrintAllSubjectsWithStudents());
        return result.toString();
    }

}
