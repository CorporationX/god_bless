public abstract class Character {

    protected static int health = 100;
    private String name;
    private int power;
    private int sleight;
    private int intellect;

    protected Character(String name){
        this.name=name;
    }

    protected Character(int power, int sleight, int intellect){
        this.sleight=sleight;
        this.intellect=intellect;
    }

    protected abstract void attack(Character character);
}

