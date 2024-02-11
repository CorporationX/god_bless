package src.main.java.faang.school.godbless.BSJS1990;

public class Warrior extends Character{
    public Warrior(String name){
        super(name);
        this.strong = 10;
        this.agility = 5;
        this.intel = 3;
    }
    @Override
    public void attack(Character target){
        target.hp -= this.strong;
        System.out.println("Шарах на 10hp");
    }

}
