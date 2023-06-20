package faang.school.godbless.sprint_3.instagram_filtres;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        Function<Image, Image> function = image -> new Image(image.getName() + "grayscale", "Фильтр: черно-белый");
        Image result = filterProcessor.applyFilter(originalImage, function);

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: серия");

        Function<Image, Image> function1 = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image second = filterProcessor.applyFilter(originalImage, function1);

        Image consumerImage = new Image("original.jpeg", "Оригинальная фотография");

        filterProcessor.showCurrentFilter(consumerImage, consumer -> System.out.println(consumer.getName() + "-----" + consumer.getDescription()));

    }
}