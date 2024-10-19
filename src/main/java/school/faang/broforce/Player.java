package school.faang.broforce;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static List<Player> listOfAllPlayers = new ArrayList<>();

    private String name;
    private int lives = 5;
    private int damage = 10;
    private int health = 30;

    public Player(String name) {
        this.name = name;
        listOfAllPlayers.add(this);
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void hitPlayer(Player player, Game game) {
        if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - this.getDamage());
            System.out.println("Игрок " + this.name + " нанес " + this.getDamage() + " урона игроку " + player.getName());
            System.out.println("У игрока " + player.getName() + " осталось " + player.getHealth() + " хп.");

            if (player.getHealth() <= 0) {
                player.setLives(player.getLives() - 1);
                System.out.println("У игрока " + player.getName() + " осталась " + player.getLives() + " жизнь.");

                if (player.getLives() <= 0) {
                    System.out.println("Игрок " + player.getName() + " потерял все жизни. Игра заканчивается.");
                    game.gameOver(player);
                } else {
                    player.setHealth(30);
                    System.out.println("Игрок " + player.getName() + " восстановил здоровье до 30.");
                }
            }
        }
    }
}
