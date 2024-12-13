package school.faang.cendaljoe_instagramf_ilters_bjs2_46403;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        function.apply(image);
        String adding = "Добавлен фильтр: ";
        String theme = image.getDescription();
        System.out.println(adding + theme);
        return image;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func, Function<Image, Image> funct) {
        
    }
}
