package school.faang.tamogachivlad.main;

import school.faang.tamogachivlad.maincode.TamagotchiVlad;
import school.faang.tamogachivlad.maincode.VladController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        VladController controller = new VladController();

        List<String> names = Arrays.asList("vlad1", "vlad2", "vlad3", "vlad4");

        names.forEach(name -> controller.addVlad(new TamagotchiVlad(name)));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        List<Runnable> tasks = Arrays.asList(
                () -> controller.feedAll(),
                () -> controller.playAll(),
                () -> controller.cleanAll(),
                () -> controller.sleepAll()
        );

        tasks.forEach(service::submit);


        service.shutdown();
        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
