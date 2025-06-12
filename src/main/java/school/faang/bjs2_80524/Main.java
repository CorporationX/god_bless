package school.faang.bjs2_80524;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image memeImage = new Image("meme", "мемчик про дарк соулс 3: ");

        Function<Image, Image> fireFilter = (image) -> new Image(image.getName(), image.getDescription()
                + "улучшает насыщенность и добавляет огненных эффектов ");
        Function<Image, Image> mageFilter = (image) -> new Image(image.getName(), image.getDescription()
                + "добавляет перья петухов по краям");
        Image fireImage = filterProcessor.applyFilter(memeImage, fireFilter);
        System.out.println(fireImage.getDescription());

        Image mageImage = filterProcessor.applyFilter(memeImage, mageFilter);
        System.out.println(mageImage.getDescription());

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(fireFilter, mageFilter);
        Image combineImage = filterProcessor.applyFilter(memeImage, combineFilter);
        System.out.println(combineImage.getDescription());
    }
}
