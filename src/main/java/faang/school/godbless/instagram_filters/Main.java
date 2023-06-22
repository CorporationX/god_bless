package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        
        Image image = new Image("cap.jpg", "Оригинальное изображение");

        Function<Image, Image> combinetFilter = filterProcessor.combineFilters(filterProcessor.grayScaleFilter, filterProcessor.sepiaFilter);
        Image combinetImage = filterProcessor.applyFilter(image, combinetFilter);

        Image image1 = filterProcessor.applyFilter(combinetImage, filterProcessor.combineFilters(filterProcessor.vignetteFilter, filterProcessor.sepiaFilter));

        System.out.println(image1.getName());
    }
}
