package faang.school.godbless.instagram.model;

public class Image {
    private String name;
    private int size;
    private String filter;

    public Image(String name, int size, String filter) {
        this.name = name;
        this.size = size;
        this.filter = filter;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (size != image.size) return false;
        if (!name.equals(image.name)) return false;
        return filter.equals(image.filter);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + size;
        result = 31 * result + filter.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", filter='" + filter + '\'' +
                '}';
    }
}
