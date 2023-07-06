package Sprint_4_Help_the_Collegue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{

    private List <Person> people;
    @Override
    public void run() {
        for (Person onePerson : people) {
            System.out.println(Thread.currentThread().getName() + " " + onePerson.getName());
        }
    }
}
