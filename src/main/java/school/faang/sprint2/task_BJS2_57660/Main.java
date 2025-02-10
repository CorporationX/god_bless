package school.faang.sprint2.task_BJS2_57660;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image first = new Image("first", "Some");
        Image second = new Image("Second", "SomeOne");

        Image grayscaleImage = filterProcessor.applyFilter(first,
                (image -> new Image(image.name(), image.description() + " | Фильтр: черно-белый")));
        System.out.println(grayscaleImage);

        Function<Image, Image> sepiaFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: сепия");

        Function<Image, Image> grayscaleFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: черно-белый");

        Image sepiaGrayscaleImage = filterProcessor.applyFilter(second,
                filterProcessor.combineFilters(sepiaFilter, grayscaleFilter));
        System.out.println(sepiaGrayscaleImage);
    }
}
