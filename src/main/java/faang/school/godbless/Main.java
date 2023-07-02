package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad 1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad 2");
        TamagotchiVlad vlad3 = new TamagotchiVlad("Vlad 3");

        controller.addTamagotchiVlad(vlad1);
        controller.addTamagotchiVlad(vlad2);
        controller.addTamagotchiVlad(vlad3);

        Thread thread1 = new Thread(() -> {
            while (true) {
                controller.updateVladStatus();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            controller.feedAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.playAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.cleanAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
    }
}
