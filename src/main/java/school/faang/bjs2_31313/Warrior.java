package school.faang.bjs2_31313;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        target.setHp(target.getHp() - this.getStrength());
    }
}
