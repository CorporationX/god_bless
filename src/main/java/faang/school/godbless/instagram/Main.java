package faang.school.godbless.instagram;

import faang.school.godbless.instagram.model.FilterProcessor;
import faang.school.godbless.instagram.model.Image;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("mountains", 12, "none");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", 13, "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", 14, "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", 12, "Фильтр: виньетка");
        Function<Image, Image> larkFilter = (image) -> new Image(image.getName() + "_lark", 15, "Фильтр: Lark");
        Function<Image, Image> moonFilter = (image) -> new Image(image.getName() + "_moon", 15, "Фильтр: Moon");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        Image larkImage = filterProcessor.applyFilter(originalImage, larkFilter);
        Image moonImage = filterProcessor.applyFilter(originalImage, moonFilter);
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> moonLarkFilter = filterProcessor.combineFilters(larkFilter, moonFilter);
    }
}
