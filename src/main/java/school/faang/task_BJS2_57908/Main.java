package school.faang.task_BJS2_57908;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        //создаем фильтры
        Function<Image, Image> greyFilter = image -> {
            return new Image(image.getName(),
                    image.getDescription() + " | Grey filter applyed.");
        };
        Function<Image, Image> blueFilter = image -> {
            return new Image(image.getName(),
                    image.getDescription() + " | Blue filter applyed.");
        };

        //Применяем фильтры по одному
        Image greyFilteredImage = filterProcessor.applyFilter(originalImage, greyFilter);
        System.out.println(greyFilteredImage.getDescription());
        Image blueFilteredImage = filterProcessor.applyFilter(originalImage, blueFilter);
        System.out.println(blueFilteredImage.getDescription());

        //Комбинация фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(greyFilter, blueFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
