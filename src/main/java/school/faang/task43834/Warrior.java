package school.faang.task43834;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10; // Установка значений вручную
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - strength;
    }
}
