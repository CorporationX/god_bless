package Multithreading.bc2096;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    @Override
    public void run() {
        for (Person person : persons){
            System.out.println(Thread.currentThread().getName() + " " + person.getName());
        }
    }
}
