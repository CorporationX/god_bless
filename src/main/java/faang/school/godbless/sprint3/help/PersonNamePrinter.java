package faang.school.godbless.sprint3.help;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private Person person;
    @Override
    public void run() {
        System.out.println(person.getName());
    }
}
