package faang.school.godbless.task_4;

import java.util.List;

public class Main {
    public static void main(String[] args) {


    }

    static List<Student> createStudents(){
        return List.of(
                new Student("Ivan Ivanov", "Economy", "Economist"),
                new Student("Sergey Petrov", "Economy", "Economist"),

                new Student("Ivan Sibirko Petrov", "Economy", "Creditor"),
                new Student("Alexey Shelehov", "Economy", "Creditor"),

                new Student("Ruslan Galimov", "Jurisprudence", "Lawyer"),
                new Student("Anastasia Belikova", "Jurisprudence", "Lawyer"),

                new Student("Nariman Usypov", "Jurisprudence", "Judge"),
                new Student("Kirill Sobolev", "Jurisprudence", "Judge"),

                new Student("Pavel Volya", "Jurisprudence", "Judge"),
                new Student("Artur Pirojkov", "Jurisprudence", "Judge")
        );
    }
}
