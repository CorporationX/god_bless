package school.faang.task46219;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor fp = new FilterProcessor();

        Function<Image, Image> blackWhite = newImage -> new Image(newImage.getName(),
                newImage.getDescription() + " |" + Filter.BLACK_WHITE.getName());

        Function<Image, Image> sepia = newImage -> new Image(newImage.getName(),
                newImage.getDescription() + " |" + Filter.SEPIA.getName());

        Image blackWhiteImage = fp.applyFilter(image, blackWhite);
        System.out.println(blackWhiteImage.getDescription());

        Image sepiaImage = fp.applyFilter(image, sepia);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> twoFilters = fp.combineFilters(blackWhite, sepia);
        Image newImage = fp.applyFilter(image, twoFilters);

        System.out.println(newImage.getDescription());

    }
}
