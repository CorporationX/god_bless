package school.faang.bjs2_87890;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image familyImage = new Image("Семейное фото", "Фото без фильтра");
        System.out.println(familyImage);
        System.out.println(
                filterProcessor.applyFilter(familyImage,image -> {
                    image.setDescription("На фото применен фильтр \"Черно-белый\"");
                    return image;
                })
        );
        System.out.println(
                filterProcessor.applyFilter(familyImage, image -> {
                    image.setDescription("На фото применен фильтр \"Виньетка\"");
                    return image;
                })
        );
        System.out.println(
                filterProcessor.applyFilter(familyImage, image -> {
                    image.setDescription("На фото применен фильтр \"Винтажный\"");
                    return image;
                })
        );
        System.out.println("---------------------------------------------");
        System.out.println(
                filterProcessor.applyFilter(familyImage, filterProcessor.combineFilters(image -> {
                    image.setDescription("На фото применен фильтр \"Черно-белый\"");
                    return image;
                }, image -> {
                    image.setDescription(image.getDescription() + ". На фото применен фильтр \"Виньетка\"");
                    return image;
                }))
        );
    }
}
