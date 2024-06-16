package instagramfilter;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Image orImage = new Image("Name_1", "Description_1");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");

        System.out.println(filterProcessor.applyFilter(orImage, grayscaleFilter));

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(orImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
