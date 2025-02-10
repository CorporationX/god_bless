package school.faang.sprint2.task_BJS2_57660;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image first = new Image("first", "Some");
        Image second = new Image("Second", "SomeOne");

        Image sepiaImage = filterProcessor.applyFilter(first,
                (image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый")));
        System.out.println(sepiaImage);

        Function<Image, Image> sepiaFilter =
                image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Function<Image, Image> grayscaleFilter =
                image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");

        Image sepiaGrayscaleImage = filterProcessor.applyFilter(second,
                filterProcessor.combineFilters(sepiaFilter, grayscaleFilter));
        System.out.println(sepiaGrayscaleImage);
    }
}
