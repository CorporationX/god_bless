package school.faang.bjs2_68159;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isDead()) {
            System.out.println(opponent.getName() + " has been defeated!");
            return;
        }
        Integer strength = this.getStrength();
        opponent.receiveDamage(strength);
        System.out.printf("%s attacks %s, left health %s %n", this.getName(), opponent.getName(), opponent.getHealth());
    }
}
