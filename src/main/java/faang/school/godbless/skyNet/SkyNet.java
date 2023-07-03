package faang.school.godbless.skyNet;

public class SkyNet {
  public static void main(String[] args) {
    Target target = new Target("Bob");
    Robot archi = new Robot(target);
    Robot richi = new Robot(target);

    Thread thread1 = new Thread(archi::attack);
    Thread thread2 = new Thread(richi::attack);

    thread1.start();
    thread2.start();
  }
}
