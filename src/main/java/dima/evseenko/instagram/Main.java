package dima.evseenko.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image image = new Image("Картинка", "Дефолтная картинка");

        FilterProcessor filterProcessor = new FilterProcessor();
        System.out.println(filterProcessor.applyFilter(image, grayscaleFilter));
        System.out.println(filterProcessor.applyFilter(image, sepiaFilter));
        System.out.println(filterProcessor.applyFilter(image, vignetteFilter));

        image = filterProcessor.applyFilter(image, (i) -> new Image(i.getName(), i.getDescription() + " | Фильтр: Сlarendon"));
        System.out.println(image);

        System.out.println(filterProcessor.combineFilters(image, grayscaleFilter, sepiaFilter, vignetteFilter));
    }
}
