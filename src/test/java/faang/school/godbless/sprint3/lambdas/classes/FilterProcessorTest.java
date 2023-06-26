package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.InstagramsFilters.classes.FilterProcessor;
import faang.school.godbless.sprint3.InstagramsFilters.classes.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    private static FilterProcessor filterProcessor;

    private static Function<Image, Image> grayscaleFilter;

    private static Function<Image, Image> sepiaFilter;

    private static Function<Image, Image> vignetteFilter;

    @BeforeAll
    public static void setUp() {
        filterProcessor = new FilterProcessor();
        grayscaleFilter = image -> new Image(image.getName() + "_grayscale", image.getDescription() + "\nФильтр: черно-белый");
        sepiaFilter = image -> new Image(image.getName() + "_sepia", image.getDescription() + "\nФильтр: сепия");
        vignetteFilter = image -> new Image(image.getName() + "_vignette", image.getDescription() + "\nФильтр: виньетка");
    }

    @ParameterizedTest
    @MethodSource("getSingleFilter")
    @DisplayName("Filters test")
    void applyFilter_correctApplyTest(String expectedName, String expectedDescription, Function<Image, Image> filter, Image image) {
        Image imageWithFilter = filterProcessor.applyFilter(image, filter);
        assertAll(
                () -> assertEquals(expectedName, imageWithFilter.getName()),
                () -> assertEquals(expectedDescription, imageWithFilter.getDescription())
        );
    }

    @ParameterizedTest
    @MethodSource("getCombinedFilters")
    @DisplayName("Test combine filters")
    void combineFilters_test(String expectedName, String expectedDescription, Function<Image, Image> filter, Image image) {
        Image imageWithCombinedFilter = filterProcessor.applyFilter(image, filter);
        assertAll(
                () -> assertEquals(expectedName, imageWithCombinedFilter.getName()),
                () -> assertEquals(expectedDescription, imageWithCombinedFilter.getDescription())
        );
    }

    private static Stream<Arguments> getSingleFilter() {
        return Stream.of(
                Arguments.of(
                        "Photo 1_grayscale",
                        "Я на буткемпе\nФильтр: черно-белый",
                        grayscaleFilter,
                        new Image("Photo 1", "Я на буткемпе")),
                Arguments.of(
                        "Photo 2_sepia",
                        "Я на собеседовании в Amazon\nФильтр: сепия",
                        sepiaFilter,
                        new Image("Photo 2", "Я на собеседовании в Amazon")),
                Arguments.of(
                        "Photo 3_vignette",
                        "Я на встрече с Оксимироном\nФильтр: виньетка",
                        vignetteFilter,
                        new Image("Photo 3", "Я на встрече с Оксимироном"))
        );
    }

    private static Stream<Arguments> getCombinedFilters() {
        return Stream.of(
                Arguments.of(
                        "Photo 1_grayscale_sepia",
                        "Я на буткемпе\nФильтр: черно-белый\nФильтр: сепия",
                        filterProcessor.combineFilters(grayscaleFilter, sepiaFilter),
                        new Image("Photo 1", "Я на буткемпе")),
                Arguments.of(
                        "Photo 2_vignette_grayscale",
                        "Я на собеседовании в Amazon\nФильтр: виньетка\nФильтр: черно-белый",
                        filterProcessor.combineFilters(vignetteFilter, grayscaleFilter),
                        new Image("Photo 2", "Я на собеседовании в Amazon")),
                Arguments.of(
                        "Photo 3_sepia_vignette",
                        "Я на встрече с Оксимироном\nФильтр: сепия\nФильтр: виньетка",
                        filterProcessor.combineFilters(sepiaFilter, vignetteFilter),
                        new Image("Photo 3", "Я на встрече с Оксимироном"))
        );
    }
}