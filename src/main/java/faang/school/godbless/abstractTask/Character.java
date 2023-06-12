package faang.school.godbless.abstractTask;

import lombok.Data;

@Data
abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int health = 100;

    public void Character (String name){
        this.name = name;
    }
    public void Character(int strength, int agility, int intelligence){
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

    }
    public void attack(Character character) {
        int battle = character.health - this.agility;
        System.out.println(battle);
    }

}
