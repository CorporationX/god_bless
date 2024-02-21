package faang.school.godbless.spotifyblocking;


import java.util.List;

public class Player {

    private List<Song> songList = List.of(
            new Song("Bohemian Rhapsody", "Queen"),
            new Song("Hey Jude", "The Beatles"),
            new Song("Stairway to Heaven", "Led Zeppelin"),
            new Song("Imagine", "John Lennon"),
            new Song("Hotel California", "Eagles"),
            new Song("Yesterday", "The Beatles"),
            new Song("Smells Like Teen Spirit", "Nirvana"),
            new Song("Wish You Were Here", "Pink Floyd"),
            new Song("Under the Bridge", "Red Hot Chili Peppers"),
            new Song("Thriller", "Michael Jackson"),
            new Song("Let It Be", "The Beatles"),
            new Song("Sweet Child o' Mine", "Guns N' Roses"),
            new Song("Wonderwall", "Oasis"),
            new Song("Bohemian Rhapsody", "Queen"),
            new Song("Billie Jean", "Michael Jackson"),
            new Song("Imagine", "John Lennon"),
            new Song("Like a Rolling Stone", "Bob Dylan"),
            new Song("Comfortably Numb", "Pink Floyd"),
            new Song("Smells Like Teen Spirit", "Nirvana"),
            new Song("Hey Jude", "The Beatles")
    );

    private Song currentSong = songList.get(5);
    private Boolean isPlaying = false;

    public void play() {
        synchronized (isPlaying) {
            synchronized (currentSong) {
                if (!isPlaying) {
                    isPlaying = true;
                    System.out.println("Now you can hear " + currentSong.getAuthor() + " \"" + currentSong.getName() + "\"");
                }
            }
        }
    }

    public synchronized void pause() {
        synchronized (isPlaying) {
            if (!isPlaying) {
                isPlaying = false;
                System.out.println("The song is paused!");
            }
        }
    }

    public synchronized void skip() {
        synchronized (isPlaying) {
            synchronized (currentSong) {
                int indexNow = songList.indexOf(currentSong);
                currentSong = songList.get(indexNow + 1);
                isPlaying = true;
                System.out.println("The next song is " + currentSong.getName());
            }
        }
    }

    public synchronized void previous() {
        synchronized (isPlaying) {
            synchronized (currentSong) {
                int indexNow = songList.indexOf(currentSong);
                currentSong = songList.get(indexNow - 1);
                isPlaying = true;
                System.out.println("The previous song is " + currentSong.getName());
            }
        }
    }

}
