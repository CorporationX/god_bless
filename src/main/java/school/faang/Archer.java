package school.faang;

public class Archer extends Character {
    @Override
    public void attack(Character character) {
        if (character.isAlive()) {
            character.setHealth(character.getHealth() - this.getDexterity());
        } else {
            character.setHealth(0);
            System.out.println(character.getName() + " is dead and cannot be attacked");
        }
    }

    @SuppressWarnings("checkstyle:Indentation")
    public Archer(String name) {
        super(name, 3, 10, 5);
    }
}
