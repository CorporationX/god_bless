package faang.school.godbless;


public abstract class Character {
    private String name;
    protected int str;
    protected int dex;
    protected int intellect;
    protected int hp = 100;
    public Character (String name) {
        this.name = name;
    }
    public Character (String name, int str, int dex, int intellect) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.intellect = intellect;
    }
    public abstract void Attack (Character target);
}
