package faang.school.godbless.helpСolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int personsForOneThread = 1000;
        List<Person> listOfPersons = new ArrayList<>(10000); // лижат типа люди 1 = person; 2 = person ...
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + i; // если бы были люди, то присвоили каждому имя,
            String surname = "Surname" + i; // фамилию
            String workSpace = "Work space" + i; // место работы
            listOfPersons.add(new Person(name, surname, i, workSpace)); // доб. человека в лист
        }
        ExecutorService executor = Executors.newFixedThreadPool(10); // 1 thread = 1000 persons
        for (int i = 0; i < 10; i++) { // реализуем 1 поток = 1000 человек
            int head = i; // 1-ый человек
            int tail = (i + 1) * 1000; // 1000-ый чел
            List<Person> thousandOfPersons = listOfPersons.subList(head, tail); // проходимя по каждому челу от 1 до 999-го
            head = i + 1000; // смещаем голову вправа
            for (Person person : thousandOfPersons) {
                executor.submit(new PersonNamePrinter(person)); // применем потоки к людям
            }
        }
        executor.awaitTermination(10, TimeUnit.SECONDS); // ожидаем завершения работы
        executor.shutdown(); // удаляем потоки
        System.out.println("Program is done!");
    }
}
