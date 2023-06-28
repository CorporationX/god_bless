package faang.school.godbless.Distributed_army_of_heroes;

public class Army {
    private int archersPower;
    private int swordsmanPower;
    private int magePower;

    public void addUnit (Warrior warrior){
        int power =warrior.getPower()*warrior.getAmount();
        if (warrior instanceof Archer){
            archersPower+=power;
        } else if (warrior instanceof Archer){
            swordsmanPower+=power;
        } else if (warrior instanceof Archer){
            magePower+=power;
        }
    }

    public int calculateTotalPower(){
        return archersPower+swordsmanPower+magePower;
    }

}
