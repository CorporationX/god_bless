package BJS2_7733;

public class Warrior extends Character {
    String name;

    public Warrior(String name) {
        super(name);
        super.power = 10;
        super.skill = 5;
        super.intellect = 3;
    }

    public void attack(Character character) {
        character.hp -= this.power;
    }
}


