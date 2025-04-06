package school.faang.BJS2_68086;

public abstract class Character {

    String name;
    int strength;
    int dexterity;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        dexterity = 5;
        intelligence = 5;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
    }

    public void checkIfOpponentIsKilled(Character opponent) {
        if (opponent.health <= 0) {
            System.out.println("Fatality");
        }
    }


}
