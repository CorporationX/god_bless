package faang.school.godbless.HelpAColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> person;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начал работу");
        person.forEach(i -> System.out.println(i.getName()));
        System.out.println(Thread.currentThread().getName() + " завершил работу");
    }
}
