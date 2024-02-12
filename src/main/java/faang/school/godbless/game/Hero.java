package faang.school.godbless.game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        army.put( creature, army.getOrDefault( creature, 0 ) + quantity );
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey( creature )) {
            int currentQuantity = army.get( creature );
            if (currentQuantity <= quantity) {
                army.remove( creature );
            } else {
                army.put( creature, currentQuantity - quantity );
            }
        }
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }
}

class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int power1 = calculateTotalPower( hero1.getArmy() );
        int power2 = calculateTotalPower( hero2.getArmy() );

        if (power1 > power2) {
            return hero1;
        } else if (power2 > power1) {
            return hero2;
        } else {
            // If powers are equal, return null (draw)
            return null;
        }
    }

    private int calculateTotalPower(Map<Creature, Integer> army) {
        int totalPower = 0;
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            totalPower += entry.getKey().getDamage() * entry.getValue();
        }
        return totalPower;
    }
}

class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero( "Hero 1", "Faction 1", 2, 4, new HashMap<>() );
        Hero hero2 = new Hero( "Hero 2", "Faction 2", 3, 4, new HashMap<>() );

        // Add creatures to armies
        hero1.addCreature( new Pikeman( "Pikeman", 15, 10 ), 5 );
        hero1.addCreature( new Swordman( "Swordman", 15, 10 ), 5 );

        hero1.addCreature( new Pikeman( "Pikeman", 15, 10 ), 4 );
        hero1.addCreature( new Angel( "Swordman", 10, 12 ), 11 );
        // Create battlefield
        Battlefield battlefield = new Battlefield( hero1, hero2 );

        // Start the battle
        Hero winner = battlefield.battle();
        if (winner != null) {
            System.out.println( "The winner is: " + winner.getName() );
        } else {
            System.out.println( "The battle ended in a draw." );
        }
    }
}
