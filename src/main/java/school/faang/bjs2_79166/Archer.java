package school.faang.bjs2_79166;


public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (isKilled(opponent.health, agility)) {
            health = 0;
            throw new RuntimeException(opponent.name + " is killed");
        } else {
            System.out.println(String.format("%s наносит урон %s равный %d", this.name, opponent.name, this.agility));
            opponent.health -= this.agility;
        }
    }
}
