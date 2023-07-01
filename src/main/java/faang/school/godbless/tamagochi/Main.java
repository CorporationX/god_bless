package faang.school.godbless.tamagochi;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    VladController vladController = new VladController();

    TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad();
    TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad();
    TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad();
    TamagotchiVlad tamagotchiVlad4 = new TamagotchiVlad();
    TamagotchiVlad tamagotchiVlad5 = new TamagotchiVlad();

    vladController.addTamagotchiVlad(tamagotchiVlad1);
    vladController.addTamagotchiVlad(tamagotchiVlad2);
    vladController.addTamagotchiVlad(tamagotchiVlad3);
    vladController.addTamagotchiVlad(tamagotchiVlad4);
    vladController.addTamagotchiVlad(tamagotchiVlad5);

    Thread thread1 = new Thread(() -> {
      vladController.feedAll();
      vladController.playAll();
      vladController.cleanAll();
      vladController.sleepAll();
    });

    Thread thread2 = new Thread(() -> {
      vladController.playAll();
      vladController.wakeUpAll();
      vladController.playAll();
      vladController.wakeUpAll();
    });

    thread1.start();
    thread2.start();
    vladController.deleteTamagotchi(tamagotchiVlad2);

    thread1.join();
    thread2.join();

    System.out.println("Tamagochi finished his day ");
  }
}
