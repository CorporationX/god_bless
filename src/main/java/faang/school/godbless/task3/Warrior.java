package faang.school.godbless.task3;


public class Warrior extends Character {

    public Warrior(String name) {
        super(10, 5, 3);
    }


    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.health = character.health - damage;
    }
}
