package school.faang.bjs2_85531;

public class Archer extends Character {

    public Archer() {
        super("Legolas", 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getHealth() - getAgility();
        System.out.println(
                this.getName() +
                " бьет палкой по "
                + opponent.getName() +
                " и отнимает "
                + getAgility() +
                " ХП, остается "
                + damage);
    }

    @Override
    public void defeat() {
        System.out.println("Повержен");
    }
}
