package faang.school.godbless.helping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        int threadCount = 8;
        int personsCount = 10000;
        int personsCountPerThread = personsCount / threadCount;
        for (int i = 1; i<=personsCount;i++){
            persons.add(new Person(i));
        }
        ExecutorService threadBuild = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int start = i * personsCountPerThread;
            int end = start + personsCountPerThread;
            threadBuild.submit(new PersonNamePrinter(persons.subList(start,end)));
        }
        threadBuild.shutdown();
        try {
            final boolean b = threadBuild.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of program");
    }
}
