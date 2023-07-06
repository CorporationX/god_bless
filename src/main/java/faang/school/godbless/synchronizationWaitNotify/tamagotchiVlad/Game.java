package faang.school.godbless.synchronizationWaitNotify.tamagotchiVlad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    public static void main(String[] args) {
        List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>(IntStream.rangeClosed(1, 10).boxed()
                .map(number -> new TamagotchiVlad("Tamagotchi №" + number)).toList());

        VladController vladController = new VladController(tamagotchiVladList);

        vladController.feedAll();
        vladController.cleanAll();
        vladController.addTamagotchi(new TamagotchiVlad("Peter"));
        vladController.playAll();
        vladController.sleepAll();
        vladController.deleteTamagotchi(tamagotchiVladList.get(3));
        vladController.playAll();
        vladController.feedAll();
        vladController.complete();
    }
}
