package school.faang;

abstract class Character {
    private String name;
    private int strenght;
    private int agility;
    private int intelligence;
    private int heathl = 100;

    public Character(String name, int strenght, int agility, int intelligence, int heathl) {
        this.name = name;
        this.strenght = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.heathl = 100;
    }

    public Character(String name, int strenght, int agility, int intelligence) {
        this.name = name;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
        this.heathl = 100;
    }
}.
