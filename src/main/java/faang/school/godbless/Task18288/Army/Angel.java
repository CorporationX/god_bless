package faang.school.godbless.Task18288.Army;

import faang.school.godbless.Task18288.Creature;

public class Angel extends Creature {

    public Angel() {
        name = "Angel";
        level = 5;
        attack = 20;
        defense = 20;
        speed = 15;
    }

    @Override
    public int getDamage() {
        // Расчет урона с учетом атаки и защиты
        int damage = this.attack - this.defense;
        // Убедимся, что урон не отрицательный
        return Math.max(damage, 0);
    }
}
