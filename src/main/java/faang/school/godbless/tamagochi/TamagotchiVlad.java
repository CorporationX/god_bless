package faang.school.godbless.tamagochi;

public class TamagotchiVlad {
  public synchronized void feed() {
    System.out.println("Vlad was feeding by " + Thread.currentThread().getName() + " thread");
  }

  public synchronized void play() {
    System.out.println("Vlad played with " + Thread.currentThread().getName() + " thread");
  }

  public synchronized void clean() {
    System.out.println("Vlad was asked to clean the room by" + Thread.currentThread().getName() + " thread");
  }

  public synchronized void sleep() {
    System.out.println("Vlad went to sleep with " + Thread.currentThread().getName() + " thread");
  }

  public void wakeUp() {
    System.out.println("Vlad has woken up by " + Thread.currentThread().getName() + " thread alarm");
  }
}
