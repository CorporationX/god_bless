package school.faang.modul_rpg;

class Warrior extends Character {
    public static final int STRANGE = 10;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRANGE, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), strength);
        opponent.takeDamage(strength);
    }
}