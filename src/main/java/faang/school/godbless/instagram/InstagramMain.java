package faang.school.godbless.instagram;

import java.util.function.Function;

public class InstagramMain {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Фильтр: ");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", image.getDescription() + "черно-белый; ");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", image.getDescription() + "сепия; ");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", image.getDescription() + "виньетка; ");
        Function<Image, Image> clarendonFilter = (image) -> new Image(image.getName() + "_clarendon", image.getDescription() + "кларендон; ");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        Image clarendonImage = filterProcessor.applyFilter(originalImage, clarendonFilter);
        System.out.println("Название: " + grayscaleImage.getName() + ". " + grayscaleImage.getDescription());
        System.out.println("Название: " + clarendonImage.getName() + ". " + clarendonImage.getDescription());

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("Название: " + combinedImage.getName() + ". " + combinedImage.getDescription());
    }
}
