package faang.school.godbless.BJS2_18891.battle;

import faang.school.godbless.BJS2_18891.heroes.Hero;
import faang.school.godbless.BJS2_18891.units.Creature;
import lombok.Data;

@Data
public class BattleCreature<T extends Creature> {

    private String name;
    private Integer speed;
    private Integer attack;
    private Integer defense;
    private Integer health;
    private Integer quantity;
    private Integer fullHealth;
    private Hero hero;

    public BattleCreature(T creature, Integer quantity) {
        this.name = creature.getName();
        this.speed = creature.getSpeed();
        this.attack = creature.getAttack();
        this.defense = creature.getDefense();
        this.health = creature.getHealth();
        this.quantity = quantity;
        this.fullHealth = quantity * health;
    }

    public void makeDamage(BattleCreature<T> defender) {
        int damage = quantity * (this.attack - (this.attack * defender.defense/100));
        defender.setFullHealth(fullHealth - damage);
        if (defender.fullHealth <= 0 ) {
            defender.setQuantity(0);
        } else {
            int newQuantity = (int) Math.ceil((double) defender.fullHealth/ (double) health);
            defender.setQuantity(newQuantity);
        }

        System.out.printf("%s (%s) наносит %d урона по %s (%s)%n",
                this.getName(), this.hero, damage, defender.getName(), defender.getHero());
    }
}
