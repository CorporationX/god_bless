package school.faang.Abstract;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 20, 15, 20);
    }


    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
        System.out.println("Character attack : " + this.getName() + " has attacked " +   character.getName() + " - "+ "still has " + "Helth : " + character.getHealth());
    }
}
