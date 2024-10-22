package school.faang.synchronization.broForce;

public class Main {

    public static void main(String[] args) {
       Game game = new Game();
       for (int i = 0; i < 50; i++) {
           boolean isGotScore = Math.random() > 0.5;
           boolean isDied = Math.random() > 0.5;
           game.update(isGotScore, isDied);
       }
    }
}
