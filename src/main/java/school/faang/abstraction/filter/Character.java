package school.faang.abstraction.filter;

// Базовый класс персонажа
abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    // Конструктор с именем (базовые значения)
    Character(String name) {
        this(name, 5, 5, 5);
    }

    // Главный конструктор
    Character(String name, int str, int agi, int intel) {
        this.name = name;
        this.strength = str;
        this.agility = agi;
        this.intelligence = intel;
    }

    abstract void attack(Character target);

    // Общий метод для урона
    void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }
}

// Класс воина
class Warrior extends Character {
    Warrior(String name) {
        super(name, 10, 5, 3); // super вызывает конструктор родителя
    }

    @Override
    void attack(Character target) {
        System.out.println(name + " бьет мечом!");
        target.takeDamage(strength); // используем силу
    }
}


