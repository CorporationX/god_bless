public class Archer extends Character{
    private String name;

    public Archer(int power, int skil,int intelligence,String name) {
        super(power = 3, skil = 10, intelligence = 5);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        health = health - character.power;

    }
}


