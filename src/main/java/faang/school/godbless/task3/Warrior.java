package faang.school.godbless.task3;


public class Warrior extends Character {

    private Warrior(String name) {
        super(name);
    }

    public Warrior(int power, int dexterity, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.health = character.health - damage;
    }
}
