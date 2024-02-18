package faang.school.godbless.instagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> lithPrint = (image) -> new Image(image.getName() + "_lithPrint", "Фильтр: LithPrint");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        Image lithPrintImage = filterProcessor.applyFilter(originalImage, lithPrint);

        System.out.println("------------- filterProcessor -------------");
        System.out.println(grayscaleImage.getName() + " - " + grayscaleImage.getDescription());
        System.out.println(sepiaImage.getName() + " - " + sepiaImage.getDescription());
        System.out.println(vignetteImage.getName() + " - " + vignetteImage.getDescription());
        System.out.println(lithPrintImage.getName() + " - " + lithPrintImage.getDescription());


// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilters(vignetteFilter, lithPrint);
        Image combinedImage2 = filterProcessor.applyFilter(originalImage, combinedFilter2);

        System.out.println("------------- combinedFilter -------------");
        System.out.println(combinedImage.getName() + " - " + combinedImage.getDescription());
        System.out.println(combinedImage2.getName() + " - " + combinedImage2.getDescription());
    }
}
