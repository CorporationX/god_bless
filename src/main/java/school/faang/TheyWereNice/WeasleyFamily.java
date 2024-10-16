package school.faang.TheyWereNice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("Chore I"),
                new Chore("Chore II"),
                new Chore("Chore III")
        );

        ExecutorService service = Executors.newCachedThreadPool();

        chores.forEach(service::execute);

        service.shutdown();

        while(!service.isTerminated()) {}
        System.out.println("Done!!!");
    }
}
