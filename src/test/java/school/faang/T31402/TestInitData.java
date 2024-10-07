package school.faang.T31402;

public class TestInitData {
    public Archer archerStandard;
    public Warrior warriorStandard;
    public Archer archer;
    public Warrior warrior;

    public TestInitData() {
        this.generateData();
    }

    public void generateData(){
        archerStandard = new Archer( "Archer item");
        warriorStandard = new Warrior( "Warrior item");
        archer = new Archer( "Archer item");
        warrior = new Warrior( "Warrior item");
    }
}