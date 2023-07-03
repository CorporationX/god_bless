package faang.school.godbless.thirdSprint.Tamagotchi;

public class Main {
    private static final int VLAD_COUNT = 5;

    public static void main(String[] args) {
        VladController controller = new VladController();

        for (int i = 1; i <= VLAD_COUNT; i++) {
            controller.addVlad(new TamagotchiVlad(i));
        }

        Thread thread1 = new Thread(() -> {
            controller.checkAll();
            controller.cleanAll();
            controller.playAll();
        });

        Thread thread2 = new Thread(() -> {
            controller.feedAll();
            controller.deleteVlad(1);
            controller.checkAll();
        });

        thread1.start();
        thread2.start();
    }
}
