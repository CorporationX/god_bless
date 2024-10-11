package school.faang.BJS2_34854;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("PassPhoto.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(blackAndWhiteFilter, sepiaFilter);

        Image bwImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(bwImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
