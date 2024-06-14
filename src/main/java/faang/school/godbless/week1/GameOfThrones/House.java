package faang.school.godbless.week1.GameOfThrones;


public class House {
    private String name;
    private String sigil;

    //Constractor fields
    House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    //Gettor Method
    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

    //Override toString method to provide a string representation of the house
    @Override
    public String toString(){
        return "House" + name+ ": "+ sigil;
    }
}
