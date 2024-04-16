package faang.school.godbless.ColleagueHelp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PERSONS_COUNT = 10000;
    private static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        List<Person> persons = getPeople();
        List<List<Person>> personSublist = getPersonSublist(persons);
        List<PersonNamePrinter> printers = getPrinters(personSublist);

        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        for (PersonNamePrinter printer : printers) {
            pool.submit(printer);
        }
        pool.shutdown();

        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
            System.out.println("Все данные успешно обработаны!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<PersonNamePrinter> getPrinters(List<List<Person>> personSublist) {
        List<PersonNamePrinter> printers = new ArrayList<>();
        for (List<Person> persons : personSublist) {
            printers.add(new PersonNamePrinter(persons));
        }
        return printers;
    }

    private static List<List<Person>> getPersonSublist(List<Person> persons) {
        List<List<Person>> personSublist = new ArrayList<>();
        int personsPerThread = PERSONS_COUNT / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * personsPerThread;
            int end = start + personsPerThread;
            List<Person> sublist = persons.subList(start, end);
            personSublist.add(sublist);
        }
        return personSublist;
    }

    private static List<Person> getPeople() {
        List<Person> persons = new ArrayList<>(PERSONS_COUNT);
        for (int i = 0; i < PERSONS_COUNT; i++) {
            persons.add(new Person(String.valueOf(i), String.valueOf(i), i, String.valueOf(i)));
        }
        return persons;
    }
}
