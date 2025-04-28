## Описание ##
Представьте, что вы являетесь разработчиком системы для MMORPG World of Warcraft. Ваша задача — создать систему, 
которая моделирует выполнение заданий игроками и получение результатов с использованием CompletableFuture в Java. 
Вам нужно реализовать асинхронную модель выполнения квестов, где игроки выполняют задания параллельно, а результаты 
обрабатываются после завершения каждого задания.

## Цель: ##
Создайте класс **QuestSystem**, который использует **CompletableFuture** для асинхронного выполнения заданий и 
возвращает результаты с использованием методов **thenApply**, **thenAccept** и других методов **CompletableFuture**.

## Требования: ##
1. Создайте класс **Player** с полями:<br/>
**name** (имя игрока),<br/>
**level** (уровень игрока),<br/>
**experience** (опыт игрока).

2. Создайте класс Quest с полями:<br/>
**name** (название задания),<br/>
**difficulty** (сложность задания),<br/>
**reward** (награда за выполнение задания).<br/>

3. Создайте класс **QuestSystem** с методом **startQuest**, который:<br/>
Принимает на вход объекты **Player** и **Quest**.<br/>
Возвращает объект **CompletableFuture\<Player\>**.<br/>

4. Метод **startQuest** должен:<br/>
Запускать выполнение квеста асинхронно, используя **CompletableFuture.supplyAsync**.<br/>
Обновлять опыт игрока после выполнения квеста.<br/>
Имитировать выполнение квеста с использованием **Thread.sleep** на количество секунд, равное сложности квеста.

5. Создайте несколько объектов игроков и заданий, затем запустите выполнение квестов для них с использованием **QuestSystem**.

6. Обработайте результаты выполнения квестов, используя методы **CompletableFuture**.
### Пример использования: ###
```
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
player1Quest.thenAccept(player -> 
    System.out.println(player.getName() + " has completed the quest and now has " + 
    player.getExperience() + " experience points."));
player2Quest.thenAccept(player -> 
    System.out.println(player.getName() + " has completed the quest and now has " + 
    player.getExperience() + " experience points."));
```