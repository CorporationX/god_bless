package faang.school.godbless.Student;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("Anna", "Electrical Engineering", 2),
                new Student("Alice", "Computer Science", 1),
                new Student("Bob", "Mechanical Engineering", 2),
                new Student("Charlie", "Business Administration", 3),
                new Student("David", "Psychology", 1),
                new Student("Anastasia", "Psychology", 1),
                new Student("Newton", "Psychology", 5),
                new Student("Mark", "Electrical Engineering", 2),
                new Student("Grace", "Mathematics", 3),
                new Student("Ivy", "Biology", 1),
                new Student("Jack", "Computer Science", 1),
                new Student("Liza", "Electrical Engineering", 2),
                new Student("Alexander", "Electrical Engineering", 2)
        );

        Student studentOne = new Student("Michael", "Computer Science", 1);
        Student studentTwo = new Student("Anton", "Computer Science", 2);

        System.out.println("\t\t\tСоздать стуктуру MapStudent");
        studentOne.printMap(studentOne.createMap(list));
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tДобавить студента= Michael,Anton");
        studentOne.printMap(studentOne.addStudent(studentOne));
        studentOne.printMap(studentOne.addStudent(studentTwo));
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tУдалить студентов= Liza,David,Anastasia");
        studentOne.removeStudent("Liza");
        studentOne.removeStudent("Anastasia");
        System.out.println("Вывод структуры mapStudent после удаления Liza,David,Anastasia");
        studentOne.printMap(studentOne.removeStudent("David"));
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tУдаление по факультету и курсу Biology-1");
        System.out.println("Вывод структуры mapStudent после удаления Biology-1");
        studentOne.printMap(studentOne.deleteByFacultyAndCourse("Biology-1"));
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tУдаление по факультету и курсу Computer Science-1");
        System.out.println("Вывод структуры mapStudent после удаления Computer Science-1");
        studentOne.printMap(studentOne.deleteByFacultyAndCourse("Computer Science-1"));
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tПоиск студентов по факультету и курсу");
        studentOne.lookForStudents("Mathematics-3");
        System.out.println("\n-------------------------------------------------------------------------");

        System.out.println("\n\n\t\tПоиск студентов по факультету и курсу");
        studentOne.lookForStudents("Electrical Engineering-2");
    }
}
