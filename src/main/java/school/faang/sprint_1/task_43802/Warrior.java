package school.faang.sprint_1.task_43802;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, true);
    }

    @Override
    public void attack(Character target) {
        System.out.println("\nВоин атакует");

        if (!this.isAlive()) {
            System.out.println("не могу атаковать - я мертв");
            return;
        }

        if (!target.isAlive()) {
            System.out.println("не могу атаковать - " + target.getName() + " кормит червей");
            return;
        }

        target.setHealthPoints(target.getHealthPoints() - this.getStrength());
        System.out.println(this.getName() + " атакует " + target.getName() + " и наносит "
                + this.getStrength() + " урона");
        System.out.println(target.getName() + " поймал маслину, у него осталось " + target.getHealthPoints() + " HP");

        if (target.getHealthPoints() <= 0) {
            target.setAlive(false);
            target.setHealthPoints(0);
            System.out.println(target.getName() + " отправился в Вальгаллу");
        }

    }

}
