package Abstract;

public class Archer extends Character {
    public Archer(String name) {
        super(name,3,10,5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.println(String.format("The enemy received %s  points damage", this.agility));
    }
}
