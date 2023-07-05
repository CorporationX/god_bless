package faang.school.godbless.Multitrading2.TamagochiVlad;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController(new ArrayList<>());

        TamagotchiVlad vlad1 = new TamagotchiVlad(1);
        TamagotchiVlad vlad2 = new TamagotchiVlad(2);
        TamagotchiVlad vlad3 = new TamagotchiVlad(3);

        controller.addDevice(vlad1);
        controller.addDevice(vlad2);
        controller.addDevice(vlad3);


        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(controller::feedAll);
        service.execute(controller::cleanAll);
        service.execute(controller::sleepAll);
        service.execute(controller::playAll);
        service.shutdown();
        controller.removeDevice(vlad1);
    }
}
