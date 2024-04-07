package faang.school.godbless.BJS24717;

import lombok.Setter;

@Setter
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int damageArmy1 = hero1.getArmy().stream()
                .mapToInt(Creature::getDamage)
                .sum();
        System.out.println("Атака первой армии: " + damageArmy1);
        int damageArmy2 = hero2.getArmy().stream()
                .mapToInt(Creature::getDamage)
                .sum();
        System.out.println("Атака второй армии: " + damageArmy2);

        return (damageArmy1 > damageArmy2) ? hero1 : hero2;
    }
}
