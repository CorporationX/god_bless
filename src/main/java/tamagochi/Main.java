package tamagochi;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 10;
    private static final int VLAD_COUNT = 100;

    public static void main(String[] args) {
        Random rand = new Random();
        var tamagochies = initTamagochies();
        try (ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE)) {
            VladContoller vladContoller = new VladContoller(executorService);
            tamagochies.forEach(vlad -> executorService.execute(() -> vladContoller.addTamagochi(vlad)));
            vladContoller.playAll();
            vladContoller.removeTamagochi(tamagochies.get(rand.nextInt(tamagochies.size())));
            vladContoller.feedAll();
            vladContoller.removeTamagochi(tamagochies.get(rand.nextInt(tamagochies.size())));
            vladContoller.cleanAll();
            vladContoller.removeTamagochi(tamagochies.get(rand.nextInt(tamagochies.size())));
            vladContoller.sleepAll();
            vladContoller.removeTamagochi(tamagochies.get(rand.nextInt(tamagochies.size())));
        }
        tamagochies.forEach(vlad -> log.info(vlad.getInfo()));
    }

    private static List<TamagochiVlad> initTamagochies() {
        return IntStream.range(0, VLAD_COUNT)
                .mapToObj(TamagochiVlad::new)
                .toList();
    }
}
