package derschrank.task10.bjstwo_45209;

import java.util.*;

public class StudentDatabase {
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


    private void addStudent(Student student) {
        studentGraidsBySubject.computeIfAbsent(student, k -> new HashMap<>());
    }

    private void addNotesToStudent(Student student, Map<Subject, Integer> newNotes) {
        Map<Subject, Integer> oldNotes = studentGraidsBySubject.get(student);
        oldNotes.putAll(newNotes);
    }

    public void addOneNoteToStudent(Student student, Subject subject, Integer note) {
        Map<Subject, Integer> oldNote = studentGraidsBySubject.get(student);
        if (oldNote != null) {
            oldNote.put(subject, note);
        }
    }

    public void addStudentAndHisNotes(Student student, Map<Subject, Integer> newNote) {
        addStudent(student);
        addNotesToStudent(student, newNote);
    }

    public void deleteStudent(Student student) {
        studentGraidsBySubject.remove(student);
        for (Subject subject : subjectStudents.keySet()) {
            subjectStudents.get(subject).remove(student);
        }
    }


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



    public void addSubject(Subject subject) {
        subjectStudents.computeIfAbsent(subject, k -> new HashSet<>());
    }

    public void addStudentsToSubject(Subject subject, Set<Student> students) {
        Set<Student> oldListOfStudents = subjectStudents.get(subject);
        oldListOfStudents.addAll(students);
    }

    public void addOneStudentToSubject(Subject subject, Student student) {
        Set<Student> oldListOfStudents = subjectStudents.get(subject);
        oldListOfStudents.add(student);
    }

    public void addSubjectAndHisStudents(Subject subject, Set<Student> students) {
        addSubject(subject);
        addStudentsToSubject(subject, students);
    }

    public void delStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
    }

    public void printAllSubjectsWithStudents() {
        System.out.println(getStringToPrintAllSubjectsWithStudents());
    }

    public String getStringToPrintAllSubjectsWithStudents() {
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
