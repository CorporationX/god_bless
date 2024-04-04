package faang.school.godbless.thrones;

public class Main {
    public static void main(String[] args) {
        HouseStorage storage = new HouseStorage();
        String name1 = "Stark";
        String name2 = "Lannister";
        String name3 = "Baratheon";
        String name4 = "Targaryen";
        String sigil1 = "Wolf";
        String sigil2 = "Lion";
        String sigil3 = "Deer";
        String sigil4 = "Dragon";

        storage.addHouse(name1, sigil1);
        storage.addHouse(name2, sigil2);
        storage.addHouse(name3, sigil3);
        storage.addHouse(name4, sigil4);

        storage.displayAll();

        storage.deleteByName(name1);

        storage.displayAll();

        storage.findHouseByName(name4);
    }
}
