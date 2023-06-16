package task3;

public abstract class Character {
    //чтобы было видно поля во всех наследниках,
    //какой модификатор доступа на них нужно повесить (protected)
    protected String name;
    protected static int power;
    protected static int cleverness;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int cleverness, int intelligence) {
        this.power = power;
        this.cleverness = cleverness;
        this.intelligence = intelligence;
    }

    /*abstract*/
    public void attack(Character anotherCharacter) {
    }
}

