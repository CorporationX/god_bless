package school.faang.bjs49802;

import java.util.List;

public class Main {

    private static final int TAMAGOTCHI_COUNT = 2;

    public static void main(String[] args) {
        VladController parvin = new VladController();
        for (int i = 0; i < TAMAGOTCHI_COUNT; i++) {
            parvin.addVlad(new TamagotchiVlad("Vladushka " + i));
        }
        List<Runnable> tasks = List.of(
                parvin::feedAll,
                parvin::playAll,
                parvin::cleanAll,
                parvin::sleepAll);
        tasks.forEach(task -> new Thread(task).start());
    }

}
