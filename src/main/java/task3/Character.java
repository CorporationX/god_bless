package task3;
public abstract class Character {
    private String name;
    protected int power;
    protected int cleverness;
    protected int intelligence;
    protected static int health =100;

//    public Character(String name, int power, int cleverness, int intelligence) {
//        this.name = name;
//        this.power = power;
//        this.cleverness = cleverness;
//        this.intelligence = intelligence;
//        this.health = 100;
//    }

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int cleverness, int intelligence) {
        this.power = power;
        this.cleverness = cleverness;
        this.intelligence = intelligence;
    }
}

