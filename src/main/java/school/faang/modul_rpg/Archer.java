package school.faang.modul_rpg;

class Archer extends Character {
    public static final int STRANGE = 3;
    public static final int AGILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRANGE, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), agility);
        opponent.takeDamage(agility);
    }
}