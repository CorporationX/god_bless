package BlockingSpotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

// Имитация управления воспроизведением музыки
        player.play(); // Начинаем проигрывать музыку
        player.pause(); // Приостанови воспроизведение музыки
        player.play(); // Возобновление воспроизведения музыки
        player.skip(); // Переход к следующему треку
        player.previous(); // Вернуться к предыдущему треку
        player.pause(); // Снова поставить музыку на паузу
    }
}

