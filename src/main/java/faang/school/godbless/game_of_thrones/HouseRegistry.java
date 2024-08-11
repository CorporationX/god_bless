package faang.school.godbless.game_of_thrones;

import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Getter
public class HouseRegistry {

    private final Map<String, House> storage = new HashMap<>();

    public HouseRegistry(List<House> houses) {
        validate(houses,
                houseList -> (houseList == null || houseList.isEmpty()),
                "List of houses can't be empty/null",
                IllegalArgumentException.class
        );

        houses.forEach(house -> this.storage.put(house.getName(), house));
    }

    public void addNewHouse(House newHouse) {
            validate(newHouse,
                    house -> storage.containsKey(house.getName()),
                    "Registry already contains key " + newHouse.getName(),
                    IllegalArgumentException.class
            );

        storage.put(newHouse.getName(), newHouse);
    }

    public Optional<House> removeHouse(String houseName) {
        validate(houseName,
                name -> (name == null || name.isBlank() || name.isEmpty()),
                "House name can't be null/blank/empty.",
                IllegalArgumentException.class
        );

        if (!storage.containsKey(houseName)) {
            return Optional.empty();
        } else {
            return Optional.of(storage.get(houseName));
        }
    }

    public Optional<String> getSigilInfo(String houseName) {
        validate(houseName,
                name -> (name == null || name.isEmpty() || name.isBlank()),
                "Name of the house can't be empty/blank/null.",
                IllegalArgumentException.class
        );

        if (!storage.containsKey(houseName)) {
            return Optional.empty();
        } else {
            return Optional.of(storage.get(houseName).getSigil());
        }
    }

    public void outputHousesInfo() {
        validate(storage,
                Map::isEmpty,
                "Registry doesn't contain any information at the moment.",
                IllegalStateException.class
        );

        this.storage.forEach((key, value) -> System.out.printf("House: %s, Coat of arms: %s%n", key, value.getSigil()));
    }

    public void removeAllHousesInfo() {
        validate(storage,
                Map::isEmpty,
                "Registry doesn't contain any information at the moment.",
                IllegalStateException.class
        );
        storage.clear();
    }

    private static <T, E extends RuntimeException> void validate(T param, Predicate<T> validator, String message, Class<E> exceptionClass) {
        if (validator.test(param)) {
            try {
                throw exceptionClass.getConstructor(String.class).newInstance(message);
            } catch (NoSuchMethodException e1) {
                System.err.println("No appropriate constructor was found for your exception class.");
                e1.printStackTrace();
            } catch (IllegalAccessException e2) {
                System.err.println("Constructor you are trying to access has inappropriate access modifier.");
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                System.err.println("Couldn't invoke the target method.");
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                System.err.println("Couldn't instantiate your exception class.");
                e4.printStackTrace();
            }
        }
    }
}
