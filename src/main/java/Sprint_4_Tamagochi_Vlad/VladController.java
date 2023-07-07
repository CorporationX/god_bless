package Sprint_4_Tamagochi_Vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {

    private List<TamagotchiVlad> tamagochies = new ArrayList<>();
    //будет управлять несколькими экземплярами класса TamagotchiVlad

    public void addTamagotchi(TamagotchiVlad tamagochi) {
        //synchronized (this) {
            tamagochies.add(tamagochi);
        //}
    }

    public void deleteTamagotchi(TamagotchiVlad tamagotchiVlad) {
        //synchronized (this) {
        //if (!tamagochies.isEmpty()) {
        if (tamagochies.contains(tamagotchiVlad)){
            tamagochies.remove(tamagotchiVlad);
            System.out.println(tamagochies);
        } else {
            System.out.println("Такого тамагочи не существует");
        }
    //}
}

    public void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagochies) {
            tamagotchiVlad.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagochies) {
            tamagotchiVlad.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagochies) {
            tamagotchiVlad.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagochies) {
            tamagotchiVlad.sleep();
        }
    }

    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad Vlad1 = new TamagotchiVlad("Barsik");
        TamagotchiVlad Vlad2 = new TamagotchiVlad("Masik");
        TamagotchiVlad Vlad3 = new TamagotchiVlad("Markiz");

//        controller.feedAll();
//        controller.playAll();
//        controller.cleanAll();
//        controller.sleepAll();

        //controller.addTamagotchi(Vlad1);
        controller.addTamagotchi(Vlad2);
        controller.addTamagotchi(Vlad3);

        System.out.println(controller.tamagochies);
        System.out.println();

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
        });
        Thread thread2 = new Thread(() -> {
            controller.playAll();
        });

        Thread thread3 = new Thread(() -> {
            controller.cleanAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(1567);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        controller.deleteTamagotchi(Vlad1);
        controller.deleteTamagotchi(Vlad2);
        controller.deleteTamagotchi(Vlad3);
    }
}

//        Thread thread0 = new Thread(() -> {
//            controller.addTamagotchi(Vlad1);
//            controller.addTamagotchi(Vlad2);
//            controller.addTamagotchi(Vlad3);
//        });
//
//        Thread thread1 = new Thread(() -> {
//            controller.feedAll();
//            controller.playAll();
//            controller.cleanAll();
//            controller.sleepAll();
//        });
//
//        Thread thread2 = new Thread(() -> {
//            controller.deleteTamagotchi(Vlad1);
//            controller.deleteTamagotchi(Vlad2);
//            controller.deleteTamagotchi(Vlad3);
//        });
//
//        thread0.start();
//        thread2.start();
//        thread1.start();


