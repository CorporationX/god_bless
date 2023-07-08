package faang.school.godbless.TamagotchiVlad;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        TamagotchiController controller = new TamagotchiController();
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                controller.add();
            }
        });

        Thread allThread = new Thread(() -> {
            controller.feedAll();
            controller.delete();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        Thread allThread2 = new Thread(() -> {
            controller.feedAll();
            controller.delete();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        addThread.start();
        addThread.join();

        allThread.start();
        allThread2.start();
    }
}
