package school.faang.colleague;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {

    private final List<Person> people;

    @Override
    public void run() {
        people.forEach(System.out::println);
    }
}
