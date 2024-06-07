package faang.school.godbless.gameofthrones;

public class Main {
    public static void main(String[] args) {
        House.addHouse(new House("Stark", "Direwolf"));
        House.addHouse(new House("Lannister", "Lion"));
        House.addHouse(new House("Baratheon", "Stag"));
        House.addHouse(new House("Targaryen", "Dragon"));

        House.deleteHouse("Stark");
        House.listAllHouses();
        House.findHouse("Targaryen");
        House.findHouse("Stark");
    }

}
