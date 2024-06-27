package faang.school.godbless.Sprint_3.BJS2_12745;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Играет музыка.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Перейти к следующему треку.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернутся к предыдущему треку.");
        }
    }
}

//Создайте класс Player с методами для управления воспроизведением музыки: play(), pause(), skip() и previous().
//
//Добавьте поле lock в класс Player. Это будет объект-блокировка, который позволит синхронизировать доступ
//к изменению состояния воспроизведения на всех устройствах.
//
//Добавьте переменную isPlaying в класс Player, которая будет отслеживать текущее состояние воспроизведения музыки
//
//Внутри методов наша основная цель — вызвать synchronized (lock) для блокировки доступа к переменной
//isPlaying другим потокам. Остальную логику можете дописать по своему усмотрению. Учтите, что флаг
//isPlaying должен корректно переключаться в соответствующих методах.
//
//В методе main() класса Music cоздаём четыре потока для выполнения каждого метода объекта player:
//playThread, pauseThread, skipThread и previousThread. Для каждого потока используем лямбда-выражения
//для вызова соответствующего метода объекта player. Запускаем все потоки методом start().
