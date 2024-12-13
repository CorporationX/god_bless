package school.faang.cendaljoe_instagramf_ilters_bjs2_46403;

public class Main {
    public static void main(String[] args){
        Funtion<Image, Image> grayFilter = (image) -> {
            image.
        }
        Image myFoto = new Image("FOTO_1", "original");
        FilterProcessor appGrayFilter = new FilterProcessor();
        appGrayFilter.applyFilter(myFoto, (foto) -> {
            foto.setDescription("Серая тема");
            return foto;});

        Image herFoto = new Image("FOTO_2", "original");
        FilterProcessor appRetroFilter = new FilterProcessor();
        appRetroFilter.applyFilter(herFoto, (foto) -> {
            foto.setDescription("Ретро тема");
            return foto;});

        FilterProcessor appCombineFilter = new FilterProcessor();
    }
}
