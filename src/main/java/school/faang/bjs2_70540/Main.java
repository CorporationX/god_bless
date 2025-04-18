package school.faang.bjs2_70540;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image image = new Image("photo", "Оригинальное изображение");
        UnaryOperator<Image> grayscaleFilter = photo ->
                new Image(photo.getName(),
                        String.join(" | ", photo.getDescription(), "Фильтр: черно-белый"));
        UnaryOperator<Image> sepiaFilter = photo ->
                new Image(photo.getName(),
                        String.join(" | ", photo.getDescription(), "Фильтр: сепия"));

        Image filteredImage = filterProcessor.applyFilter(image, grayscaleFilter);
        log.info(String.valueOf(filteredImage));

        Image image2 = new Image("photo 2", "Оригинальное изображение photo 2");
        Image combinedFilteredImage = filterProcessor.combineFilters(image2, sepiaFilter, grayscaleFilter);
        log.info(String.valueOf(combinedFilteredImage));
    }
}
