Description

Представьте, что вам поручено разработать систему для магического турнира в мире Гарри Поттера. В этом турнире соревнуются команды из
разных волшебных школ. Ваша задача — реализовать систему, которая моделирует выполнение заданий командами из разных школ и определяет победителя турнира.
Используйте CompletableFuture в Java для асинхронного выполнения заданий и метода allOf для объединения результатов.
Цель:
Создайте класс Tournament, который использует CompletableFuture для асинхронного запуска заданий команд и объединяет результаты
с помощью метода allOf для определения победителя турнира.

Требования:
1. Создайте класс School, который будет представлять волшебную школу. В нем должны быть следующие поля:
name (название школы),
team (список студентов этой школы),
getTotalPoints (метод для получения общего количества очков, которые набрала команда).

2. Создайте класс Student, который будет представлять студента. Поля этого класса:
name (имя студента),
year (год обучения),
points (количество очков, набранных студентом).

3. Создайте класс Task, представляющий задание. Поля:
name (название задания),
difficulty (сложность задания),
reward (количество очков, которое получит команда за выполнение задания).

4. Реализуйте класс Tournament с методом startTask, который:
Принимает на вход объект School (школа) и Task (задание).
Возвращает CompletableFuture<School>, который обновляет очки студентов школы после выполнения задания.

5. В методе startTask используйте CompletableFuture для асинхронного выполнения задания. Имитируйте
задержку выполнения с помощью Thread.sleep на время, пропорциональное сложности задания.
6. Создайте несколько волшебных школ, студентов и заданий, а затем запустите задания для каждой школы с помощью Tournament.
7. Используйте метод CompletableFuture.allOf для объединения результатов всех CompletableFuture и определения победителя турнира.

Пример использования:


public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        // Обработка результатов всех заданий и определение победителя
    }
}
