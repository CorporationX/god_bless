package faang.school.godbless.broForce;

public class Main {
  public static void main(String[] args) {
    Game game = new Game();
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(game::update);
      thread.start();
    }
  }
}
