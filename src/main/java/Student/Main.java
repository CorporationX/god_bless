package Student;

import java.util.Arrays;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Маша", "mahf", 1),
                new Student("Вася", "it", 1),
                new Student("Юля", "mahf", 1),
                new Student("Степашка", "leg", 3),
                new Student("Лиза", "develop", 3)
        );
        University university = new University(students);

        Student newstudent = new Student("Серофим", "develop", 1);
        university.addstudent(newstudent);

        Student deletstudent = new Student("Серофим", "develop", 1);
        university.delet(deletstudent);
        System.out.println("");

        System.out.println(university.searchStudent("mahf", 1));
    }
}





