package faang.school.godbless.Sprint_3.Multythreading.HelpingColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(); // 10 000 people
        persons.add(new Person("John", "Neon", 18, "Corporation X"));
        persons.add(new Person("Lex", "Lox", 12, "Corporation Xxx"));
        persons.add(new Person("hong", "hol", 84, "Corporation Xx"));
        int threads = persons.size() / 1000;
        if(threads == 0 && persons.size() > 0) threads = 1;
        ExecutorService executor = newFixedThreadPool(threads);
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < threads; ++i) {
            if(i + 1 == threads) {
                endIndex = persons.size();
                List<Person> batch = persons.subList(startIndex, endIndex);
                executor.submit(new PersonNamePrinter(batch));
            } else {
                endIndex = startIndex + 1000;
                List<Person> batch = persons.subList(startIndex, endIndex);
                executor.submit(new PersonNamePrinter(batch));
                startIndex = endIndex;
            }
        }
        executor.shutdown();
    }
}
