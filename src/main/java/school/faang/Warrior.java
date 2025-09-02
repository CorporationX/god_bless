package school.faang;

public class Warrior extends Character {
    @Override
    public void attack(Character character) {
        if (character.isAlive()) {
            character.setHealth(character.getHealth() - this.getStrength());
        } else {
            character.setHealth(0);
            System.out.println(character.getName() + " is dead and cannot be attacked");
        }
    }

    @SuppressWarnings("checkstyle:Indentation")
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }
}
