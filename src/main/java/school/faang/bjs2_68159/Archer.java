package school.faang.bjs2_68159;


public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 5, 10);
    }

    @Override
    public void attack(Character opponent) {
        Integer agility = this.getAgility();
        opponent.setHealth(opponent.getHealth() - agility);
        System.out.printf("%s attacks %s, left health %s %n", this.getName(), opponent.getName(), opponent.getHealth());
    }
}
