package BSJS1990;

public class Warrior extends Character{
    public Warrior(String name){
        super(name);
    }

    public void Warrior(String name,int strong, int agility, int intel){
        this.name = name;
    }
    @Override
    public void attack(Character target){
        target.hp -= strong;
    }

}
