package school.faang.task_44726;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public enum Amenities {
    TV("TV"),
    SHOWER("Shower"),
    KETTLE("Kettle"),
    TOWELS("Towels"),
    DOUBLEBAD("Double bad"),
    KITCHEN("Kitchen"),
    TOILET("Toilet"),
    IRONING("Ironing"),
    HEATING("Heating"),
    OVEN("Oven");

    private static final int NUMBER_OF_AMENITIES = 6;

    private static final Random RANDOM = new Random();

    private String amenity;

    Amenities(String amenity) {
        this.amenity = amenity;
    }

    private String getAmenity() {
        return amenity;
    }

    private static String getRandomAmenity() {
        Amenities[] amenity = Amenities.values();
        return amenity[RANDOM.nextInt(amenity.length)].getAmenity();
    }

    public static Set<String> getSetOfAmenities() {
        Set<String> amenities = new HashSet<>();
        for (int i = 0; i < NUMBER_OF_AMENITIES; i++) {
            amenities.add(getRandomAmenity());
        }
        return amenities;
    }
}