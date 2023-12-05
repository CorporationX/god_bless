package faang.school.godbless.javahashmap;

import lombok.Data;

@Data
public class Battlefield {
    private Hero attacker = new Hero("vova", "orki",70,20);
    private Hero defender = new Hero("petia", "elfi",100, 30);

    Pikeman pikeman = new Pikeman("pik",12,50,14,3);
    Griffin griffin = new Griffin("gri",6,40,4,3);
    Swordman swordman = new Swordman("swo", 12,10,10,3);
    Angel angel = new Angel("ang",12,9,10,3);

    public void battle() {
        System.out.println("Battle!");
        attacker.addCreature(griffin, 40);
        defender.addCreature(pikeman, 100);
        System.out.println("Attacker: quantity = " + griffin.getQuantity());
        System.out.println( "Defender: quantity = " + pikeman.getQuantity());
        System.out.println("Attacker attack");
        defender.removeCreature(pikeman, 110);
        System.out.println( "Defender: quantity = " + pikeman.getQuantity());
        System.out.println("ATTACKER WIN!");

    }
}
