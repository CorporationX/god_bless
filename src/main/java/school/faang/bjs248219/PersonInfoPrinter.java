package school.faang.bjs248219;

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
