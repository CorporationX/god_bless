package school.faang.bjs2_85531;

public class Warrior extends Character {

    public Warrior() {
        super("Conan", 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getHealth() - getStrength();
        System.out.println(this.getName() +
                " бьет палкой по "
                + opponent.getName() +
                " и отнимает "
                + getStrength() +
                " ХП, остается "
                + damage);
    }





    @Override
    public void defeat() {
        System.out.println("Повержен");
    }
}
