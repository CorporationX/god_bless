package school.faang.basic.abstraction.characters;

public class Trainee extends Character {

    public Trainee(String name) {
        super(name);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(Math.max(this.strength, this.agility));
    }
}