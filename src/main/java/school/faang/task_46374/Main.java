package school.faang.task_46374;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Image, Image> blackWhiteFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Function<Image, Image> vignettteFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: виньетка");


        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Image blackWhiteImage = filterProcessor.applyFilter(originalImage, blackWhiteFilter);
        System.out.println(blackWhiteImage);
        Image sepiaImage = filterProcessor.applyFilter(blackWhiteImage, sepiaFilter);
        System.out.println(sepiaImage);
        Image vignetteImage = filterProcessor.applyFilter(sepiaImage, vignettteFilter);
        System.out.println(vignetteImage);

        System.out.println();
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignettteFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage);

    }
}
