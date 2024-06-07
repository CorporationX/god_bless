package faang.school.godbless;

public class Archer extends Character{
public Archer(String name){
    super(name,3,10,5);
}

@Override
    public void atack(Character opponent){
    opponent.health -= this.dexterity;
    System.out.println(this.name + " нанос урон в размере " + this.dexterity + " " + opponent.name + "\nЗдоровье: " + opponent.health);
}

}
