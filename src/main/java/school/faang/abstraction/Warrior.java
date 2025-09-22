package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + ",атакует " + opponent.getName() + "!");
        takeDamage(getStrength(), opponent);
        System.out.println(opponent.getName() + ", теряет " + getStrength() +
                " здоровья. Текущее здоровье: " + opponent.getHealth());

        if (opponent.isDead()) {
            System.out.println(opponent.getName() + " повержен!");
        }
    }
}
