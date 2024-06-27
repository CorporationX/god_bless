package faang.school.godbless.HelpAColleague;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private Person person;
    @Override
    public void run() {
        System.out.println(person.getName());
    }
}
