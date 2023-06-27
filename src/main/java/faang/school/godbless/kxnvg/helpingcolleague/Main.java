package faang.school.godbless.kxnvg.helpingcolleague;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        String personName = "Person";
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(personName + i, "John", 30, "Job"));
        }

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            PersonNamePrinter personNamePrinter = new PersonNamePrinter();
            personNamePrinter.setPersonList(persons.subList(i * 1000, i * 1000 + 1000));
            service.submit(personNamePrinter);
        }
        service.shutdown();

        if (service.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("=======    Программа завершила работу!    =======");
        }
    }
}
