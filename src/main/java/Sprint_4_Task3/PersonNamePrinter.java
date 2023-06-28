package Sprint_4_Task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class PersonNamePrinter implements Runnable {
    private List<Person> persons;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + persons.size());
    }
}
