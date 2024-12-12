package school.faang.task_47094;


import java.util.List;

public record Job(String position,
                  List<String> requirements,
                  int salary,
                  String location,
                  String datePosted) {
}
