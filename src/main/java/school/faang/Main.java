package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int quantityOfUsers = 70;

        List<String> listOfTheRoles = new ArrayList<>();
        listOfTheRoles.add("лорд");
        listOfTheRoles.add("рыцарь");
        listOfTheRoles.add("маг");

        House targaryen = new House("Targaryen", listOfTheRoles);
        House stark = new House("Stark", listOfTheRoles);
        House lannister = new House("Lannister", listOfTheRoles);
        House baratheon = new House("Baratheon", listOfTheRoles);

        List<House> listOfTheHouses = new ArrayList<>();
        listOfTheHouses.add(targaryen);
        listOfTheHouses.add(stark);
        listOfTheHouses.add(lannister);
        listOfTheHouses.add(baratheon);

        for (int i = 1; i <= quantityOfUsers; i ++) {
            int preferedHouse = (int) (Math.random() * 4);
            int preferedRole = (int) (Math.random() * 3);
            User user = new User(("номер " + i),
                    listOfTheRoles.get(preferedRole));
            Thread thread = new Thread(
                    () -> {
                        try {
                            user.joinHouse(listOfTheHouses.get(preferedHouse),
                                    user.getPreferedRole());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            thread.start();
        }
    }

}
