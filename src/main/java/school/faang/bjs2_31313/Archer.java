package school.faang.bjs2_31313;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.hp -= this.agility;
    }

}