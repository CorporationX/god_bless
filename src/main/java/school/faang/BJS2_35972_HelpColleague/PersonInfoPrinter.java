package school.faang.BJS2_35972_HelpColleague;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> persons;
    private int startIndex;
    private int endIndexExclusive;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndexExclusive)
                        .forEach(index ->
                                System.out.printf(
                                        "Name: %s, surname: %s, age: %d, workplace: %s",
                                        persons.get(index).getName(), persons.get(index).getSurname(),
                                        persons.get(index).getAge(), persons.get(index).getWorkplace()
                                ));
    }
}
