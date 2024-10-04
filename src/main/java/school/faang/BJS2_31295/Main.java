package school.faang.BJS2_31295;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Unreal strongman");
        Character archer = new Archer("Unreal sniper");

        Character[] fighters = new Random().nextBoolean()
                ? new Character[]{warrior, archer}
                : new Character[]{archer, warrior};
        while (warrior.health > 0 && archer.health > 0) {
            fighters[0].attack(fighters[1]);
            if (fighters[1].health > 0)
                fighters[1].attack(fighters[0]);
        }
        System.out.println(warrior.health > 0
                ? "Победил воин, осталось здоровья " + warrior.health
                : "Победил лучник, осталось здоровья " + archer.health);
    }
}