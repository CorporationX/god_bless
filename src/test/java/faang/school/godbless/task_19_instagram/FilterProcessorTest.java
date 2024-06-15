package faang.school.godbless.task_19_instagram;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    private final FilterProcessor filterProcessor = new FilterProcessor();

    @Test
    public void testApplyFilter() {
        // Arrange
        String nameImage = "original.jpg";
        String descriptionImage = "some description";
        Image originalImage = new Image(nameImage, descriptionImage);

        String filterSuffix = "_filter";
        String filterDiscription = "Filter: nameFilter";
        Function<Image, Image> filter = (image) -> new Image(image.name()+filterSuffix, filterDiscription);

        Image expImage = new Image(nameImage+filterSuffix, filterDiscription);

        // Act
        Image actualImage = filterProcessor.applyFilter(originalImage, filter);

        // Assert
        assertEquals(expImage.name(), actualImage.name(), "имя изображения не совпадает");
        assertEquals(expImage.description(), actualImage.description(), "описание изображения не совпадает");

    }

    @Test
    public void testCombineFilters() {
        // Arrange
        String nameImage = "original.jpg";
        String descriptionImage = "some description";
        Image originalImage = new Image(nameImage, descriptionImage);

        String firstFilterSuffix = "_firstFilter";
        String firstFilterDiscription = "Filter: nameFirstFilter";
        Function<Image, Image> firstFilter = (image) -> new Image(image.name()+firstFilterSuffix, firstFilterDiscription);

        String secondFilterSuffix = "_secondFilter";
        String secondFilterDiscription = "Filter: nameSecondFilter";
        Function<Image, Image> secondFilter = (image) -> new Image(image.name()+secondFilterSuffix, secondFilterDiscription);

        Image expImage = new Image("%s%s%s".formatted(nameImage, firstFilterSuffix, secondFilterSuffix), "%s; %s".formatted(firstFilterDiscription, secondFilterDiscription));

        // Act
        Function<Image, Image> doubleFilter = filterProcessor.combineFilters(firstFilter, secondFilter);
        Image actualImage = filterProcessor.applyFilter(originalImage, doubleFilter);

        // Assert
        assertEquals(expImage.name(), actualImage.name(), "имя изображения не совпадает");
        assertEquals(expImage.description(), actualImage.description(), "описание изображения не совпадает");

    }
}
