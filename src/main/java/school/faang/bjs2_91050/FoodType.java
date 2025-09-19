package school.faang.bjs2_91050;

import lombok.Getter;

@Getter
public enum FoodType {
    PIZZA("Пицца"),
    LETTUCE("Капуста"),
    MILK("Молоко"),
    BREAD("Хлеб"),
    SALT("Соль"),
    HAMBURGER("Гамбургер");


    private final String foodTypeFormatted;

    FoodType(String foodTypeFormatted) {
        this.foodTypeFormatted = foodTypeFormatted;
    }
}