package faang.school.godbless.spotifyblocking;

import java.util.Objects;

public class Song {
    private final String name;
    private final String author;

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) && Objects.equals(author, song.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
