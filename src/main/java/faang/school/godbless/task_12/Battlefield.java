package faang.school.godbless.task_12;

public class Battlefield {
    private final Hero first;
    private final Hero second;

    public Battlefield(Hero first, Hero second) {
        this.first = first;
        this.second = second;
    }

    public Hero battle() {
        int firstDamage = 0;
        for (Creature friendly : first.getArmy().keySet()) {
            firstDamage += friendly.getDamage() * first.getArmy().get(friendly);
        }

        int secondDamage = 0;
        for (Creature opponent : second.getArmy().keySet()) {
            secondDamage += opponent.getDamage() * second.getArmy().get(opponent);
        }

        return firstDamage >= secondDamage ? first : second;
    }

}
