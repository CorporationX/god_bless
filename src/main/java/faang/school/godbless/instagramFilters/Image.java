package faang.school.godbless.instagramFilters;


record Image(String fileName, String description) {

    public String getFileName() {
        return fileName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Image{" +
                "fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
