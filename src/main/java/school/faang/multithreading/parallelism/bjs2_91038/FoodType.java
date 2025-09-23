package school.faang.multithreading.parallelism.bjs2_91038;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodType {
    CHICKEN_WINGS("куриных крылышек"),
    CHILI_CHEESE_FRIES("картошка фри с чили и сырным соусом"),
    MOZZARELLA_STICKS("палочки из моцареллы в панировке"),
    ONION_RINGS("луковые кольца"),
    TATER_TOTS("картофельные крокеты"),
    SLIDERS("мини-бургеры"),
    NACHOS("начос"),
    JALAPENO_POPPERS("халапеньо, фаршированные сыром, в панировке");

    private final String value;
}