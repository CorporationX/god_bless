package school.faang.BJS236048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        String[] workPlace = {"Google", "Amazon", "Uber", "Nvidia"};
        Random random = new Random(workPlace.length);

        for (int i = 0; i < 999; i ++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            int age = random.nextInt(60) + 18;
            String company = workPlace[random.nextInt(workPlace.length)];
            personList.add(new Person(name, surname, age, company));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int threadsCount = 5;
        int subListSize = personList.size() / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            int fromIndex = i * subListSize;
            int toIndex = (i == threadsCount - 1) ? personList.size() : fromIndex + subListSize;
            List<Person> subList = personList.subList(fromIndex, toIndex);
            executorService.execute(() -> {
                subList.forEach(person -> {
                    try {
                        Thread.sleep(500);
                        System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge() + " " + person.getWorkPlace());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
