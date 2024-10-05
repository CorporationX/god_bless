package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, String strength, String dexterity, String intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
    }
}
