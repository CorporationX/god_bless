package faang.school.godbless.BJS2_18648;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name, 10, 5 ,3);
    }

    @Override
    public void attack(Character character) {
        System.out.println(String.format("%s наносит %s урона %s", this.name, this.strength, character.name));
        character.health -= this.strength;
        System.out.println(String.format("Здоровье %s = %s", character.name, character.health));
    }
}
