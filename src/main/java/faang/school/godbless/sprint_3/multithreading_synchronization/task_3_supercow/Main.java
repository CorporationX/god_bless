package faang.school.godbless.sprint_3.multithreading_synchronization.task_3_supercow;

public class Main {
    private static final int maxCountPlayer = 3;
    private static final int countPlayer = 6;

    public static void main(String[] args) {
        Boss antaras = new Boss(maxCountPlayer);

        for (int i = 0; i < countPlayer; i++) {
            Player player = new Player("player_" + (i + 1));

            new Thread(() -> {
                try {
                    player.startBattle(antaras);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
