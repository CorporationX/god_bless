package faang.school.godbless.spring_4.they_were_very_nice_but_extremely_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> choreList = List.of("приготовить", "помыть пол", "порешать задачи", "погулять");

        ExecutorService pool = Executors.newCachedThreadPool();
        choreList.forEach(chore -> pool.submit(new Thread(new Chore(chore))));
        pool.shutdown();
    }
}
