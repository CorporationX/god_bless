package faang.school.godbless.Task18288.Army;

import faang.school.godbless.Task18288.Creature;

public class Griffin extends Creature {


    public Griffin() {
        name = "Griffin";
        level = 2;
        attack = 8;
        defense = 8;
        speed = 6;
    }

    @Override
    public int getDamage() {
        // Расчет урона с учетом атаки и защиты
        int damage = this.attack - this.defense;
        // Убедимся, что урон не отрицательный
        return Math.max(damage, 0);
    }
}
