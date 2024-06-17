package faang.school.godbless.BJS_8044;

public class APP_8044 {

    public static void main(String[] args) {
        Westeros westeros = new Westeros();
        House stark = new House("Stark", "Wolf");
        House lannister = new House("Lannister", "Lion");
        House arren = new House("Arryn", "Eagle");
        House targaryen = new House("Targaryen", "Three heads dragon");
        westeros.addHouses(stark, lannister, arren, targaryen);
        westeros.getHousesAndCrest();
        House arr = new House("Arryn", "Bear");
        westeros.addHouse(arr);
        westeros.getHousesAndCrest();
        westeros.deleteHouseFromWesterosHouses("Arryn");
        westeros.getHousesAndCrest();
        westeros.getCrestInfo("Targaryen");
        westeros.getCrestInfo("Targaryenf");

    }

}