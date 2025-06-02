package school.faang.bjs2_79166;


public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (isKilled(opponent.health, strength)) {
            health = 0;
            throw new RuntimeException(opponent.name + " is killed");
        } else {
            System.out.println(String.format("%s наносит урон %s равный %d", this.name, opponent.name, this.strength));
            opponent.health -= this.strength;
        }
    }
}
