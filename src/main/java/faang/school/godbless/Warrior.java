package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,10, 5,3);
    }

    @Override
    public void atack(Character opponent){
        opponent.health -= this.power;
        System.out.println(this.name + " нанос урон в размере " + this.power + " " + opponent.name + "\nЗдоровье: " + opponent.health);
    }

}
