package faang.school.godbless.helpСolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> listOfPersons = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            String workSpace = "Work space" + i;
            listOfPersons.add(new Person(name, surname, i, workSpace));
        }
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int head = i + 1;
            int tail = (i + 1) * 1000;
            List<Person> thousandOfPersons = listOfPersons.subList(head, tail);
            head = i + 1000;
            for (Person person : thousandOfPersons) {
                executor.submit(new PersonNamePrinter(person));
            }
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS); // ожидаем завершения работы
        System.out.println("Program is done!");
    }
}
