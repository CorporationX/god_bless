package faang.school.godbless.HeroesOfMightAndMagic;

import faang.school.godbless.HeroesOfMightAndMagic.Creatures.Pikeman;
import faang.school.godbless.HeroesOfMightAndMagic.Creatures.Swordman;

public class Main {


    public static void main(String[] args) {
        Hero volodya = new Hero(15, 43, "Murmansk", "Volodya");
        Hero gennadiy = new Hero(14, 42, "Saratov", "gena");

        volodya.addCreatures(new Swordman(), 5);
        gennadiy.addCreatures(new Swordman(), 2);
        gennadiy.addCreatures(new Pikeman(), 4);
        gennadiy.deleteCreatures(new Pikeman(), 2);

        System.out.println(volodya.getArmyHp() + " " + volodya.getArmyAttack());  // 200 100
        System.out.println(gennadiy.getArmyHp() + " " + gennadiy.getArmyAttack()); // 150 90 при 2 мечниках и 2 копейщиках

        Battlefield battlefield = new Battlefield(volodya, gennadiy);
        battlefield.fight();
    }
}
