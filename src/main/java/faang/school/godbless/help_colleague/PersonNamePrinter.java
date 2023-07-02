package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> personList;

    @Override
    public void run() {
        personList.stream().forEach((person) -> System.out.println("Thread: " + Thread.currentThread().getName() +" " + "Имя: " + person.getName()));
    }
}
