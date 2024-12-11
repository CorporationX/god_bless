package school.faang.bjs_46327;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;


class FilterProcessorTest {

    public static Stream<Arguments> getFilters() {
        return Stream.of(
                Arguments.of("Оригинальное изображение",
                        (Function<Image, Image>) (image) -> new Image(image.getName(),
                                image.getDescription() + " | Фильтр: черно-белый"),
                        "Оригинальное изображение | Фильтр: черно-белый"
                ),
                Arguments.of("Оригинальное изображение",
                        (Function<Image, Image>) (image) -> new Image(image.getName(),
                                image.getDescription() + " | Фильтр: сепия"),
                        "Оригинальное изображение | Фильтр: сепия"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getFilters")
    void applyFilter(String originalImageDescription, Function<Image, Image> filter, String expectedDescription) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("original.png", originalImageDescription);
        Image filteredImage = filterProcessor.applyFilter(originalImage, filter);
        String actualDescription = filteredImage.getDescription();
        Assertions.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void combineFilters() {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("original.png", "Оригинальное изображение");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image filteredImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        String actualDescription = filteredImage.getDescription();
        String exceptedDescription = "Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия";

        Assertions.assertEquals(exceptedDescription, actualDescription);
    }
}