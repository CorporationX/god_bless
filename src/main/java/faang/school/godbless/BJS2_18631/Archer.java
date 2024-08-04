package faang.school.godbless.BJS2_18631;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.printf("Лучник %s наносит %d урона\n", this.name, this.strength);
    }
}
