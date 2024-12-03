package school.faang.task43834;

public abstract class Character {
    protected String name;
    protected int strength; //����
    protected int dexterity; // ��������
    protected int intelligence; // ��������
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
