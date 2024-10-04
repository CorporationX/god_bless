package dima.evseenko.thrones;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vesteros vesteros = new Vesteros();
        vesteros.addHouses(getHouses());
        vesteros.addHouse(new House("Талли", "Прыгающая серебряная форель среди красно-синих волн"));
        vesteros.printHouses();

        vesteros.deleteHouse(new House("Бронны", "Пылающая стрела на сером фоне"));
        vesteros.deleteHouse("Грейджои");
        vesteros.printHouses();

        System.out.println(vesteros.getHouse("Ланнистеры"));
        System.out.println(vesteros.getSigil("Старки"));
    }

    private static List<House> getHouses() {
        return List.of(
                new House("Бронны", "Пылающая стрела на сером фоне"),
                new House("Аррены", "Белый летящий сокол и месяц на синем фоне"),
                new House("Баратеоны", "Чёрный коронованный олень, стоящий на задних ногах, на золотом поле"),
                new House("Грейджои", "Золотой кракен на чёрном фоне"),
                new House("Ланнистеры", "Золотой лев, стоящий на задних лапах, на алом поле"),
                new House("Мартеллы", "Красное солнце, пронзённое золотым копьём, на оранжевом фоне"),
                new House("Старки", "Голова серого лютоволка на бело-зелёном фоне")
        );
    }
}
