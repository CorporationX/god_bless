package school.faang.abstraction;


abstract class Character {
    private String name;
    private int force;
    private int dexterity;
    private int intellect;
    @SuppressWarnings({"checkstyle:MemberName",
            "checkstyle:AbbreviationAsWordInName"})
    private int MAX_HEALTH = 100;

    public Character(String name, int force, int dexterity, int intellect) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name, int force, int dexterity, int intellect) {
        this.name = name;
        this.force = 5;
        this.dexterity = 5;
        this.intellect = 5;
    }
}

