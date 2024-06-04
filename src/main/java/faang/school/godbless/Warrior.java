package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name){
        super(name);
        this.name = name;
        setDefaultCharacteristics();
    }

    public Warrior(String name, int power, int agility, int intelligence){
        super(name,power,agility,intelligence);
        setDefaultCharacteristics();
    }

    private void setDefaultCharacteristics(){
        this.power = 10;
        this.agility = 5;
        this.intelligence =  3;
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealthPoints(enemy.healthPoints-this.getPower());
        System.out.println(enemy.getName() + " has " + enemy.getHealthPoints() + " health points left " );
    }
}
