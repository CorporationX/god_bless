package instagram;

import faang.school.godbless.instagram.FilterProcessor;
import faang.school.godbless.instagram.Image;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
  Image originalImage = new Image("original.jpg", "Оригинальное изображение");
  FilterProcessor filterProcessor = new FilterProcessor();

  @Test
  public void applyFilterTest() {
    Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
    Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
    Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

    Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
    assertEquals("original.jpg_grayscale", grayscaleImage.getName());
    assertEquals("Фильтр: черно-белый", grayscaleImage.getDescription());

    Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
    assertEquals("original.jpg_sepia", sepiaImage.getName());
    assertEquals("Фильтр: сепия", sepiaImage.getDescription());

    Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
    assertEquals("original.jpg_vignette", vignetteImage.getName());
    assertEquals("Фильтр: виньетка", vignetteImage.getDescription());
  }

  @Test
  public void combineFilters() {
    Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
    Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
    Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

    Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    assertEquals("original.jpg_grayscale_sepia", combinedImage.getName());
    assertEquals("Фильтр: сепия", combinedImage.getDescription());
  }
}
