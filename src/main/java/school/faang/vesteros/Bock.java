package school.faang.vesteros;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

@Slf4j
public class Bock {
    private String title;
    private String author;
    private String year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Map<Bock,String> deleteBock(Map<Bock,String> bocks, String title, String author, String year){
        Bock bockToDelete = new Bock();
        bockToDelete.setTitle(title);
        bockToDelete.setAuthor(author);
        bockToDelete.setYear(year);

        for (Map.Entry<Bock, String> entry : bocks.entrySet()) {
            if (entry.getKey().equals(bockToDelete)) {
                bocks.remove(entry.getKey());
                break;
            }
        }

        return bocks;
    }

    public Map<Bock,String> addBoock(Map<Bock,String> bocks, String title, String author, String year){
        Bock bockToAdd = new Bock();
        bockToAdd.setTitle(title);
        bockToAdd.setAuthor(author);
        bockToAdd.setYear(year);
        bocks.put(bockToAdd, "123");
        return bocks;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bock bock = (Bock) object;
        return Objects.equals(title, bock.title) && Objects.equals(author, bock.author) && Objects.equals(year, bock.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Bock{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
