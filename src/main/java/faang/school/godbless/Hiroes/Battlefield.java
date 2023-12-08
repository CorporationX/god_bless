package faang.school.godbless.Hiroes;

import java.util.List;

public class Battlefield {
    private Hero hero;
    private Hero hero1;
    private List<Creature> armyHero;
    private List<Creature> armyHero1;


    public Battlefield(Hero hero, Hero hero1, List<Creature> armyHero, List<Creature> armyHero1) {
        this.hero = hero;
        this.hero1 = hero1;
        this.armyHero = armyHero;
        this.armyHero1 = armyHero1;
    }

    public Hero battle() {
        int damageArmyHero = 0;
        int defenceArmyHero = 0;
        for (Creature creature : armyHero) {
            for (int i = 0; i < armyHero.size(); i++) {
                damageArmyHero += creature.damage;
                defenceArmyHero += creature.defence;
            }
        }
        int powerArmyHero =damageArmyHero+defenceArmyHero;
        int damageArmyHero1=0;
        int defenceArmyHero1=0;
        for (Creature creature : armyHero1){
            for (int i = 0; i < armyHero1.size(); i++) {
                damageArmyHero1+=creature.damage;
                defenceArmyHero1+=creature.defence;
            }
        }
        int powerArmyHero1=damageArmyHero1+defenceArmyHero1;
        if(powerArmyHero1>powerArmyHero){
            return hero1;
        }else {
            return hero;
        }
    }

}
