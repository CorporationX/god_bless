package faang.school.godbless.javahashmap.task5herous_magic;

import lombok.Data;

@Data
public class Battlefield {
    private Hero attacker = new Hero("vova", "orki",70,20);
    private Hero defender = new Hero("petia", "elfi",100, 30);

    public void battle() {
        System.out.println("Battle!\n");
        System.out.println("Создание воинов:");
        Creature pikeman = new Pikeman("pik",12);
        Creature griffin = new Griffin("gri",6);
        Creature swordman = new Swordman("swo",7 );
        Creature angel = new Angel("ang",8);
        System.out.println(pikeman);
        System.out.println(griffin);
        System.out.println(swordman);
        System.out.println(angel);
        System.out.println();

        attacker.addCreature(griffin, 40);
        attacker.addCreature(swordman,70);
        defender.addCreature(pikeman, 100);
        defender.addCreature(angel, 20);
        System.out.println();

        System.out.println(defender.getArmy());
        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender);

        System.out.println(defender.getArmy());


    }
}
