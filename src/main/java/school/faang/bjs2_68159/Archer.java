package school.faang.bjs2_68159;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 5, 10);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isDead()) {
            System.out.println(opponent.getName() + " has been defeated!");
            return;
        }
        Integer agility = this.getAgility();
        opponent.receiveDamage(agility);
        System.out.printf("%s attacks %s, left health %s %n", this.getName(), opponent.getName(), opponent.getHealth());
    }
}
