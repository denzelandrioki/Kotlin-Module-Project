# Notes Application (Приложение для заметок)

### Описание
Это консольное приложение на Kotlin позволяет:
1. Создавать архивы (наборы заметок).
2. Добавлять заметки в архивы.
3. Просматривать содержимое заметок.
4. Навигировать между меню с возможностью выхода в любой момент.

Приложение использует динамическое меню и модульный подход для обеспечения удобной работы и избегания дублирования кода.

---

### Основные возможности
1. **Создание архивов**:
    - Пользователь может создать архив, указав его имя.
    - Список архивов обновляется в реальном времени.

2. **Добавление заметок в архивы**:
    - В каждом архиве можно создать заметки с уникальным заголовком и содержанием.
    - Невозможно создать заметку с пустым заголовком или содержанием.

3. **Просмотр заметок**:
    - Заметки отображают заголовок и текст при просмотре.

4. **Гибкая навигация**:
    - Пользователь может выйти из любого меню в любое время и вернуться на уровень выше.
    - Программа завершается, если выбрать пункт "Выход" из главного меню.

---

### Установка и запуск
1. Убедитесь, что у вас установлен Kotlin. Если нет, скачайте и установите [Kotlin](https://kotlinlang.org/).
2. Скачайте или клонируйте репозиторий:
   ```bash
   git clone <репозиторий>
3. Перейдите в папку проекта:
    ```bash
   cd Kotlin-Notes-Application
4. Скомпилируйте и запустите проект:
   ```bash
   kotlinc src -include-runtime -d notes-app.jar
   java -jar notes-app.jar

### Структура проекта

- Main.kt — Главная точка входа в приложение.
- MenuManager.kt — Базовый класс для обработки меню и ввода/вывода.
- ArchiveMenu.kt — Класс для работы с архивами.
- Archive.kt — Логика работы с конкретным архивом. 
- Note.kt — Логика работы с заметкам


### Пример работы приложения


 **Главное меню:**

Список архивов:
0. Создать архив
1. Выход
   Введите номер: 0
   Введите имя архива: Мой первый архив
   Архив "Мой первый архив" успешно создан.


 **Меню архива:**

 Архив: Мой первый архив
0. Создать заметку
1. Выход
   Введите номер: 0
   Введите заголовок заметки: Моя первая заметка
   Введите содержание заметки: Это тестовая заметка.
   Заметка "Моя первая заметка" успешно создана.


 **Просмотр заметки:**

Заметка: Моя первая заметка
Содержание:
Это тестовая заметка.
Нажмите Enter, чтобы вернуться.


Особенности реализации

   1. Универсальный класс MenuManager:
        Содержит общую логику для отображения меню и обработки пользовательского ввода.
        Устраняет дублирование кода.

   2. Динамическое меню:
        Все пункты меню (архивы, заметки) генерируются динамически.

   3. Обработка ошибок ввода:
        Программа обрабатывает некорректный ввод (например, текст вместо числа).

   4. Модульный подход:
        Логика разбита на несколько классов, чтобы улучшить читаемость и повторное использование кода.


Критерии выполнения

- Меню с добавлением и просмотром архивов.
- Меню с добавлением и просмотром заметок.
- Исключение повторяющегося кода за счет общего класса.
- Обработка ошибок ввода пользователя.
- Проверка на пустой ввод при создании архивов и заметок.
- Возможность выхода из любого меню.
- Приложение компилируется и выполняется без ошибок.
- Код разделен на отдельные файлы.

Лицензия

Этот проект предоставляется "как есть". Используйте его свободно для обучения и экспериментов.


Авторы

Этот проект был разработан как консольное приложение на Kotlin, демонстрирующее принципы динамического меню, работы с пользовательским вводом и модульного подхода.