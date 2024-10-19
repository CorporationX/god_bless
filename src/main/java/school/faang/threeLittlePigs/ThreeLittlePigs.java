package school.faang.threeLittlePigs;

public class ThreeLittlePigs {
  public static void main(String[] args) {
    Thread pig1Thread = new Pig1Thread("nif-nif", "straw");
    Thread pig2Thread = new Pig2Thread("nuf-nuf", "sticks");
    Thread pig3Thread = new Pig3Thread("naf-naf", "bricks");

    pig1Thread.start();
    pig2Thread.start();
    pig3Thread.start();

    try {
      pig1Thread.join();
      pig2Thread.join();
      pig3Thread.join();
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    System.out.println("Игра завершена!");
  }
}
