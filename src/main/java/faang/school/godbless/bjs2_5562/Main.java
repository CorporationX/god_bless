package faang.school.godbless.bjs2_5562;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        List<Person> personList = initializePersonList();
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        int banchSize = personList.size() / POOL_SIZE;

        for (int i = 0, startBanch = 0; i < POOL_SIZE; i++, startBanch += banchSize) {
            int endBanch = startBanch + banchSize;
            if (i == POOL_SIZE - 1) {
                endBanch = personList.size();
            }
            PersonNamePrinter printer = new PersonNamePrinter(personList.subList(startBanch, endBanch));
            executor.submit(printer);
        }
        executor.shutdown();
        try {
            while (!executor.awaitTermination(20, TimeUnit.MINUTES)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Program completed!");
    }


    private static List<Person> initializePersonList() {
        List<Person> personList = new ArrayList<>();
        String[] workPlaces = new String[]{"Cisco", "Amazon", "Microsoft", "BP", "VISA", "Tesla", "Uber", "Yandex", "Shell", "Facebook"};

        for (int i = 0; i < 10000; i++) {
            String workPlace = workPlaces[new Random().nextInt(0, workPlaces.length)];
            personList.add(new Person("Person-" + i, new Random().nextInt(19, 70 + 1), workPlace));
        }
        return personList;
    }
}
