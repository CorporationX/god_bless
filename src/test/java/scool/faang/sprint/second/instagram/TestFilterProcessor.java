package scool.faang.sprint.second.instagram;

import org.junit.Assert;
import org.junit.Test;
import school.faang.sprint.second.hogwarts.instagram.FilterProcessor;
import school.faang.sprint.second.hogwarts.instagram.Image;

import java.util.function.Function;

public class TestFilterProcessor {
    private final FilterProcessor filterProcessor = new FilterProcessor();
    private final Image originalImage = new Image("original.jpg", "Оригинальное изображение");

    @Test
    public void testApplyFilter() {
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        Assert.assertEquals(originalImage.getName(), grayscaleImage.getName());
        Assert.assertEquals("Оригинальное изображение | Фильтр: черно-белый", grayscaleImage.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenApplyFilter() {
        Image imageForThrow = new Image("", "Оригинальное изображение");
        Function<Image, Image> grayscaleFilter = (image) -> new Image("", "Оригинальное изображение");
        filterProcessor.applyFilter(imageForThrow, grayscaleFilter);
    }

    @Test
    public void testCombineFilters() {
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        Assert.assertEquals(originalImage.getName(), combinedImage.getName());
        Assert.assertEquals(
                "Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия",
                combinedImage.getDescription());
    }
}
