package faang.school.godbless.abstraction;

public class Archer extends Character {
    private int strength;
    private int agility;
    private int intelligence;

    public Archer (String name){
        super(name);
        this.agility = 10;
        this.strength = 3;
        this.intelligence = 5;
    }

    @Override
    public String attack(Character character) {
        int damage = this.agility;
        if (character.health > damage){
            character.health -= damage;
            return String.format(Message.DAMAGE_DONE, damage, character.health);
        }
        character.health -=damage;
        return String.format(Message.ENEMY_DEAD, damage);

    }
}
