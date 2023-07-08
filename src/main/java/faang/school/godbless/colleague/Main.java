package faang.school.godbless.colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Person> person = new ArrayList<>(10000);
        for (int i = 0; i <= person.size(); i++) {
            person.add(new Person());
        }

        int threadsCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        int personListOfPart = person.size() / threadsCount;

    }
}
