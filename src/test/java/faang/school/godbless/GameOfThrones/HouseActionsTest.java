package faang.school.godbless.GameOfThrones;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class HouseActionsTest {

    @Test
    void putHouseTest() {
        House house1 = new House("Таргариен", "герб в виде трехголового красного дракона на черном поле");
        House house2 = new House("Старк", "Серый лютоволк, бегущий по белому полю");
        House house3 = new House("Ланнистер", "«Лев рыкающий», — вставший на задние лапы золотой лев на алом поле. ");

        HashMap<String, House> houses = new HashMap<String, House>();

        Application.putHouse(houses, "Targaryen", house1);
        Application.putHouse(houses, "Lannister", house2);

        assertEquals(2, houses.size());
    }

    @Test
    void deleteHouseTest() {
        House house1 = new House("Таргариен", "герб в виде трехголового красного дракона на черном поле");
        House house2 = new House("Старк", "Серый лютоволк, бегущий по белому полю");
        House house3 = new House("Ланнистер", "«Лев рыкающий», — вставший на задние лапы золотой лев на алом поле. ");

        HashMap<String, House> houses = new HashMap<String, House>();

        Application.putHouse(houses, "Targaryen", house1);
        Application.putHouse(houses, "Stark", house2);
        Application.deleteHouse(houses, "Stark");

        assertEquals(1, houses.size());
    }

    @Test
    void getHouseTest() {
        House house1 = new House("Таргариен", "герб в виде трехголового красного дракона на черном поле");

        HashMap<String, House> houses = new HashMap<String, House>();

        Application.putHouse(houses, "Targaryen", house1);

        Application.getHouse(houses, "Targaryen");
    }

    @Test
    void getHousesListTest() {
        House house1 = new House("Таргариен", "герб в виде трехголового красного дракона на черном поле");
        House house2 = new House("Старк", "Серый лютоволк, бегущий по белому полю");
        House house3 = new House("Ланнистер", "«Лев рыкающий», — вставший на задние лапы золотой лев на алом поле. ");

        HashMap<String, House> houses = new HashMap<String, House>();

        Application.putHouse(houses, "Targaryen", house1);
        Application.putHouse(houses, "Stark", house2);
        Application.putHouse(houses, "Lannister", house3);

        Application.getHousesList(houses);
    }
}