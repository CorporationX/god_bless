package abstraction;

public class Archer extends Character{
    public Archer(String name){
        super(name, 3,10,5);
    }
    public void attack(Character hero){
        hero.setHealth(hero.getHealth()-this.getDexterity());
    }
}
