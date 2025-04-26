package school.faang.stream3.synchronization.tamagotchivlad;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        List<String> names = Arrays.asList("Tom", "Angela", "Patrick");
        names.forEach(controller::createTamagotchi);

        VladCare care = new VladCare(controller);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(controller);
        executor.execute(care);
    }
}
