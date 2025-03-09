package school.faang.task_61841;

public class Main {
    public static void main(String[] args) {
        Game darkSouls = new Game();

        for (int i = 0; i < 10; i++) {
            new Thread(darkSouls::update).start();
        }
    }
}
