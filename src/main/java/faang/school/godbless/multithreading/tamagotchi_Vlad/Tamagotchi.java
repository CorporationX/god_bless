package faang.school.godbless.multithreading.tamagotchi_Vlad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tamagotchi {
    public static void main(String[] args) {
        List<TamagotchiVlad> vlads = new ArrayList<>(IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new TamagotchiVlad())
                .toList());
        VladController vladController = new VladController(vlads);

        vladController.sleepAll(); //Если сразу же начать другую активность, то предыдущая прекратиться,
        vladController.cleanAll(); //это демонстрирует последний исполненный метод, который выполняется 5 секунд.
        vladController.feedAll();
        vladController.playAll();
        vladController.stop();

        TamagotchiVlad vlad4 = new TamagotchiVlad();
        vladController.addVlad(vlad4);
        vladController.removeVlad(vlads.get(2));
        vladController.getHappiness();
    }
}
