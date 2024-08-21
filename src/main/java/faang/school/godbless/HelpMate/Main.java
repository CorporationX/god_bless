package faang.school.godbless.HelpMate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String temp = Integer.toString(i);
            people.add(new Person(temp, temp, 18, temp));
        }
        int threadCount = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int peopleInList = 10000/5;

        List<Person> tempPeople = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            tempPeople.add(people.get(i));
            if ((i + 1) % peopleInList == 0) {
                List<Person> copy = new ArrayList<>(tempPeople);
                executorService.submit(new PersonNamePrinter(copy));
                tempPeople = new ArrayList<>();
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("выполнено");
    }
}
