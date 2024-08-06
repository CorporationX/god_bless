package faang.school.godbless.Task18288.Army;

import faang.school.godbless.Task18288.Creature;

public class SwordMan extends Creature {


    public SwordMan() {
        name = "SwordMan";
        level = 3;
        attack = 12;
        defense = 10;
        speed = 7;
    }

    @Override
    public int getDamage() {
        // Расчет урона с учетом атаки и защиты
        int damage = this.attack - this.defense;
        // Убедимся, что урон не отрицательный
        return Math.max(damage, 0);
    }
}
