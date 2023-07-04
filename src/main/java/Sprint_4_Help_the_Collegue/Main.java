package Sprint_4_Help_the_Collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            people.add(new Person("name = " + i, "surname = " + i, i, "workplace = " + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            executorService.submit(new PersonNamePrinter(people.subList(i*10_000/10, (i+1)*10_000/10)));
        }
        executorService.shutdown();

    }
}
