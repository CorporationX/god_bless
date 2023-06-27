package faang.school.godbless.thread.helpCollegaue;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> personList;

    @Override
    public void run() {
        for (Person person : personList) {
            System.out.println(person.getName());
        }

        System.out.printf("Поток %s завершил работу\n", Thread.currentThread().getName());
    }
}
