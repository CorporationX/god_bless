package faang.school.godbless.BJS2_22000;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageFunction, Function<Image, Image> secondImageFunction) {
        return image -> secondImageFunction.apply(imageFunction.apply(image));
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");


        FilterProcessor filterProcessor = new FilterProcessor();


        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", image.getDescription() + " -> Применен фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", image.getDescription() + " -> Применен фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", image.getDescription() + " -> Применен фильтр: виньетка");


        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);


        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);


        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage);

        Function<Image, Image> fullCombinedFilter = filterProcessor.combineFilters(combinedFilter, vignetteFilter);
        Image fullyCombinedImage = filterProcessor.applyFilter(originalImage, fullCombinedFilter);

        System.out.println(fullyCombinedImage);
    }
}
