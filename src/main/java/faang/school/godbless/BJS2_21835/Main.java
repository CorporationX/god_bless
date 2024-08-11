package faang.school.godbless.BJS2_21835;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image profileImage = new Image("Profile", "Profile pic");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name() + "_vignette", "Фильтр: виньетка");

        FilterProcessor.applyFilter(profileImage, grayscaleFilter);

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        FilterProcessor.applyFilter(profileImage, combinedFilter);
    }
}
