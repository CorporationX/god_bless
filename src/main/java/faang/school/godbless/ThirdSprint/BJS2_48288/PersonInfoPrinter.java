package faang.school.godbless.ThirdSprint.BJS2_48288;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private Person person;

    @Override
    public void run() {
        System.out.println(person.getName()
                + " " + person.getSurname()
                + " age: " + person.getAge()
                + " workplace: " + person.getWorkplace()
                + " current thread: " + Thread.currentThread().toString());

    }
}
