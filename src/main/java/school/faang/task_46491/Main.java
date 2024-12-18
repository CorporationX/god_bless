package school.faang.task_46491;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("Фото", "Простое фото в 4 часа утра");

        Function<Image, Image> blackAndWhiteFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Черно-белый фильтр");
        Function<Image, Image> newYorkFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр New York");

        Image blackAndWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.getDescription());

        Image newYorkImage = filterProcessor.applyFilter(blackAndWhiteImage, newYorkFilter);
        System.out.println(newYorkImage.getDescription());

        Function<Image, Image> allFilter = filterProcessor.combineFilters(blackAndWhiteFilter, newYorkFilter);
        Image allFilterImage = filterProcessor.applyFilter(originalImage, allFilter);
        System.out.println(allFilterImage.getDescription());

    }
}
