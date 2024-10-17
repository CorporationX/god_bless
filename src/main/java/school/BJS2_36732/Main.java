package school.BJS2_36732;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad("tamagotchiVlad1");
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad("tamagotchiVlad2");
        TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad("tamagotchiVlad3");

        List<TamagotchiVlad> listOfVlads = new ArrayList<>();
        listOfVlads.add(tamagotchiVlad1);
        listOfVlads.add(tamagotchiVlad2);
        listOfVlads.add(tamagotchiVlad3);
        VladController vladController = new VladController(listOfVlads);

        Thread thread1 = new Thread(()-> vladController.sleepAll());
        Thread thread2 = new Thread(()-> vladController.feedAll());
        Thread thread3 = new Thread(()-> vladController.playAll());
        Thread thread4 = new Thread(()-> vladController.cleanAll());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
