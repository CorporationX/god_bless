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

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(controller::feedAll));
        threads.add(new Thread(controller::playAll));
        threads.add(new Thread(controller::cleanAll));
        threads.add(new Thread(controller::sleepAll));

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