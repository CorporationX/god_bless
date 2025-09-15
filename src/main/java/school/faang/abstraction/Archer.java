package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + ",атакует " + opponent.getName() + "!");
        takeDamage(getAgility(), opponent);
        System.out.println(opponent.getName() + ", теряет " + getAgility() +
                " здоровья. Текущее здоровье: " + opponent.getHealth());

        if (opponent.isDead()) {
            System.out.println(opponent.getName() + " повержен!");
        }
    }
}
