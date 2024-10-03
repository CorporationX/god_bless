package Abstract;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,10,5,3);
    }

    @Override
    public void attack (Character character){
        character.HEALTH -= this.strength;
        System.out.println(String.format("The enemy received %s  points damage", this.strength));
    }
}
