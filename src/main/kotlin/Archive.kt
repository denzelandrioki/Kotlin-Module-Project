// Главное меню приложения, работающее с архивами
class ArchiveMenu : MenuManager() {
    private val archives = mutableListOf<Archive>() // Список архивов

    /**
     * Запуск главного меню приложения
     */
    fun start() {
        while (true) {
            // Формируем пункты главного меню
            val menuItems = mutableListOf<Pair<String, () -> Unit>>(
                "Создать архив" to { createArchive() },
                "Выход" to { exitApp() }
            )

            // Добавляем существующие архивы в меню
            archives.forEachIndexed { index, archive ->
                menuItems.add("${archive.name}" to { archiveMenu(archive) })
            }

            // Отображаем главное меню
            displayMenu("Список архивов:", menuItems)
        }
    }

    /**
     * Метод для создания нового архива
     */
    private fun createArchive() {
        // Запрашиваем имя архива
        val name = readNonEmptyInput("Введите имя архива: ")

        // Добавляем новый архив в список
        archives.add(Archive(name))
        println("Архив \"$name\" успешно создан.")
    }

    /**
     * Открытие меню конкретного архива
     * @param archive Архив, с которым работаем
     */
    private fun archiveMenu(archive: Archive) {
        archive.displayMenu()
    }

    /**
     * Завершение работы приложения
     */
    private fun exitApp() {
        println("Выход из программы.")
        System.exit(0)
    }
}

// Класс для представления архива
class Archive(val name: String) : MenuManager() {
    private val notes = mutableListOf<Note>() // Список заметок в архиве

    /**
     * Отображение меню архива
     */
    fun displayMenu() {
        var shouldExit = false // Флаг для выхода из меню
        while (!shouldExit) {
            // Формируем пункты меню архива
            val menuItems = mutableListOf<Pair<String, () -> Unit>>(
                "Создать заметку" to { createNote() },
                "Выход" to { shouldExit = true } // Устанавливаем флаг для выхода
            )

            // Добавляем существующие заметки в меню
            notes.forEachIndexed { index, note ->
                menuItems.add("${note.title}" to { note.display() })
            }

            // Отображаем меню архива
            displayMenu("Архив: $name", menuItems)
        }
    }

    /**
     * Метод для создания новой заметки
     */
    private fun createNote() {
        // Запрашиваем заголовок и содержание заметки
        val title = readNonEmptyInput("Введите заголовок заметки: ")
        val content = readNonEmptyInput("Введите содержание заметки: ")

        // Добавляем заметку в список
        notes.add(Note(title, content))
        println("Заметка \"$title\" успешно создана.")
    }
}