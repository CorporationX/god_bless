package dima.evseenko.heroes;

import dima.evseenko.heroes.entity.Creature;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Battlefield {

    private final Hero hero1;
    private final Hero hero2;

    public Hero battle() {
        List<Creature> armyHero1 = List.copyOf(this.hero1.getArmy());
        List<Creature> armyHero2 = List.copyOf(this.hero2.getArmy());

        while (hero1.getArmy().size() > 0 && hero2.getArmy().size() > 0) {
            armyHero1.forEach(creatureHero1 -> {
                armyHero2.forEach(creatureHero2 -> {
                    attack(creatureHero1, creatureHero2, this.hero2);
                    attack(creatureHero2, creatureHero1, this.hero1);
                });
            });
        }

        Hero winner = this.hero1.getArmy().size() > this.hero2.getArmy().size() ? this.hero1 : this.hero2;
        winner.setLevel(winner.getLevel() + 1);

        return winner;
    }

    private void attack(Creature creatureHero1, Creature creatureHero2, Hero hero) {
        if (creatureHero1.getHp() > 0) {
            creatureHero1.attack(creatureHero2);
            if (creatureHero2.getHp() <= 0) {
                hero.deleteCreature(creatureHero2, 1);
            }
        }
    }
}
