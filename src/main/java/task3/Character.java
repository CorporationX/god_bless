package task3;

public abstract class Character {
    //чтобы было видно поля во всех наследниках, модификатор доступа protected на них нужно повесить
    protected String name;
    protected int power;
    protected int cleverness;
    protected int intelligence;
    protected int health = 100;

    public Character(String name, int power, int cleverness, int intelligence) {
        this.name = name;
        this.power = power;
        this.cleverness = cleverness;
        this.intelligence = intelligence;
    }

    /*abstract*/
    public void attack(Character anotherCharacter) {
    }
}

