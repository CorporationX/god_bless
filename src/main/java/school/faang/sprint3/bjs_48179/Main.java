package school.faang.sprint3.bjs_48179;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> listOfChores = List.of("task number one", "task number two", "task number three");
        WeasleyFamily homeWork = new WeasleyFamily();
        log.info("Start working...");
        homeWork.runTasks(listOfChores);
    }
}
