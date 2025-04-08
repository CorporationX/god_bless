package school.faang.modul_rpg;

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), strength);
        opponent.takeDamage(strength);
    }
}