package faang.school.godbless.BJS2_643;

public abstract class Character {
    String name;
    int power;
    int dexterity;
    int intelligence;
    int health = 100;

     public Character(String name) {
        this.name = name;
    }

    public Character(int power, int dexterity, int intelligence) {
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

     abstract void attack(Character character);
}

