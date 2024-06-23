# Gmail Rich Filters
👩‍💻 🧠

## Условия задачи
### Описание: 
Вы являетесь разработчиком приложения **GMail** и работаете над функцией, которая позволяет пользователям настраивать 
фильтры для обработки входящих писем. Вам необходимо создать систему, которая будет применять набор пользовательских 
фильтров к входящим письмам с использованием популярных функциональных интерфейсов `Predicate`, `Consumer`, и `Function`.

### Цель: 
Создайте класс `EmailProcessor`, который будет использовать `Predicate` для фильтрации писем, Consumer для обработки писем 
и `Function` для преобразования писем.

### Требования:

1. Создайте класс `Email` с полями `subject`, `body` и `isImportant`;
2. Создайте класс `EmailProcessor` с методом `processEmails`;
3. Метод `processEmails` должен принимать список входящих писем, `Predicate` для фильтрации, `Consumer` для обработки 
и `Function` для преобразования писем;
4. Создайте несколько лямбда-выражений для `Predicate`, `Consumer`, и `Function`;
5. Протестируйте вашу систему, обрабатывая несколько входящих писем с разными настройками фильтрации и обработки.

### Пример использования:

```java
EmailProcessor emailProcessor = new EmailProcessor();

// Создание списка входящих писем
List<Email> emails = Arrays.asList(
new Email("Письмо 1", "Текст письма 1", false),
new Email("Письмо 2", "Текст письма 2", true),
new Email("Спам", "Текст спама", false)
);

// Создание фильтров, обработчиков и преобразователей
Predicate<Email> importantFilter = email -> email.isImportant();
Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
```

## Почему эта задача полезна?
В примере видно, как удобно можно теперь насоздавать несколько разнообразных действий, которые будут выполнены в рамках одного фильтра пользователя. Поскольку теперь метод принимает не значения, а именно действия (лямбды), то как же их теперь можно комбинировать!
