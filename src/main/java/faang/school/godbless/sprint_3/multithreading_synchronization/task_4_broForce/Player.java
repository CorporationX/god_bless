package faang.school.godbless.sprint_3.multithreading_synchronization.task_4_broForce;

public class Player implements Runnable {
    public static final int DEFAULT_LIVES_QTY = 5;
    private final Game game;
    private final String name;
    private int lives;

    public Player(Game game, String name, int lives) {
        this.game = game;
        this.name = name;
        this.lives = lives;
    }

    public Player(Game game, String name) {
        this(game, name, DEFAULT_LIVES_QTY);
    }

    public boolean decLives() {
        // если жизни закончились, то GAME OVER
        if (lives - 1 <= 0) {
            System.out.println(name + ": погиб.");
            game.setGameOver();
            return true;
        }

        // иначе увеличиваем уменьшаем здоровье игроку
        // и увеличиваем счётчик потерянных жизней
        lives--;
        System.out.printf("%s: теряет жизнь.(осталось: %d)\n", name, lives);
        game.incLives();
        return false;
    }

    @Override
    public void run() {
        System.out.printf("%s: приисодеинился к игре\n", name);
        while (!game.isGameOver()) {
            int chance = (int) (Math.random() * 10);


            // с шансом в 80% игрок получает 1 к score
            if (chance < 8) {

                // с шансом в 50% игрок теряет 1 live
                if (chance < 5) {

                    // если GAME_OVER, то выходим из игры
                    if (decLives()) {
                        break;
                    }
                }

                System.out.printf("%s: +очко\n", name);
                game.incScore();
            }
            // для демонстрации в консоли
            try {
                Thread.sleep(chance * 500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
