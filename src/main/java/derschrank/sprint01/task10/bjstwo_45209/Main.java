package derschrank.sprint01.task10.bjstwo_45209;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Subject subject1 = new Subject(1, "Math");
        final Subject subject2 = new Subject(2, "English");
        final Subject subject3 = new Subject(3, "Russian");
        final Subject subject4 = new Subject(4, "Biology");

        final Student student1 = new Student(1, "Ivan");
        Map<Subject, Integer> student1Notes = new HashMap<>();
        student1Notes.put(subject1, 5);
        student1Notes.put(subject2, 5);

        final Student student2 = new Student(2, "Petr");
        Map<Subject, Integer> student2Notes = new HashMap<>();
        student2Notes.put(subject1, 4);
        student2Notes.put(subject2, 4);

        Map<Student, Map<Subject, Integer>> studentsNotesMap = new HashMap<>();
        studentsNotesMap.put(student1, student1Notes);
        studentsNotesMap.put(student2, student2Notes);


        Map<Subject, Set<Student>> subjectStudentsMap = new HashMap<>();

        StudentDatabase studentDatabase = new StudentDatabase(studentsNotesMap, subjectStudentsMap);

        studentDatabase.printAllStudentsWithNotes();
        studentDatabase.printAllSubjectsWithStudents();

        System.out.println("Add new student and his notes");
        studentDatabase.addStudentAndHisNotes(new Student(3, "Sidr"), Map.of(subject1, 5, subject2, 5));
        studentDatabase.printAllStudentsWithNotes();

        System.out.println("Add new subject-note to the student");
        studentDatabase.addOneNoteToStudent(student1, subject3, 4);
        studentDatabase.addOneNoteToStudent(student1, subject4, 4);
        studentDatabase.printAllStudentsWithNotes();

        System.out.println("Delete the student");
        studentDatabase.deleteStudent(student1);
        studentDatabase.printAllStudentsWithNotes();

        System.out.println("Add new subject and his students");
        studentDatabase.addSubjectAndHisStudents(subject1, Set.of(student1, student2));
        studentDatabase.addSubjectAndHisStudents(subject2, Set.of(student1, student2));
        studentDatabase.printAllSubjectsWithStudents();

        System.out.println("Add student to subject");
        studentDatabase.addOneStudentToSubject(subject3, student1);
        studentDatabase.addOneStudentToSubject(subject4, student2);
        studentDatabase.printAllSubjectsWithStudents();

        System.out.println("Delete the student from subject");
        studentDatabase.deleteStudentFromSubject(student1, subject1);
        studentDatabase.deleteStudentFromSubject(student1, subject2);
        studentDatabase.printAllSubjectsWithStudents();

        System.out.println("toString:");
        System.out.println(studentDatabase);
    }
}
