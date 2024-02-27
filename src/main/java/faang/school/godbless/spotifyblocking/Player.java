package faang.school.godbless.spotifyblocking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    ReentrantLock lock = new ReentrantLock(true);


    private List<Song> temp = Arrays.asList(
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
    private List<Song> songList = new ArrayList<>(temp);

    private Song currentSong = songList.get(5);
    private Boolean isPlaying = false;

    public void play() {
        lock.lock();
        try {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Now you can hear " + currentSong.getAuthor() + " \"" + currentSong.getName() + "\"");
            }
        } finally {
            lock.unlock();
        }
    }

    public void pause() {
        lock.lock();
        try {
            if (!isPlaying) {
                isPlaying = false;
                System.out.println("The song is paused!");
            }
        } finally {
            lock.unlock();
        }
    }

    public void skip() {
        lock.lock();
        try {
            int indexNow = songList.indexOf(currentSong);
            if (!(indexNow == songList.size() - 1)) {
                currentSong = songList.get(indexNow + 1);
            } else {
                currentSong = songList.get(0);
            }
            isPlaying = true;
            System.out.println("The next song is " + currentSong.getName());
        } finally {
            lock.unlock();
        }
    }

    public void previous() {
        lock.lock();
        try {
            int indexNow = songList.indexOf(currentSong);
            if (!(indexNow == 0)) {
                currentSong = songList.get(indexNow - 1);
            } else {
                currentSong = songList.get(songList.size() - 1);
            }
            isPlaying = true;
            System.out.println("The previous song is " + currentSong.getName());
        } finally {
            lock.unlock();
        }
    }

    public void playSpecificSong(Song song) {
        lock.lock();
        try {
            if (songList.contains(song)) {
                currentSong = song;
                isPlaying = true;
                System.out.println(song.getName() + " is playing");
            } else {
                addSong(song);
            }
        } finally {
            lock.unlock();
        }
    }

    public void addSong(Song song) {
        lock.lock();
        try {
            System.out.printf("Do you wish to add '%s' to playlist? (y/n)\n", song.getName());
            String answer = new Scanner(System.in).nextLine();
            switch (answer) {
                case "y", "yes" -> {
                    songList.add(song);
                    currentSong = song;
                    System.out.println("This song is added :)");
                }
                case "n", "no" -> System.out.println("ok");
                default -> {
                    System.out.println("Try one more time");
                    addSong(song);
                }
            }
        } finally {
            lock.unlock();
        }
    }

}
