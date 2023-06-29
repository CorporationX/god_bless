package Multithreading.bc2096;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonNamePrinter implements Runnable {
    private Person person;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " " + person.getName());
    }
}
