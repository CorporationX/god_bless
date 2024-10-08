package school.faang.BJS2_32407_ThronesGames;

public class Main {
    public static void main(String[] args) {
        HousesService service = new HousesService();

        service.addHouse(new House("Stark", "A grey direwolf on a white field"));
        service.addHouse(new House("Lannister", "A golden lion on a crimson field"));
        service.addHouse(new House("Baratheon", "A crowned black stag on a gold field"));

        service.findAndPrintHouse("Stark");

        System.out.println();
        service.printAllHouses();

        System.out.println();
        service.removeHouse("Lannister");
        service.printAllHouses();
    }
}
