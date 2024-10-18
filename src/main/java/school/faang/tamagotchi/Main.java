package school.faang.tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        VladController controller = new VladController();

        List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();
        tamagotchiVlads.add(new TamagotchiVlad("Влад-1"));
        tamagotchiVlads.add(new TamagotchiVlad("Влад-2"));
        tamagotchiVlads.add(new TamagotchiVlad("Влад-3"));

        for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
            controller.addTamagochi(tamagotchiVlad);
        }

        controller.deleteTamagochi(tamagotchiVlads.get(2));

        List<Runnable> runnables = new ArrayList<>();
        runnables.add(controller::feedAll);
        runnables.add(controller::playAll);
        runnables.add(controller::cleanAll);
        runnables.add(controller::sleepAll);

        List<Thread> threads = new ArrayList<>();
        for (Runnable runnable : runnables) {
            threads.add(new Thread(runnable));
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}