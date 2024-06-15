package faang.school.godbless;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> brightnessFilter = image -> new Image(image + "_bright", "Фильтр: увеличение яркости");
        Function<Image, Image> blurFilter = image -> new Image(image + "_blur", "Фильтр: размытие");


        Function<Image, Image> brithAndBlurFilter = filterProcessor.combineFilters(brightnessFilter, blurFilter);
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getFilename());
    }
}