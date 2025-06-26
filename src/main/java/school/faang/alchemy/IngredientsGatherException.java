package school.faang.alchemy;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
public class IngredientsGatherException extends RuntimeException {
    public IngredientsGatherException(Potion potion, Throwable cause) {
        super("Ошибка сбора ингредиентов для %s".formatted(potion.name()), cause);
    }
}
