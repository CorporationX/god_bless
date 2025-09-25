package school.faang.bjs2_89721;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        String[] chores = new String[]{"Wash the floor", "Wash the dishes", "Dust the furniture", "Wash the windows"};

        ExecutorService executors = Executors.newCachedThreadPool();

        for (String c : chores) {
            Chore chore = new Chore(c);
            executors.submit(chore);
        }
        executors.shutdown();
    }
}
