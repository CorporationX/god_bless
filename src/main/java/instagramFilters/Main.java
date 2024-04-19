package instagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> clarendonFilter = (image) -> new Image("clarendon_" + image.getFileName(), image.getDescription() + "; фильтр осветления и повышения интенсивности цветов");
        Function<Image, Image> cremaFilter = (image) -> new Image("crema_" + image.getFileName(), image.getDescription() + "; фильтр добавления насыщенности и высветления центра");

        Image clarendonImage = filterProcessor.applyFilter(originalImage, clarendonFilter);
        Image cremaImage = filterProcessor.applyFilter(originalImage, cremaFilter);

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(clarendonFilter, cremaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combineFilter);

        System.out.println(originalImage.getFileName() + " " + originalImage.getDescription());
        System.out.println(clarendonImage.getFileName() + " " + clarendonImage.getDescription());
        System.out.println(cremaImage.getFileName() + " " + cremaImage.getDescription());
        System.out.println(combinedImage.getFileName() + " " + combinedImage.getDescription());
    }
}
