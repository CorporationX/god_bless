package faang.school.godbless.sprint3.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.get(videoId);
        }
    }
//    Вы являетесь разработчиком YouTube и вам поручено написать класс для управления просмотрами видео. Класс VideoManager имеет следующие методы:
//
//public void addView(String videoId) — добавляет один просмотр для видео с заданным идентификатором (videoId);
//
//public int getViewCount(String videoId) — возвращает количество просмотров для видео с заданным идентификатором (videoId).
//
//Однако, вы заметили, что при большом количестве пользователей, параллельно просматривающих одно и то же видео,
// возможно состояние гонки (race condition) при доступе к методам addView() и getViewCount().
// Это может привести к неправильному подсчету количества просмотров для видео. Нужно это исправить!
//
//Создайте класс VideoManager с приватным полем viewsMap, которое будет использоваться для хранения количества просмотров каждого видео.
//
//Реализуйте метод addView, который будет добавлять просмотр для определенного видео в viewsMap.
//
//Реализуйте метод getViewCount, который будет возвращать количество просмотров для определенного видео.
//
//В методе main создайте объект VideoManager.
//
//Определите NUM_THREADS и NUM_VIDEOS, которые будут использоваться для создания потоков. (Мы хотим запустить одновременно кучу потоков, например, 100).
//
//Создайте ExecutorService с помощью метода Executors.newFixedThreadPool(NUM_THREADS).
//
//В цикле создайте NUM_VIDEOS(вот столько) видео, каждое из которых будет иметь свой уникальный videoId.
//
//В каждом видео-цикле создайте NUM_THREADS / NUM_VIDEOS потоков, каждый из которых будет добавлять просмотр и выводить количество просмотров на консоль.
//
//Вызовите метод shutdown у ExecutorService, чтобы предотвратить добавление новых задач.
//
//Вызовите метод awaitTermination у ExecutorService, чтобы дождаться завершения всех задач.
}
