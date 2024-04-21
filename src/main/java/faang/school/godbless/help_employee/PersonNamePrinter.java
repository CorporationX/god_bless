package faang.school.godbless.help_employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private Person person;
    @Override
    public void run() {
        System.out.println(person.getWorkplace());
    }
}

