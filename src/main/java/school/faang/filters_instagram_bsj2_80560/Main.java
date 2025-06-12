package school.faang.filters_instagram_bsj2_80560;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Image.png", "Изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println("Image " + grayscaleImage.getDescription());

        Function<Image, Image> combinedFilters = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilters);
        System.out.println("Image " + combinedImage.getDescription());


    }
}
