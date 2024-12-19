package school.faang.bjs248033;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        people.forEach(System.out::println);
    }
}