package school.faang.bjs2_31288;

public class Warrior extends Character{

    public Warrior(String name){
        super(name,
            10,
            5,
            3);
    }

    @Override
    public void attack(Character opponent){
        System.out.println(name + " атакует " + opponent.name + " с силой " + strength);
        opponent.takeDamage(strength);
    }
}
