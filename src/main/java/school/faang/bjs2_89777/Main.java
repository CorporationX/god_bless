package school.faang.bjs2_89777;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    @SuppressWarnings({"checkstyle:LocalVariableName", "checkstyle:AbbreviationAsWordInName"})
    public static void main(String[] args) {
        int THREAD_AMOUNT = 10;
        List<Person> persons = new ArrayList<>(10000);
        Random random = new Random();
        random.nextInt();
        for (Person person : persons) {
            person.setName(String.valueOf(random.nextInt(1, 1000)));
            person.setSurname(String.valueOf(random.nextInt(1, 1000)));
            person.setAge(random.nextInt(1, 1000));
            person.setWorkplace(String.valueOf(random.nextInt(1, 1000)));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        for (Person person : persons) {
            executor.execute(new PersonInfoPrinter(person));
        }


    }
}
