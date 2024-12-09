package school.faang.task_46274;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр: сепеия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр: виньетка");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getName() + ": " + grayscaleImage.getDescription());
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getName() + ": " + vignetteImage.getDescription());

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combineImage.getName() + ": " + combineImage.getDescription());


    }
}
