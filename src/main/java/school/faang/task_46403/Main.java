package school.faang.task_46403;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Image, Image> grayFilter = (image) -> {
            image.setDescription("Cерая тема");
            System.out.println("Добавлен фильтр: " + image.getDescription());
            return image;
        };

        Function<Image, Image> retroFilter = (image) -> {
            image.setDescription("Ретро тема");
            System.out.println("Добавлен фильтр: " + image.getDescription());
            return image;
        };

        Image myFoto = new Image("FOTO_001", "original");
        FilterProcessor appFilter = new FilterProcessor();
        appFilter.applyFilter(myFoto, grayFilter);
        appFilter.applyFilter(myFoto, retroFilter);

        Function<Image, Image> combineFilters = appFilter.combineFilters(retroFilter, grayFilter);
        Image mixFilterImage = appFilter.applyFilter(myFoto, combineFilters);
    }
}
