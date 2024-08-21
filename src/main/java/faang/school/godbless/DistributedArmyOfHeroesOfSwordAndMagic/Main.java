package faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic;

import faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic.Heroes.Archer;
import faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic.Heroes.Mage;
import faang.school.godbless.DistributedArmyOfHeroesOfSwordAndMagic.Heroes.Swordsman;

public class Main {
    public static void main(String[] args) {
        HeroesSquad heroesSquad = new HeroesSquad();
        heroesSquad.addHero(new Mage());
        heroesSquad.addHero(new Mage());

        HeroesSquad heroesSquad2 = new HeroesSquad();
        heroesSquad2.addHero(new Archer());
        heroesSquad2.addHero(new Archer());

        HeroesSquad heroesSquad3 = new HeroesSquad();
        heroesSquad3.addHero(new Swordsman());
        heroesSquad3.addHero(new Swordsman());

        Army army = new Army();
        army.addSquad(heroesSquad);
        army.addSquad(heroesSquad2);
        army.addSquad(heroesSquad3);

        System.out.println(army.calculateArmyPower());
    }
}
