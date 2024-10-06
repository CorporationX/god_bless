package school.faang.systemForStudentsGrades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    static final String[] SUBJECTS = {
            "Математика",
            "Физика",
            "Химия",
            "История",
            "География",
            "Биология",
            "Литература",
            "Иностранный язык",
            "Музыка"
    };

    public static void main(String[] args) {
        GradeTracker gradeTracker = new GradeTracker();

        Student Nikita = new Student(0, "Nikita");
        Student Vlad = new Student(0, "Vlad");
        Student Artem = new Student(0, "Artem");

        Student Maxim = new Student(0, "Maxim");
        Student Dima = new Student(0, "Dima");
        Student Slava = new Student(0, "Slava");

        gradeTracker.addNewStudent(Nikita, generateSubjectAndGrade());
        gradeTracker.addNewStudent(Nikita, generateSubjectAndGrade());
        gradeTracker.addNewStudent(Nikita, generateSubjectAndGrade());
        gradeTracker.addNewStudent(Vlad, generateSubjectAndGrade());
        gradeTracker.addNewStudent(Artem, generateSubjectAndGrade());

        System.out.println("добавил трёх студенов и вывел всю информацию:");

        System.out.println(gradeTracker.showStudentsAndSubjectsWithGrade());
        System.out.println(gradeTracker.showSubjectsAndListStudents());

        System.out.println("\nдобавил студенту Nikita русский язык и вывел всю информацию");

        gradeTracker.addNewSubject(Nikita, new Subject(9, "русский"), 3);
        gradeTracker.addNewSubject(Nikita, new Subject(9, "русский"), 4);

        System.out.println(gradeTracker.showStudentsAndSubjectsWithGrade());
        System.out.println(gradeTracker.showSubjectsAndListStudents());

        System.out.println("\nудалил студента Artem и вывед всю информацию");
        gradeTracker.deleteStudent(Artem);

        System.out.println(gradeTracker.showStudentsAndSubjectsWithGrade());
        System.out.println(gradeTracker.showSubjectsAndListStudents());

        System.out.println("\nдальше используется только вторая HashMap");
        System.out.println("\nдобавил новый предмет и лист студенов, потом вывел информацию из второй HashMap");

        gradeTracker.addNewSubjectAndListStudents(new Subject(10, "рисование"), List.of(
                Maxim, Dima, Slava
        ));

        System.out.println(gradeTracker.showSubjectsAndListStudents());

        System.out.println("\nдобавил студента Nikita к сущесвуему предмету, потом вывел информацию из второй HashMap");

        gradeTracker.addNewStudentToExistingSubject(Nikita, new Subject(10, "рисование"));

        System.out.println(gradeTracker.showSubjectsAndListStudents());

        System.out.println("\nудалил студента Slava из списка студентов в предмете рисование, потом вывел информацию из второй HashMap");

        gradeTracker.removingStudentFromSubject(Slava, new Subject(10, "рисование"));

        System.out.println(gradeTracker.showSubjectsAndListStudents());
    }

    private static Map<Subject, Integer> generateSubjectAndGrade() {
        Random random = new Random();
        int randomNumber = random.nextInt(9);

        Map<Subject, Integer> result = new HashMap<>();
        result.put(new Subject(randomNumber, SUBJECTS[randomNumber]), random.nextInt(4) + 1);

        return result;
    }
}
