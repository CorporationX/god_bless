package school.faang.bjs2_87794;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image img = new Image("jpg.file12", "Оригинальное фото");

        Function<Image, Image> blackNoirFiler =
                (image) -> new Image(image.getFileName(), image.getDescription() + " | Фильтр: Чёрный Нуар");

        Function<Image, Image> movieFilter =
                (image) -> new Image(image.getFileName(), image.getDescription() + " | Фильтр: Кино");

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilter(blackNoirFiler, movieFilter);
        Image combinedImage = FilterProcessor.applyFilter(img, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}