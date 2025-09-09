package Task_1_2_3;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    // Конструктор: только имя, характеристики по 5, здоровье 100
    public Character(String name) {
        this(name, 5, 5, 5);
    }

    // Конструктор: имя + характеристики (здоровье по умолчанию 100)
    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    // Абстрактный метод атаки
    public abstract void attack(Character opponent);

    // Общий метод родительского класса для уменьшения здоровья (не ниже 0)
    public void takeDamage(int damage) {
        if (damage < 0) {
            return; // защита от отрицательного урона (если потребуется)
        }
        this.health = Math.max(0, this.health - damage);
    }

    // Дополнительные геттеры для удобства
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

