package school.faang.bjs2_68159;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        Integer strength = this.getStrength();
        opponent.setHealth(opponent.getHealth() - strength);
        System.out.printf("%s attacks %s, left health %s %n", this.getName(), opponent.getName(), opponent.getHealth());
    }
}
