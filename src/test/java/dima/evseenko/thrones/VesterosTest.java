package dima.evseenko.thrones;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VesterosTest {

    @Test
    void addHouse(){
        Vesteros vesteros = new Vesteros();
        vesteros.addHouse(new House("Талли", "Прыгающая серебряная форель среди красно-синих волн"));

        assertNotNull(vesteros.getHouse("Талли"));
    }

    @Test
    void addNullHouse(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().addHouse(null));
    }

    @Test
    void addInvalidHouseName(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().addHouse(new House(null, "Прыгающая серебряная форель среди красно-синих волн")));
    }

    @Test
    void addInvalidHouseSigil(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().addHouse(new House("Талли", null)));
    }

    @Test
    void addHouses(){
        Vesteros vesteros = new Vesteros();
        vesteros.addHouses(getHouses());

        assertNotNull(vesteros.getHouse("Бронны"));
        assertNotNull(vesteros.getHouse("Аррены"));
        assertNotNull(vesteros.getHouse("Баратеоны"));
    }

    @Test
    void addNullHouses(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().addHouses(null));
    }

    @Test
    void addEmptyHouses(){
        Vesteros vesteros = new Vesteros();
        vesteros.addHouses(List.of());

        assertNull(vesteros.getHouse("Бронны"));
    }

    @Test
    void deleteHouse(){
        Vesteros vesteros = new Vesteros();
        vesteros.addHouses(getHouses());
        vesteros.deleteHouse(new House("Бронны", "Пылающая стрела на сером фоне"));
        vesteros.deleteHouse("Аррены");

        assertNull(vesteros.getHouse("Бронны"));
        assertNull(vesteros.getHouse("Аррены"));
    }

    @Test
    void deleteNullHouse(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().deleteHouse((String) null));
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().deleteHouse((House) null));
    }

    @Test
    void deleteInvalidHouseName(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().deleteHouse(new House(null, "Прыгающая серебряная форель среди красно-синих волн")));
    }

    @Test
    void deleteInvalidHouseSigil(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().deleteHouse(new House("Талли", null)));
    }

    @Test
    void getHouse(){
        House house = new House("Старки", "Голова серого лютоволка на бело-зелёном фоне");

        Vesteros vesteros = new Vesteros();
        vesteros.addHouse(house);

        assertEquals(house, vesteros.getHouse("Старки"));
    }

    @Test
    void getHouseNullName(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().getHouse(null));
    }

    @Test
    void getSigil(){
        House house = new House("Старки", "Голова серого лютоволка на бело-зелёном фоне");

        Vesteros vesteros = new Vesteros();
        vesteros.addHouse(house);

        assertEquals("Голова серого лютоволка на бело-зелёном фоне", vesteros.getSigil("Старки"));
    }

    @Test
    void getSigilNullName(){
        assertThrows(IllegalArgumentException.class, () -> new Vesteros().getSigil(null));
    }

    private List<House> getHouses() {
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