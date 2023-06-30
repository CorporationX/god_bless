package faang.school.godbless.skyNet;

public class SkyNet {
  public static void main(String[] args) {
    Robot archi = new Robot("bob");
    Robot richi = new Robot("blake");

    Thread thread1 = new Thread(archi::attack);
    Thread thread2 = new Thread(richi::attack);

    thread1.start();
    thread2.start();
  }
}
