package sprint3.lambda.game;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        System.out.printf("%s атакует %s!\n", getName(), character.getName());
        character.inflictDamage(this.getStrength());
    }
}
