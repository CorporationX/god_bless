package faang.school.godbless.lambdas.task_3;

import faang.school.godbless.lambdas.task_3.model.Image;
import faang.school.godbless.lambdas.task_3.util.FilterProcessor;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(grayscaleImage.getName() + " : " + grayscaleImage.getDescription());
        System.out.println(sepiaImage.getName() + " : " + sepiaImage.getDescription());
        System.out.println(vignetteImage.getName() + " : " + vignetteImage.getDescription());
        System.out.println(combinedImage.getName() + " : " + combinedImage.getDescription());
    }
}
