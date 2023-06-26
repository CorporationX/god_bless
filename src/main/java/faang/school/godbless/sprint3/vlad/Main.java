package faang.school.godbless.sprint3.vlad;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();

        TamagotchiVlad tamagotchiVlad = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad();

        vladController.createVlad(tamagotchiVlad);
        vladController.createVlad(tamagotchiVlad2);
        vladController.createVlad(tamagotchiVlad3);
        vladController.deleteVlad(tamagotchiVlad);

        Thread thread = new Thread(() -> {
            vladController.feedAll();
            vladController.playAll();
            vladController.cleanAll();
            vladController.sleepAll();
        });
        thread.start();
    }
}
