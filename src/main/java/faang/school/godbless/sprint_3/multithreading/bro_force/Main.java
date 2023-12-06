package faang.school.godbless.sprint_3.multithreading.bro_force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 9; i++) {
            Thread thread = new Thread(game::update);
            thread.start();
        }
    }
}
