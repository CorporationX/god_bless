package school.faang.m1s3.bjs2_35956_helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int N_THREADS = 5;
    private static String[] workplaces = new String[]{"Meta", "Apple", "Amazon", "Netflix", "Google", "Microsoft", "Uber"};

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 10011; i++) {
            personList.add(new Person(
                    "Alpha_" + i,
                    "Beta_" + i,
                    new Random().nextInt(20, 65),
                    workplaces[new Random().nextInt(workplaces.length)]
            ));
        }

        int batchSize = personList.size() / N_THREADS;

        ExecutorService service = Executors.newFixedThreadPool(N_THREADS);

        for (int i = 0; i < personList.size(); i += batchSize) {
            int endIndex = Math.min((i + batchSize), personList.size());
            List<Person> batch = personList.subList(i, endIndex);

            service.submit(new PersonInfoPrinter(batch));
        }
        service.shutdown();

        try {
            if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.out.println("Service failed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Work finished successfully!");
    }
}
