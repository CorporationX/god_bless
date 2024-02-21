package faang.school.godbless.spotifyblocking;

public class Song {
    private String name;
    private String author;

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
}
