package faang.school.godbless.DiversificationHeroesOfMagic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = List.of(new Archer(50), new Mage(30),
                new Swordsman(100),new Swordsman(400));
        Army army = new Army(characters);
        System.out.println(army.calculatePower());
    }
}
