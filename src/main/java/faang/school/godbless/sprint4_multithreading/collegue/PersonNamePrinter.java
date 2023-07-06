package faang.school.godbless.sprint4_multithreading.collegue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PersonNamePrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        for (Person personName : people) {
            System.out.println(Thread.currentThread().getName() + " " + personName);
        }
    }
}
