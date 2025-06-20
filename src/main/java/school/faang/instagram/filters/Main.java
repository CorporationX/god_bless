package school.faang.instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image photo = new Image("photo.jpg", "Мое фото");

        Function<Image, Image> bw = image -> image.withDesc(image.description + " ЧБ");
        Function<Image, Image> sepia = image -> image.withDesc(image.description + " Сепия");
        Function<Image, Image> vig = image -> image.withDesc(image.description + " Виньетка");

        Image witchBw = filterProcessor.apply(photo, bw);
        System.out.println(witchBw.description);

        Function<Image, Image> combo = filterProcessor.combine(sepia, vig);
        Image withCombo = filterProcessor.apply(photo, combo);
        System.out.println(withCombo.description);

    }
}
