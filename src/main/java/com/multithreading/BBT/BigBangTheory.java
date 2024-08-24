package com.multithreading.BBT;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Task> taskList = Arrays.asList(new Task("Шелдон ", "подготовка теории"),
                new Task("Леонард ", "моделирование эксперимента"),
                new Task("Говард ", "разработка инструментов"),
                new Task("Раджеш ", "анализ данных"));

        for (Task task : taskList){
            service.execute(new Task(task.getName(), task.getTask()));
        }
        service.shutdown();
    }
}
