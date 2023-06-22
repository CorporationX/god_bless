package Filters_Instagram;

public class Image {
    private String nameOfFile;
    private String description;
    public String getNameOfFile(){
        return nameOfFile;
    }
    public String getDescription() {
        return description;
    }
    public Image(String nameOfFile, String description){
        this.nameOfFile = nameOfFile;
        this.description = description;
    }

    @Override
    public String toString() {
        return  nameOfFile + " " +
                description;
    }
}
