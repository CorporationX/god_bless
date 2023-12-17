package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
 public abstract class Character {
    private String name;
    private int Strength;
    private int Agility;
    private int Intelligence;
    private int Health = 100;

     public Character(String name) {
         this.name = name;
     }

     public Character(int strength, int agility, int intelligence) {
         Strength = strength;
         Agility = agility;
         Intelligence = intelligence;
     }

     public abstract void attack(Character character);
 }


