package school.faang.bjs2_90325;

public class Main {
    private static final int TIME_BY_SLEEP_MILLIS = 500;

    public static void main(String[] args) {
        Boss boss = new Boss(5, 0);

        for (int i = 1; i <= 10; i++) {
            Player player = new Player("Player" + i);

            new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток был прерван");
                }
            }).start();

            try {
                Thread.sleep(TIME_BY_SLEEP_MILLIS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
