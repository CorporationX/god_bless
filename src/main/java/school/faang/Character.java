package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Character {
    public String name;
    public int Strength;
    public int Agility;
    public int Intelligence;
    public int HeathPoints;
    public  Character(String name) {
        this.name = name;
        this.Strength = 5;
        this.Agility = 5;
        this.Intelligence = 5;
        this.HeathPoints = 100;
    }
    public  Character(String name, int Strength, int Agility, int Intelligence) {
        this.name = name;
        this.Strength = Strength;
        this.Agility = Agility;
        this.Intelligence = Intelligence;
        this.HeathPoints = 100;
    }
    public void attack(Character enemy){

    }
}
