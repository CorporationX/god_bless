package school.faang.BJS236048;

import java.util.ArrayList;
import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private List<Person> personList = new ArrayList<>();
    @Override
    public void run() {
        personList.forEach(System.out::println);
    }
}
