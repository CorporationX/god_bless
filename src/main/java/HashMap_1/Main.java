package HashMap_1;

import HashMap_1.Army.Creatures.Angel;
import HashMap_1.Army.Creatures.Griffin;
import HashMap_1.Army.Creatures.Pikeman;
import HashMap_1.Army.Creatures.Swordman;
import HashMap_1.Army.Hero;

public class Main {
    public static void main(String[] args) {
        Hero orderHero = new Hero("Gogen", 20, "Order");
        Hero chaosHero = new Hero("Troll", 80, "chaos");

        Angel angel = new Angel(1);
        Griffin griffin = new Griffin(2);
        Swordman swordmanChaos = new Swordman(4);
        Swordman swordmanOrder = new Swordman(8);
        Pikeman pikemanOrder = new Pikeman(10);
        Pikeman pikemanChaos = new Pikeman(6);

        chaosHero.addCreature(griffin, angel.getQuantity());
        chaosHero.addCreature(pikemanChaos, pikemanChaos.getQuantity());
        chaosHero.addCreature(swordmanChaos, swordmanChaos.getQuantity());
        orderHero.addCreature(angel, angel.getQuantity());
        orderHero.addCreature(pikemanOrder, pikemanOrder.getQuantity());
        orderHero.addCreature(swordmanOrder, swordmanOrder.getQuantity());

        System.out.println("Win in battle Hero " + Battlefied.battle(orderHero, chaosHero).getName());
    }
}
