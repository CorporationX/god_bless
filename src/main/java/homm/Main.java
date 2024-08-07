package homm;

import homm.creatures.Angel;
import homm.creatures.Creature;
import homm.creatures.Griffin;
import homm.creatures.Pikeman;
import homm.creatures.Swordsman;

import lombok.NonNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static homm.Battlefield.battle;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Garry", "Castle");
        Hero hero2 = new Hero("Charles", "Castle");
        initHero(hero1);
        initHero(hero2);

        battle(hero1, hero2);
    }

    public static void initHero(@NonNull Hero hero) {
        Random rand = new Random();
        Set<Creature> creatures = new HashSet<>();
        creatures.add(new Pikeman());
        creatures.add(new Griffin());
        creatures.add(new Swordsman());
        creatures.add(new Angel());
        for(Creature creature : creatures) {
            int count = rand.nextInt(100) % (creature.getCount() + 1);
            if (count > 0) {
                hero.addCreature(creature, count);
            }
        }
        System.out.println("\nHero " + hero.getName() + " hired quite an army!");
        System.out.println("His army have:");
        for(Map.Entry<Creature, Integer> entry : hero.getCreatures().entrySet()) {
            System.out.println("    " + entry.getValue() + " units of " + entry.getKey().getName());
        }
    }
}
