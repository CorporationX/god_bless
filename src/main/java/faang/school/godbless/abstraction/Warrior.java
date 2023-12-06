package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name){
        super(name, 5, 5, 3);
    }

    @Override
    public String attack(Character character) {
        int damage = this.strength;
        if (character.health > damage){
            character.health -= damage;
            return String.format(Message.DAMAGE_DONE, damage, character.health);
        }
        character.health -= damage;

        return String.format(Message.ENEMY_DEAD, damage);
    }
}
