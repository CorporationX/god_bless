package faang.school.godbless.multi.task4vlad;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        controller.addVlad(new TamagotchiVlad("Vlad1"));
        controller.addVlad(new TamagotchiVlad("Vlad2"));
        controller.addVlad(new TamagotchiVlad("Vlad3"));
        controller.removeVlad(new TamagotchiVlad("Vlad2"));

        Runnable task = () -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
