package faang.school.godbless.functional_interface_lambdas.filters_instagram;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение, ");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName() + "_grayscale", image.getDescription() + " Фильтр: черно белый, ");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName() + "_sepia", image.getDescription() + " Фильтр: сепия ");
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage);

        Image vignette = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignette);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);

    }
}


@Data
@AllArgsConstructor
class Image {
    private String name;
    private String description;

}


class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);

    }
}
