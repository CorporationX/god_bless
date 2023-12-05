package faang.school.godbless.javahashmap;

import lombok.Data;

@Data
public class Battlefield {
    private Hero attacker = new Hero("vova", "orki",70,20);
    private Hero defender = new Hero("petia", "elfi",100, 30);

    Pikeman pikeman = new Pikeman("pik",12);
    Griffin griffin = new Griffin("gri",6);
    Swordman swordman = new Swordman("swo",7 );
    Angel angel = new Angel("ang",8);

    public void battle() {
        System.out.println("Battle!");
        attacker.addCreature(griffin, 40);
        defender.addCreature(pikeman, 100);
        System.out.println("Attacker " + attacker.getName() + ": quantity army = " + griffin.getQuantity());
        System.out.println( "Defender " + defender.getName() + ": quantity army = " + pikeman.getQuantity());
        System.out.println("Attacker attack");
        defender.removeCreature(pikeman, 110);
        System.out.println( "Defender: quantity = " + pikeman.getQuantity());
        System.out.println("ATTACKER WIN!");

    }
}
