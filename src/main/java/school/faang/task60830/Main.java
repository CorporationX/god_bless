package school.faang.task60830;


import school.faang.task60830.service.Chore;
import school.faang.task60830.service.WeasleyFamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.addTask(new Chore("покрасить забор"));

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore task: family.getTasks()) {
            executor.submit(task);
        }
        executor.shutdown();
        System.out.println("Все задачи выполнены!");
    }
}
