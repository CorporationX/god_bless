package faang.school.godbless.multithreading.tamagotchi_Vlad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tamagotchi {
    public static void main(String[] args) {
        List<TamagotchiVlad> vlads = new ArrayList<>(IntStream.rangeClosed(1, 10)
                .boxed()
                .map(i -> new TamagotchiVlad())
                .toList());
        VladController vladController = new VladController(vlads);
        TamagotchiVlad vlad11 = new TamagotchiVlad();

        vladController.addVlad(vlad11);
        vladController.sleepAll();
        vladController.removeVlad(vlads.get(2));
    }
}
