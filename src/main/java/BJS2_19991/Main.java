package BJS2_19991;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        house.add("Старк", "Gray");
        house.add("Ланнистер", "Golden");
        house.add("Баратеон", "Brown");

        house.printSigilByHouseName("Старк"); // Gray

        house.removeByName("Ланнистер");

        house.printAllHouses();
    }
}
