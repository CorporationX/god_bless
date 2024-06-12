package faang.school.godbless;

public class Warrior extends Character {

    private final int DEFAULT_POWER = 10;
    private final int DEFAULT_DEXTERITY = 5;
    private final int DEFAULT_INTELLECT = 3;


    public Warrior(String name) {
        super(name);
        this.power = DEFAULT_POWER;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intellect = DEFAULT_INTELLECT;

    }

    @Override
    public void atack(Character opponent){
        opponent.health -= this.power;
        System.out.println(this.name + " наносит урон в размере " + this.power + " " + opponent.name + "\nЗдоровье: " + opponent.health);
    }

}
