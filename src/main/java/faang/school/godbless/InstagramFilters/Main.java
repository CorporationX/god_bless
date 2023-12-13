package faang.school.godbless.InstagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Картинка.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> filter1 = (image) -> new Image(image.getName() + " filter1", "Фильтр: черно-белый");
        Function<Image, Image> filter2 = (image) -> new Image(image.getName() + " filter2", "Фильтр: размытие фона");
        Function<Image, Image> filter3 = (image) -> new Image(image.getName() + " filter3", "Фильтр: ретро");

        //Применение фильтров
        Image imageFilter1 = filterProcessor.applyFilter(originalImage, filter1);
        System.out.println(imageFilter1.toString());
        System.out.println(filterProcessor.applyFilter(originalImage, filter2).toString());

        Function<Image, Image> combinFilters = filterProcessor.combineFilters(filter2, filter3);
        Image imageTwoFilters = filterProcessor.applyFilter(originalImage, combinFilters);
        System.out.println(imageTwoFilters.toString());


    }
}
