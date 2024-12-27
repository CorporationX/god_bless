package derschrank.sprint03.task11.bjstwo_49559;

public class Main {
    private static final int COUNT_OF_TAMO = 10;

    public static void main(String[] args) {
        TamagotchiInterface t = new TamagotchiVlad("Ivan");
        VladController controller = new VladController();

        for (int i = 0; i < COUNT_OF_TAMO; i++) {
            controller.addTamo(new TamagotchiVlad("Tamo #" + i));
        }

        Runnable plan1 = () -> {
            controller.feedAll();
            controller.statusAll();
            controller.playAll();
            controller.statusAll();
            controller.cleanAll();
            controller.statusAll();
            controller.feedAll();
            controller.statusAll();
        };

        Runnable plan2 = () -> {
            controller.feedAll();
            controller.playAll();
            controller.sleepAll();
            controller.cleanAll();
            controller.feedAll();
            controller.sleepAll();
            controller.statusAll();
        };
        Thread thread1 = new Thread(plan1);
        thread1.start();
        Thread thread2 = new Thread(plan2);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!!!!");
        }
    }
}
