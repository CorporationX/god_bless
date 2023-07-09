package faang.school.godbless;

public class DayOfVlad {
    public static void main(String[] args) {
        VladController controller = new VladController();

        controller.addVlad(new TamagotchiVlad("Pro-CS-Vlad"));
        controller.addVlad(new TamagotchiVlad("Pivo-Drinker-Vlad"));
        controller.addVlad(new TamagotchiVlad("IT-GlbIba-Vlad"));
        controller.addVlad(new TamagotchiVlad("Good-Vlad"));
        controller.addVlad(new TamagotchiVlad("Not-Very-Good-Vlad"));

        TamagotchiVlad vlad = new TamagotchiVlad("VladTerminator");

        Thread thread1 = new Thread(() -> {
            controller.addVlad(vlad);
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });


        Thread thread2 = new Thread(() -> {
            controller.sleepAll();
            controller.removeVlad(vlad);
        });

        thread1.start();
        thread2.start();
    }
}
