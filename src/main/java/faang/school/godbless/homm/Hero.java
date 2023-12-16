package faang.school.godbless.homm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class Hero {
    private List<Creature> Creatures = new LinkedList<>();
    private Scanner console = new Scanner(System.in);
    private String name;
    private int hp = 100;

    public Hero(String name) {
        this.name = name;
    }

    protected void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        if (!getArmy().contains(creature)) {
            getArmy().add(creature);
        }
    }

    protected void removeCreature(Creature creature) {
        for (Creature unit : getArmy()) {
            if (unit.getClass().equals(creature.getClass())) {
                unit.setQuantity(Math.max(unit.getQuantity() - 1, 0));
                System.out.println(unit.getQuantity());
                break;
            }
        }
    }

    private int attackEnemyHero(Hero enemy) {
        System.out.println("Choose your soldier:");
        System.out.println(showAvailableCreatures());

        int selectCreature = getConsole().nextInt();
        int damage = 0;
        Creature creature;

        while (selectCreature - 1 >= getArmy().size()) {
            System.out.println("Wrong select, try again.");
            selectCreature = getConsole().nextInt();
        }

        creature = getArmy().get(selectCreature - 1);

        for (Creature unit : getArmy()) {
            if (unit.getClass().equals(creature.getClass())) {
                damage = creature.getDamage();
                break;
            }
        }
        enemy.setHp(enemy.getHp() - damage);

        return damage;
    }

    protected void attackEnemyArmy(Hero enemy) {
        System.out.println("Who will you attack?");
        System.out.println(enemy.showAvailableCreatures());

        int damageDealed = attackEnemyHero(enemy);
        int selectCreatureToBeAttacked = getConsole().nextInt();

        if (selectCreatureToBeAttacked - 1 < enemy.getArmy().size() && damageDealed != 0) {
            enemy.removeCreature(enemy.getArmy().get(selectCreatureToBeAttacked - 1));
        } else {
            System.out.println("No enemy creature killed.");
        }
    }

    protected void buildArmy() {
        Creature Swordsman = new Swordsman();
        Creature Deadman = new Deadman();
        Creature Dragon = new Dragon();
        List<Creature> availableCreatures = new LinkedList<>(Arrays.asList(Swordsman, Deadman, Dragon));

        System.out.println(getName() + "'s turn");
        System.out.println("Build your army (choose 7 units)");

        int maxQuantity = 7;
        int currentQuantity = 0;

        for (Creature creature : availableCreatures) {
            System.out.println("How many " + creature.getName() + "?");

            int quantity = getConsole().nextInt();
            quantity = maxQuantity - (currentQuantity + quantity) > 0
                    ? quantity
                    : Math.max(maxQuantity - currentQuantity, 0);

            addCreature(creature, quantity);
            currentQuantity += quantity;
        }

        System.out.println("Your army:");

        for (Creature unit : getArmy()) {
            System.out.println(unit.getName() + ": " + unit.getQuantity());
        }
    }

    protected List<Creature> getArmy() {
        List<Creature> emptyCreatures = new ArrayList<>();

        for (Creature creature : getCreatures()) {
            if (creature.getQuantity() == 0) {
                emptyCreatures.add(creature);
            }
        }

        getCreatures().removeAll(emptyCreatures);
        return getCreatures();
    }

    protected String showAvailableCreatures() {
        StringBuilder availableCreatures = new StringBuilder();

        for (int i = 0; i < getArmy().size(); i++) {
            availableCreatures.append((int)(i + 1) + ": " + getArmy().get(i).getName() + "\n");
        }

        return availableCreatures.toString();
    }
}
