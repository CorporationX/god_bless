package faang.school.godbless.HeroesOfMightAndMagic;

import faang.school.godbless.HeroesOfMightAndMagic.Creatures.Creature;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hero {

    private final List<Creature> heroArmy = new ArrayList<>();
    private String name;
    private String factionName;
    private int level;
    private int exp;

    private int armyHp = 0;
    private int armyAttack = 0;

    public Hero(int exp, int level, String factionName, String name) {
        this.exp = exp;
        this.level = level;
        this.factionName = factionName;
        this.name = name;
    }

    public void addCreatures(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            heroArmy.add(creature);
            armyHp += creature.getDefence();
            armyAttack += creature.getDamage();
        }
    }

    public void deleteCreatures(Creature creature, int quantity) {
        if (!heroArmy.isEmpty()) {                //Проверка на пустую армию, что бы он просто так не отнимал HP армии и не уводил в минус
            for (int i = 0; i < quantity; i++) {
                heroArmy.remove(creature);
                armyHp -= creature.getDefence();
                armyAttack -= creature.getDamage();
            }
        }
    }

    public List<Creature> getArmy() {
        return heroArmy;
    }

    public void attack(Hero enemy) {
        enemy.setArmyHp(enemy.getArmyHp() - armyAttack);
        System.out.printf("Армия %s получила %d урона!\n", enemy.getName(), armyAttack);
    }
}
