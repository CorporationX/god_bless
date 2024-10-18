package school.faang.BJS236048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int FROM_AGE = 18;
    private static final int TO_AGE = 65;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        String[] workPlace = {"Google", "Amazon", "Uber", "Nvidia"};
        Random random = new Random(workPlace.length);

        for (int i = 0; i < 999; i++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            int age = random.nextInt(FROM_AGE, TO_AGE);
            String company = workPlace[random.nextInt(workPlace.length)];
            personList.add(new Person(name, surname, age, company));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        int threadsCount = THREAD_COUNT;
        int subListSize = personList.size() / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            int fromIndex = i * subListSize;
            int toIndex = (i == threadsCount - 1) ? personList.size() : fromIndex + subListSize;
            List<Person> subList = personList.subList(fromIndex, toIndex);
            executorService.execute(new PersonInfoPrinter(subList));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
