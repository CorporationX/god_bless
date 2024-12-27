package school.faang.task_49773;

public record Player(String name) {
    private static final long MIN_BATTLE_TIME = 1000;
    private static final long MAX_BATTLE_TIME = 5000;

    public Player(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Безымянный игрок";
        } else {
            this.name = name;
        }
    }

    public void startBattle(Boss boss) {
        if (boss == null) {
            System.out.println(name + " не может начать сражение: босс отсутствует.");
            return;
        }
        boss.joinBattle(this);

        try {
            Thread.sleep((long) (Math.random() * (MAX_BATTLE_TIME - MIN_BATTLE_TIME) + MIN_BATTLE_TIME));
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время сражения.");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}