package faang.school.godbless.Abstraction;

public abstract class Character {
     public int health = 100;
     private String name;
     private int power;
     private int agility;
     private int intelligence;

     public void setName (String setName){
         setName=name;
     }
    public void setPower (int setPower){
         setPower=power;
    }
    public void setAgility(int setAgility){
         setAgility=agility;
    }
    public void setIntelligence(int setIntelligence){
         setIntelligence=intelligence;
    }
    public String getName(){
         return name;
    }
    public int getPower(){
        return power;
    }
    public int getAgility(){
        return agility;
    }
    public int getIntelligence(){
        return intelligence;
    }


    public Character(String setName) {
        this.name = name;
    }

    protected abstract void attack(Character charter);
}




