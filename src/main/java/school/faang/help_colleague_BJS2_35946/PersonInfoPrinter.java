package school.faang.help_colleague_BJS2_35946;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}