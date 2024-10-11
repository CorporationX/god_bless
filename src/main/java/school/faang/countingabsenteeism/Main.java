package school.faang.countingabsenteeism;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addStudent(new Student("Vadim", "it", 4));
        service.addStudent(new Student("Max", "mechanic", 3));
        service.addStudent(new Student("Artyom", "economic", 1));
        service.addStudent(new Student("Andrey", "medic", 2));
        System.out.println("Сгруппированные студенты: ");
        service.printGroupedStudent();
        System.out.println("Студенты факультета mechanic, крус 3");
        List<Student> foundStudent = service.searchStudent("economic", 1);
        System.out.println(foundStudent);
        service.removeStudent("Andrey", "medic", 2);
        System.out.println("После удаления Andrey");
        service.printGroupedStudent();
    }
}
