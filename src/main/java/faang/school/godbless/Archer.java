package faang.school.godbless;

public class Archer extends Character{

    private final int DEFAULT_POWER = 3;
    private final int DEFAULT_DEXTERITY = 10;
    private final int DEFAULT_INTELLECT = 5;

    public Archer(String name){
    super(name);
    this.power = DEFAULT_POWER;
    this.dexterity = DEFAULT_DEXTERITY;
    this.intellect = DEFAULT_INTELLECT;
}

@Override
    public void atack(Character opponent){
    opponent.health -= this.dexterity;
    System.out.println(this.name + " наносит урон в размере " + this.dexterity + " " + opponent.name + "\nЗдоровье: " + opponent.health);
}

}
