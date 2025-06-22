package school.faang.magicmap.exception;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public class DistanceNotFoundException extends RuntimeException {

    public DistanceNotFoundException(String message) {
        super(message);
    }

    public static DistanceNotFoundException fromCityToAnyMonster(String city) {
        return new DistanceNotFoundException(
                "Минимальное расстояние от %s до какого-либо монстра не найдено".formatted(city));
    }
}
