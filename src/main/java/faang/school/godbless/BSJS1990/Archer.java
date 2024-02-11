package src.main.java.faang.school.godbless.BSJS1990;

public class Archer extends Character{

    public Archer(String name){
        super(name);
        this.strong = 3;
        this.agility = 10;
        this.intel = 5;
    }

    @Override
    public void attack(Character target){
        target.hp -= this.agility;
        System.out.println("Стрелу в заднизуй воткнул на 10hp");
    }

}

