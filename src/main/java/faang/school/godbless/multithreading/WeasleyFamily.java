package faang.school.godbless.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        String[] chores = new String[]{"Washing", "Cooking", "Cleaning", "Sweeping", "Walking",
                "Gardening", "Painting", "Singing", "Dancing", "Drinking"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }
}
