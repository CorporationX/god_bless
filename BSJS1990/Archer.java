package BSJS1990;

public class Archer extends Character{
    public Archer(String name){
        super(name);
    }

    public void Archer(String name,int strong, int agility, int intel){
        this.name = name;
    }
    @Override
    public void attack(Character target){
        target.hp -= agility;
    }

}
}
