package faang.school.godbless.BJS2_18911;

import java.util.List;

public class Battlefield {

    private Hero redSide;
    private Hero blueSide;
    private List<Creature> redArmy;
    private List<Creature> blueArmy;

    public Battlefield(Hero redSide, Hero blueSide) {
        this.redSide = redSide;
        this.blueSide = blueSide;
        redArmy = redSide.getArmy();
        blueArmy = blueSide.getArmy();
    }

    public Hero battle() {
        System.out.println("Бой начинается!");
        int redScore = 0, blueScore = 0;
        int index = 0;

        while (!redArmy.isEmpty() || !blueArmy.isEmpty()) {
            System.out.println("Начало раунда:");

            int redDamage = 0;
            if (!redArmy.isEmpty()) {
                redDamage = calculateDamage(redArmy.remove(index));
            }

            int blueDamage = 0;
            if (!blueArmy.isEmpty()) {
                blueDamage = calculateDamage(blueArmy.remove(index));
            }

            if (redDamage > blueDamage) {
                System.out.println("В раунде одержала победу красная команда...");
                redScore++;
            } else if (blueDamage > redDamage) {
                System.out.println("В раунде одержала победу синяя команда...");
                blueScore++;
            }
        }

        return getWinner(redScore, blueScore);
    }

    private int calculateDamage(Creature creature) {
        int creatureBonus = creature.getLevel() / 3;
        return creature.getDamage() + redSide.getBonus() + creatureBonus;
    }

    private Hero getWinner(int redScore, int blueScore) {
        int sumUp = Integer.compare(redScore, blueScore);

        if (sumUp > 0) {
            System.out.println("Бой побеждают красные!!!");
            return redSide;
        } else if (sumUp < 0) {
            System.out.println("Бой побеждают синие!!!");
            return blueSide;
        } else {
            System.out.println("Победила дружба :)");
        }

        return null;
    }
}
