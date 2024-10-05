package school.faang;

public class TestInitData {
    public static Archer archerStandard;
    public static Warrior warriorStandard;
    public static Archer archer;
    public static Warrior warrior;

    static{
        generateData();
    }

    public static void generateData(){
        archerStandard = new Archer( "Archer item");
        warriorStandard = new Warrior( "Warrior item");
        archer = new Archer( "Archer item");
        warrior = new Warrior( "Warrior item");
    }
}