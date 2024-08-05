package faang.school.godbless;

class Archer extends Character {
    Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character enemy) {
        enemy.takeHealthDamage(this.getAgility());
    }
}
