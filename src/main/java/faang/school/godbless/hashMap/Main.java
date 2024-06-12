package faang.school.godbless.hashMap;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Map<String, House> nameSigilMap = new HashMap<>();

        nameSigilMap.put("Stark", new House("Stark", "StarkSigil"));
        nameSigilMap.put("Lanister", new House("Lanister", "LanisterSigil"));
        nameSigilMap.put("Barateon", new House("Barateon", "BarateonSigil"));


        addHouse(nameSigilMap, new House("House", "houseSigil"));
        removeHouse(nameSigilMap, "Barateon");
        System.out.println(getSigilByHouseName(nameSigilMap, "Stark"));
        getInfoAboutAllHouses(nameSigilMap);

    }

    public static void addHouse(Map<String, House> nameSigilMap, @NonNull House house) {
        nameSigilMap.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> nameSigilMap, @NonNull String houseName) {
        if (Objects.isNull(nameSigilMap.remove(houseName))) {
            throw new NoSuchElementException("В мапе не найдено дома с именем " + houseName);
        }
        nameSigilMap.remove(houseName);

    }

    public static String getSigilByHouseName(Map<String, House> nameSigilMap, @NonNull String houseName) {
        if (Objects.isNull(nameSigilMap.get(houseName))) {
            throw new NoSuchElementException("В мапе не найдено дома с именем " + houseName);
        }
        return nameSigilMap.get(houseName).getSigil();
    }

    public static void getInfoAboutAllHouses(Map<String, House> nameSigilMap) {
        for (Map.Entry<String, House> houseEntry : nameSigilMap.entrySet()) {
            System.out.println(houseEntry.getKey()  + houseEntry.getValue());
        }
    }


}
