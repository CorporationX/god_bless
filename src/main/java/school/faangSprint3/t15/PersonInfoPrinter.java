package school.faangSprint3.t15;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;
    private final int threadId;

    public PersonInfoPrinter(List<Person> persons, int threadId) {
        this.persons = persons;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadId + " starting to process " + persons.size() + " persons");
        for (Person person : persons) {
            System.out.println("Thread " + threadId + ": " + person);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
                return;
            }
        }
        System.out.println("Thread " + threadId + " finished processing");
    }
}