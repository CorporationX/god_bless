package faang.school.godbless;

class Warrior extends Character {
    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character enemy) {
        enemy.takeHealthDamage(this.getStrength());
    }
}
