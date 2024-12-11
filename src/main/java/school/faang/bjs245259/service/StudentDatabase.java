package school.faang.bjs245259.service;

import lombok.AllArgsConstructor;
import school.faang.bjs245259.model.Student;
import school.faang.bjs245259.model.Subject;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Вы работаете в университете и разрабатываете систему для учёта студентов и их оценок по предметам.
 * Ваша задача — создать программу на Java,
 * которая будет использовать HashMap для хранения и обработки данных о студентах и оценках,
 * предоставляя быстрый доступ к информации о каждом студенте и каждом предмете.
 */
@AllArgsConstructor
public class StudentDatabase {
    private final Map<Student, Map<Subject, List<Integer>>> data = new HashMap<>();

    //Добавление нового студента и его предметов с оценками.
    public void add(Student student, String subject, int ... notes){
        List<Integer> notesList = new ArrayList<>();
        for (int note : notes) {
            if (0 <= note & note <= 5) {
                notesList.add(note);
            }
        }
        Map<Subject, List<Integer>> noteListToSubject = new HashMap<>();
        data.put(student, noteListToSubject);
    }


}
