package faang.school.godbless.BJS2_24450;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<TamagotchiVlad> tamagotchiVlads = getTamagotchiVlads();
        VladController controller = new VladController(tamagotchiVlads);
        controller.feedAll();
        controller.playAll();
        controller.cleanAll();
        controller.sleepAll();
    }


    private static List<TamagotchiVlad> getTamagotchiVlads() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(TamagotchiVlad::new)
                .toList();
    }
}
