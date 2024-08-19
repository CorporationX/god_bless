package faang.school.godbless.dolbahlop;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Part 1: Image Filter Processing
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getFileName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getFileName() + "_sepia", "Фильтр сепия");
        Function<Image, Image> vignetteFilter = image -> new Image(image.getFileName() + "_vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage.getFileName());
        System.out.println(sepiaImage.getFileName());
        System.out.println(vignetteImage.getFileName());
        System.out.println(combinedImage.getFileName());

        // Part 2: Spell Casting
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, spell -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, spell -> "The opponent is disarmed by " + spell);
    }
}
