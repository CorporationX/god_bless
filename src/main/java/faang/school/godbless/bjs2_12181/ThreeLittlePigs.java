package faang.school.godbless.bjs2_12181;

public class ThreeLittlePigs {

  private static final String GAME_OVER = "Game is over!";

  public static void main(String[] args) {

    PigOneThread pigOneThread = new PigOneThread("Ниф-Ниф", "солома");
    PigTwoThread pigTwoThread = new PigTwoThread("Нуф-Нуф", "палки");
    PigThreeThread pigThreeThread = new PigThreeThread("Наф-Наф", "кирпичи");

    pigOneThread.start();
    pigTwoThread.start();
    pigThreeThread.start();

    try {
      pigOneThread.join();
      pigTwoThread.join();
      pigThreeThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(GAME_OVER);
  }

}
