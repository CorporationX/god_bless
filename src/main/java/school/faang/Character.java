package school.faang;


abstract public class Character {
    String name;
    int strength;
    int dexterity;
    int intelligence;
    int health;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100; // Устанавливаем здоровье по умолчанию
    }

    abstract public void attack(Character enemy);
}
