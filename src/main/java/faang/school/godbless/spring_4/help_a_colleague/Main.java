package faang.school.godbless.spring_4.help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String[] name = {"Harry", "Oliver", "Jack", "Charlie", "Amelia", "Oliva", "Jessica", "Emily", "Lily"};
        String[] surName = {"Adamason", "Allsop", "Barnes", "Bates", "Dean", "Dodson", "Gill", "Griffin", "James"};
        String[] workplace = {"Actor", "Animator", "Barista", "Barmen", "Librarian"};
        int sizePersons = 10_000;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < sizePersons; i++) {
            persons.add(new Person(name[new Random().nextInt(name.length)]
                    , surName[new Random().nextInt(surName.length)]
                    , new Random().nextInt(18, 66), workplace[new Random().nextInt(workplace.length)]));
        }
        int threadSize = 5;
        ExecutorService service = Executors.newFixedThreadPool(threadSize);

        int sizePersonsInPrinter = persons.size() / threadSize;
        int startIndex = 0;
        int endIndex = sizePersonsInPrinter - 1;
        for (int i = 0; i < threadSize; i++) {
            service.submit(new PersonNamePrinter(persons.subList(startIndex, endIndex)));
            startIndex += sizePersonsInPrinter;
            endIndex += sizePersonsInPrinter;
        }

        waitingExecution(service);

    }

    private static void waitingExecution(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
