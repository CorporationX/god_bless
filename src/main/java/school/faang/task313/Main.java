package school.faang.task313;

import school.faang.task313.chore.Chore;
import school.faang.task313.family.WeasleyFamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        ExecutorService service = Executors.newCachedThreadPool();

        for (String str : weasleyFamily.getChores()) {
            service.submit(new Chore(str));
        }

        service.shutdown();
        try {
            if(!service.awaitTermination(2, TimeUnit.MINUTES)){
                service.shutdownNow();
                System.out.println("Что то пошло не так");
            }
        }
        catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
