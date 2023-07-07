package faang.school.godbless.parallel.help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setAge(i);
            person.setName("name-" + (i + 1));
            person.setSurname("surname-" + (i + 1));
            person.setWorkplace("workplace" + (i + 1));
            persons.add(person);
        }
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            List<Person> batch = persons.subList(i * 1000, (i + 1) * 1000 - 1);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(batch);
            executor.submit(personNamePrinter);
        }

        executor.shutdown();
        executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
        System.out.println("Вывод завершен!");
    }
}

