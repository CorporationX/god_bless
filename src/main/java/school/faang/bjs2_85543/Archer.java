package school.faang.bjs2_85543;

public class Archer extends Character {


    public Archer(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Damage caused by " + this.getName() +
                "in size " + this.getAgility() +
                " by hero " + opponent.getName());
        this.setHealth(this.getHealth() - opponent.getStrength());

    }
}
