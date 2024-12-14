package school.faang.task139;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
public class Battlefield {

    private Hero firstHero;
    private Hero secondHero;

    public void battle() {
        //creating list for pseudo-random
        ArrayList<Creature> firstHeroUnion = new ArrayList<>();
        ArrayList<Creature> secondHeroUnion = new ArrayList<>();

        for (Creature creature : firstHero.getArmy().keySet()) {
            firstHeroUnion.add(creature);
        }

        for (Creature creature : secondHero.getArmy().keySet()) {
            secondHeroUnion.add(creature);
        }

        int firstArmySize;
        int secondArmySize;

        while ((firstArmySize = firstHeroUnion.size()) != 0 && (secondArmySize = secondHeroUnion.size()) != 0) {
            Random random = new Random();
            int firstI = random.nextInt(firstArmySize);
            int secondI = random.nextInt(secondArmySize);
            Creature firstHeroMob = firstHeroUnion.get(firstI);
            Creature secondHeroMob = secondHeroUnion.get(secondI);

            int attackDamage = firstHeroMob.getAttackDamage();
            int receivedDamage = secondHeroMob.getResistance(attackDamage);
            String killed;

            if (receivedDamage >= secondHero.getArmy().get(secondHeroMob)) {
                killed = "Всех";
                secondHeroUnion.remove(secondHeroMob);
            } else {
                killed = String.valueOf(receivedDamage);
            }

            System.out.println(firstHeroMob.getName() + " из первой армии Убил " + killed + " "
                    + secondHeroMob.getName() + " " + " из второй армии ");
            secondHero.removeCreature(secondHeroMob, receivedDamage);

            if (secondHeroUnion.size() == 0 || firstHeroUnion.size() == 0) {
                break;
            }

            firstArmySize = firstHero.getArmy().size();
            secondArmySize = secondHero.getArmy().size();
            firstI = random.nextInt(firstArmySize);
            secondI = random.nextInt(secondArmySize);
            firstHeroMob = firstHeroUnion.get(firstI);
            secondHeroMob = secondHeroUnion.get(secondI);

            attackDamage = secondHeroMob.getAttackDamage();
            receivedDamage = firstHeroMob.getResistance(attackDamage);

            if (receivedDamage >= firstHero.getArmy().get(firstHeroMob)) {
                killed = "Всех";
                firstHeroUnion.remove(firstHeroMob);
            } else {
                killed = String.valueOf(receivedDamage);
            }

            System.out.println(secondHeroMob.getName() + " из второй армии Убил " + killed + " "
                    + firstHeroMob.getName() + " " + " из первой армии ");
            firstHero.removeCreature(firstHeroMob, receivedDamage);

            System.out.println("===========================================================================");
            System.out.println();
        }

        if (firstHero.getArmy().size() == 0) {
            System.out.println("Победил первый герой");
        } else {
            System.out.println("Победил второй герой");
        }

    }
}
