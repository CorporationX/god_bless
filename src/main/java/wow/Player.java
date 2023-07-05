package wow;

public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public void increaseExperience(int value){
        this.experience += value;
        System.out.println("Experience of player " + name + " increased by " + value +
                "\n Now the player's experience is " + experience);
    }

    public void increaseLevel(){
        this.level += 1;
        System.out.println("   Level of player " + name + " increased." +
                "\n    Now the player's level is " + level);
    }
}
