package faang.school.godbless.BJS2_18648;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        System.out.println(String.format("%s наносит %s урона %s", this.name, this.agility, character.name));
        character.health -= this.agility;
        System.out.println(String.format("Здоровье %s = %s", character.name, character.health));
    }


}
