package school.faang.task_46403;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Image, Image> grayFilter = (image) -> {
            return new Image(image.getName(), String.format("%s Добавлен фильтр: Серая тема", image.getDescription()));
        };
        Function<Image, Image> retroFilter = (image) -> {
            return new Image(image.getName(), String.format("%s Добавлен фильтр: Ретро тема", image.getDescription()));
        };

        Image myFoto = new Image("FOTO_001", "original");
        FilterProcessor appFilter = new FilterProcessor();

        Image myFotoGray = appFilter.applyFilter(myFoto, grayFilter);
        System.out.println(myFotoGray.getDescription());

        Image myFotoRetro = appFilter.applyFilter(myFoto, retroFilter);
        System.out.println(myFotoRetro.getDescription());

        Function<Image, Image> combineFilters = appFilter.combFilters(retroFilter, grayFilter);
        Image mixFilterImage = appFilter.applyFilter(myFoto, combineFilters);
        System.out.println(mixFilterImage.getDescription());
    }
}
