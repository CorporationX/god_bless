package faang.school.godbless.Sprint4.VladToy;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();
        controller.addTamagotchi(new TamagotchiVlad("test-A"));
        controller.addTamagotchi(new TamagotchiVlad("test-B"));
        controller.addTamagotchi(new TamagotchiVlad("test-C"));
        controller.addTamagotchi(new TamagotchiVlad("test-D"));
        controller.addTamagotchi(new TamagotchiVlad("test-E"));

        controller.feedAll();
        controller.playAll();
        controller.cleanAll();
        controller.sleepAll();
        controller.executorsEnd();

    }
}
