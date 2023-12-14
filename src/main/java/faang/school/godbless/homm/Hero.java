package faang.school.godbless.homm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class Hero {
    private final String CHOOSE_UNIT_TEXT = "1 - Swordsman; " + "2 - Deadman; " + "3 - Dragon; ";
    private final Scanner CONSOLE = new Scanner(System.in);
    private final Creature SWORDSMAN = new Swordsman();
    private final Creature DEADMAN = new Deadman();
    private final Creature DRAGON = new Dragon();
    private Map<String, Creature> allies = new HashMap<>();
    private String name;
    private int hp = 100;
    private Creature creature;

    public Hero (String name) {
        this.name = name;
    }

    protected void addCreature (Creature creature, int quantity) {
        if (allies.get(creature.getName()) == null) {
            switch (creature.getName()) {
                case "Swordsman" -> allies.put(creature.getName(), new Swordsman());
                case "Deadman" -> allies.put(creature.getName(), new Deadman());
                case "Dragon" -> allies.put(creature.getName(), new Dragon());
            }
        }

        allies.get(creature.getName()).setQuantity(allies.get(creature.getName()).getQuantity() + quantity);
    }

    protected void removeCreature (Creature creature, int quantity) {
        Creature getCreatureFromAllies = allies.get(creature.getName());

        if (getCreatureFromAllies != null) {
            getCreatureFromAllies.setQuantity(Math.max(getCreatureFromAllies.getQuantity() - quantity, 0));

            if (getCreatureFromAllies.getQuantity() == 0) {
                allies.remove(creature.getName());
            }
        }
    }

    protected void attackEnemyHero (Hero enemy, int damage) {
        enemy.setHp(enemy.getHp() - damage);
    }

    protected int attackEnemyCreature (String creatureName, int damage, Hero enemy) {
        damage = getArmy().containsKey(creatureName)
                ? getArmy().get(creatureName).getDamage()
                : 0;

        System.out.println("Who will you attack?");
        System.out.println(CHOOSE_UNIT_TEXT);

        int selectCreatureToBeAttacked = CONSOLE.nextInt();

        switch (selectCreatureToBeAttacked) {
            case 1 -> {
                if (getArmy().containsKey(creatureName) && enemy.getArmy().containsKey(SWORDSMAN.getName())) {
                    enemy.removeCreature(SWORDSMAN, 1);
                }
            }
            case 2 -> {
                if (getArmy().containsKey(creatureName) && enemy.getArmy().containsKey(DEADMAN.getName())) {
                    enemy.removeCreature(DEADMAN, 1);
                }
            }
            case 3 -> {
                if (getArmy().containsKey(creatureName) && enemy.getArmy().containsKey(DRAGON.getName())) {
                    enemy.removeCreature(DRAGON, 1);
                }
            }
            default -> System.out.println("Sorry, you missed");
        }
        return damage;
    }

    protected Map<String, Creature> getArmy () {
        return allies;
    }
}
