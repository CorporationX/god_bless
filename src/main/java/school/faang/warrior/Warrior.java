package school.faang.warrior;

public class Warrior extends school.faang.warrior.Character {
    public Warrior(String name, int power, int agility, int intelligence) {
        super("Warrior", 10, 5, 3);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        character.health -= character.power;
    }
}
