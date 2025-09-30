package school.faang.thread_pool;

import lombok.extern.slf4j.Slf4j;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

@Slf4j
public class Main {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать одежду", null, ""};

        WeasleyFamily family = new WeasleyFamily(chores);
        family.performChores();

        log.info("Все домашние дела выполнены!");
    }
}