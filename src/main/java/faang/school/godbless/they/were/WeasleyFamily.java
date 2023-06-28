package faang.school.godbless.they.were;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"eat out", "have some sleep", "wash up"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String ch: chores) {
            Chore chore = new Chore(ch);
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
