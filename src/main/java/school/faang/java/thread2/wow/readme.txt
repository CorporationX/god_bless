Создайте класс QuestSystem, который использует CompletableFuture для асинхронного выполнения заданий и возвращает результаты
с использованием методов thenApply, thenAccept и других методов CompletableFuture.

Требования:
1. Создайте класс Player с полями:
name (имя игрока),
level (уровень игрока),
experience (опыт игрока).

2. Создайте класс Quest с полями:
name (название задания),
difficulty (сложность задания),
reward (награда за выполнение задания).

3. Создайте класс QuestSystem с методом startQuest, который:
Принимает на вход объекты Player и Quest.
Возвращает объект CompletableFuture<Player>.

4. Метод startQuest должен:
Запускать выполнение квеста асинхронно, используя CompletableFuture.supplyAsync.
Обновлять опыт игрока после выполнения квеста.
Имитировать выполнение квеста с использованием Thread.sleep на количество секунд, равное сложности квеста.

5. Создайте несколько объектов игроков и заданий, затем запустите выполнение квестов для них с использованием QuestSystem.
6. Обработайте результаты выполнения квестов, используя методы CompletableFuture.

Пример использования:


QuestSystem questSystem = new QuestSystem();

// Создание игроков
Player player1 = new Player("Thrall", 10, 250);
Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

// Запуск заданий
CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));