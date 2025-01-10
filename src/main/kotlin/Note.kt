// Класс для представления заметки
class Note(
    val title: String,
    private val content: String
) : MenuManager() {

    /**
     * Отображение заметки
     */
    fun display() {
        // Печатаем заголовок и содержание заметки
        println("\nЗаметка: $title")
        println("Содержание:\n$content")

        // Ожидаем нажатия Enter для возврата
        println("Нажмите Enter, чтобы вернуться.")
        readLine()
    }
}