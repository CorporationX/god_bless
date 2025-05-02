package school.faang.bjs2_73524;

public record Player(String name, int countAttacks) {
    public static final int DUMMY_ATTACK_TIMEOUT_MS = 500;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            for (int i = 1; i <= countAttacks; i++) {
                System.out.printf("%s is attacking (%d)%n", name, i);
                Thread.sleep(DUMMY_ATTACK_TIMEOUT_MS);
            }
        } catch (InterruptedException e) {
            System.out.printf("%s is interrupted%n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
