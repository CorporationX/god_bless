package abstraction;

public class Warrior extends Character{
    public Warrior(String name){
        super(name,10,5,3);
    }
    public void attack(Character hero){
        hero.setHealth(hero.getHealth()-this.getPower());
    }
}
