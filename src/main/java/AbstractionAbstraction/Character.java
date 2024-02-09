package AbstractionAbstraction;

public abstract class Character {
    private String name;
    private int force;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        validationCharCreate(name, 0, 0, 0);
        this.name = name;
        this.force = 0;
        this.agility = 0;
        this.intelligence = 0;
    }

    public Character(String name, int force, int agility, int intelligence) {
        validationCharCreate(name, force, agility, intelligence);
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public abstract void attack(Character character);

    private void validationCharCreate(String name, int force, int agility, int intelligence) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Не указано имя");
        if (force < 0 || force > 100) throw new IllegalArgumentException("Некорректный показатель силы");
        if (agility < 0 || agility > 100) throw new IllegalArgumentException("Некорректный показатель лвокости");
        if (intelligence < 0) throw new IllegalArgumentException("Некорректный показатель интеллекта");
    }
}
