package school.faang.modul_rpg;

class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), agility);
        opponent.takeDamage(agility);
    }
}