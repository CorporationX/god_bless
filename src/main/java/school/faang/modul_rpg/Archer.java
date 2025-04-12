package school.faang.modul_rpg;

class Archer extends Character {
    public static final int strange = 3;
    public static final int agility = 10;
    public static final int intelligence = 5;

    public Archer(String name) {
        super(name, strange, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), agility);
        opponent.takeDamage(agility);
    }
}