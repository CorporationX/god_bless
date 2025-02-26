package Spotify;

public class Player {
    private boolean isPlaying = true;

    public void play() {
        try {
            synchronized (this) {
                if (!isPlaying) {
                    isPlaying = true;
                    System.out.println("Воспроизведение музыки");
                } else {
                    System.out.println("Музыка уже играет");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка в методе: " + e.getMessage());
        }

    }

    public void pause() {
        try {
            synchronized (this) {
                if (isPlaying) {
                    isPlaying = false;
                    System.out.println("Музыка поставлена на паузу");
                } else {
                    System.out.println("Песня на паузе");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка в методе: " + e.getMessage());
        }

    }

    public void skip() {
        try {
            synchronized (this) {
                System.out.println("Песня пропущена");
            }
        } catch (Exception e) {
            System.out.println("Ошибка в методе: " + e.getMessage());
        }

    }

    public void previous() {
        try {
            synchronized (this) {
                System.out.println("Вернули предыдуший трек");
            }
        } catch (Exception e) {
            System.out.println("Ошибка в методе: " + e.getMessage());

        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
