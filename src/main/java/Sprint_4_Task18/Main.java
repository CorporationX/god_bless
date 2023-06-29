package Sprint_4_Task18;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();
        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });
        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.feedAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
    }
}
