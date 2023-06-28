package help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Vasya", "Ivanov", 18, "Amazon");
        List<Person> people = new ArrayList<>();
        people.add(person);

        int threadPool = 10;
        int batchSize = 1000;
        List<Person> batch = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(threadPool);
        for (int i = 0; i < people.size(); i++) {
            batch.add(people.get(i));
            if(i + 1 % batchSize == 0){
                PersonNamePrinter task = new PersonNamePrinter(batch);
                executor.submit(task);
                batch = new ArrayList<>();
            }
        }
        if(!batch.isEmpty()){
            PersonNamePrinter task = new PersonNamePrinter(batch);
            executor.submit(task);
        }
        executor.shutdown();
        try {
            if(executor.awaitTermination(60, TimeUnit.SECONDS)){
                System.out.println("the program has ended");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
