package school.faang.task45240;

import school.faang.task45240.model.Student;
import school.faang.task45240.model.Subject;
import school.faang.task45240.model.SubjectName;
import school.faang.task45240.services.StudentDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Subject, Integer> gradedSubjects = new HashMap<>();
        gradedSubjects.put(new Subject(SubjectName.PHYSICS), 5);
        gradedSubjects.put(new Subject(SubjectName.HISTORY), 4);
        gradedSubjects.put(new Subject(SubjectName.SOCIOLOGY), 3);

        StudentDatabase university = new StudentDatabase();

        Student student1 = new Student("Vasya");

        university.addStudentWithGrades(student1, gradedSubjects);
        university.printGradedStudents();

        Student student4 = new Student("Sveta");


        university.addSubjectForStudent(student4, new Subject(SubjectName.HISTORY), 5);
        university.addSubjectForStudent(student4, new Subject(SubjectName.MATH), 4);
        university.addSubjectForStudent(student1, new Subject(SubjectName.HISTORY), 5);
        university.addSubjectForStudent(student1, new Subject(SubjectName.MATH), 4);

        university.printGradedStudents();

        university.removeStudent(student1);
        university.printGradedStudents();

        Student student2 = new Student("Petya");
        Student student3 = new Student("Masha");
        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);

        university.addSubjectWithStudents(new Subject(SubjectName.MATH), students);
        university.printStudentSubjects();

        Student student5 = new Student("Vova");

        university.addStudentToSubject(student4, new Subject(SubjectName.HISTORY));
        university.addStudentToSubject(student5, new Subject(SubjectName.PHYSICS));
        university.addStudentToSubject(student5, new Subject(SubjectName.MATH));

        university.printStudentSubjects();

        university.removeStudentFromSubject(student4, new Subject(SubjectName.HISTORY));
        university.removeStudentFromSubject(student1, new Subject(SubjectName.MATH));
        university.removeStudentFromSubject(student5, new Subject(SubjectName.MATH));
        university.printStudentSubjects();


    }
}
