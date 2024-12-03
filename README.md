# God Bless

**"God Bless"** — проект первого модуля буткемпа, посвящённый выполнению задач, направленных на изучение работы с Git, написание качественного кода и командную разработку.

---

## 🚀 Как начать работу

### 1. Клонирование репозитория  
Склонируйте проект на ваш компьютер:  
```bash
git clone https://github.com/CorporationX/god_bless.git
```
## Открытие проекта
Откройте проект в IntelliJ IDEA. Используйте встроенные функции IDE или командную строку для работы с Git.

## Создание основной ветки
Создайте ветку с названием ваш_ник_в_дискорде. Она будет основной для всего модуля:
```bash
git checkout -b ваш_ник_в_дискорде
```
Отправьте её на GitHub:
### Отправьте её на GitHub:
```bash
git push -u origin ваш_ник_в_дискорде
```
### Создание ветки для задачи
Для каждой новой задачи создавайте отдельную ветку от основной:
```bash
git checkout -b ваш_ник_в_дискорде-название_задачи
```
#### _Все изменения в рамках задачи вносятся и коммитятся в этой ветке._

## 📝 Как сдавать задачи
### Закоммитьте изменения
Убедитесь, что все изменения добавлены в индекс:
```bash
git add .
git commit -m "Краткое описание задачи"
```
### Запушьте ветку на GitHub
```bash
git push -u origin ваш_ник_в_дискорде-название_задачи
```
### Создайте Pull Request
На GitHub создайте Pull Request (PR) из вашей ветки задачи в вашу основную ветку.
В описании укажите название задачи и любые важные детали.

### Ожидайте ревью
После отправки PR переведите задачу в статус "Review" в Jira.

### Исправьте замечания (если нужно)
Если техлид оставит комментарии, вернитесь в ветку задачи, внесите правки, закоммитьте и запушьте изменения. PR обновится автоматически.

### Завершение задачи
После аппрува техлид сольёт PR в основную ветку. Теперь можно переходить к следующей задаче.

## 📁 Рекомендации по структуре проекта
#### Для каждой задачи создавайте отдельный пакет, связанный с её названием.
#### Организуйте код так, чтобы работа над несколькими задачами не пересекалась.
## 🛠️ Технологии
### Язык: Java
### Сборка: Gradle
### Среда разработки: IntelliJ IDEA
### Система контроля версий: Git и GitHub
# 🤝 Контрибьютинг
#### Если у вас есть предложения по улучшению проекта, создайте новую ветку и откройте Pull Request.




