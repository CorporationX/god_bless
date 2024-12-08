package derschrank.task10.bjstwo_45209;

import java.util.*;

public class StudentDatabase {
    Map<Student, Map<Subject, Integer>> studentsNotesMap;
    Map<Subject, Set<Student>> subjectStudentsMap;

    public StudentDatabase() {
        this(new HashMap<>(), new HashMap<>());
    }

    public StudentDatabase(Map<Student, Map<Subject, Integer>> studentAndNotes,
                           Map<Subject, Set<Student>> subjectAndStudents) {
        this.studentsNotesMap = studentAndNotes;
        this.subjectStudentsMap = subjectAndStudents;
    }



    public void addStudent(Student student) {
        studentsNotesMap.computeIfAbsent(student, k -> new HashMap<>());
    }

    public void addNotesToStudent(Student student, Map<Subject, Integer> newNotes) {
        Map<Subject, Integer> oldNotes = studentsNotesMap.get(student);
        oldNotes.putAll(newNotes);
    }

    public void addOneNoteToStudent(Student student, Subject subject, Integer note) {
        Map<Subject, Integer> oldNote = studentsNotesMap.get(student);
        oldNote.put(subject, note);
    }

    public void addStudentAndHisNotes(Student student, Map<Subject, Integer> newNote) {
        addStudent(student);
        addNotesToStudent(student, newNote);
    }

    public void delStudent(Student student) {
        studentsNotesMap.remove(student);
        for (Subject subject : subjectStudentsMap.keySet()) {
            subjectStudentsMap.get(subject).remove(student);
        }
    }


    public void printAllStudentsWithNotes() {
        System.out.println(getStringToPrintAllStudentsWithNotes());
    }

    public String getStringToPrintAllStudentsWithNotes() {
        int count = 0;

        String stringFormatCountAndStudent = "[%" + (studentsNotesMap.size() / 10 + 1) + "d] %s\n";

        StringBuilder result = new StringBuilder("All students with their  notes:\n");

        for (Student student : studentsNotesMap.keySet()) {
            result.append(String.format(stringFormatCountAndStudent, ++count, student));

            Map<Subject, Integer> subjectsNoteMapOfStudent = studentsNotesMap.get(student);
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
        subjectStudentsMap.computeIfAbsent(subject, k -> new HashSet<>());
    }

    public void addStudentsToSubject(Subject subject, Set<Student> students) {
        Set<Student> oldListOfStudents = subjectStudentsMap.get(subject);
        oldListOfStudents.addAll(students);
    }

    public void addOneStudentToSubject(Subject subject, Student student) {
        Set<Student> oldListOfStudents = subjectStudentsMap.get(subject);
        oldListOfStudents.add(student);
    }

    public void addSubjectAndHisStudents(Subject subject, Set<Student> students) {
        addSubject(subject);
        addStudentsToSubject(subject, students);
    }

    public void delStudentFromSubject(Student student, Subject subject) {
        subjectStudentsMap.get(subject).remove(student);
    }

    public void printAllSubjectsWithStudents() {
        System.out.println(getStringToPrintAllSubjectsWithStudents());
    }

    public String getStringToPrintAllSubjectsWithStudents() {
        int count = 0;

        String stringFormatCountAndSubject = "[%" + (subjectStudentsMap.size() / 10 + 1) + "d] %s: ";

        StringBuilder result = new StringBuilder("All subjects with their students: \n");

        for (Subject subject : subjectStudentsMap.keySet()) {
            result.append(String.format(stringFormatCountAndSubject, ++count, subject));

            Set<Student> studentsList = subjectStudentsMap.get(subject);
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
