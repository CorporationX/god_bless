package faang.school.godbless.heroes.of.might.and.magic;

import faang.school.godbless.heroes.of.might.and.magic.creatures.Angel;
import faang.school.godbless.heroes.of.might.and.magic.creatures.Creature;
import faang.school.godbless.heroes.of.might.and.magic.creatures.Griffin;
import faang.school.godbless.heroes.of.might.and.magic.creatures.Pikeman;
import faang.school.godbless.heroes.of.might.and.magic.creatures.Swordman;

public class Main {
    public static void main(String[] args) {
        Hero artur = new Hero("Artur", "Kamelot", 10, 3);
        Hero morgana = new Hero("Morgana", "Magic", 14, 4);
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();
        artur.addCreature(griffin, 1);
        artur.addCreature(swordman, 6);
        morgana.addCreature(angel, 2);
        morgana.addCreature(pikeman, 1);
        BattleField.battleHero(artur, morgana);
    }
}
