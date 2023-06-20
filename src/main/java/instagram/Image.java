package instagram;

public class Image {
    private String nameFile;
    private String fileDescription;

    public Image(String nameFile, String fileDescription) {
        this.nameFile = nameFile;
        this.fileDescription = fileDescription;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }
}
