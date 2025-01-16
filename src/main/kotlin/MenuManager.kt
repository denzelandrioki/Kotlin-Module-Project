import java.util.Scanner

// Базовый класс для управления меню
open class MenuManager {
    private val scanner = Scanner(System.`in`)

    /**
     * Метод для отображения меню
     * @param title Заголовок меню
     * @param menuItems Список пунктов меню (пары название -> действие)
     */
    fun displayMenu(title: String, menuItems: List<Pair<String, () -> Unit>>) {
        while (true) {
            // Печатаем заголовок меню
            println("\n$title")

            // Печатаем все пункты меню с их индексами
            menuItems.forEachIndexed { index, item ->
                println("$index. ${item.first}")
            }

            // Запрашиваем выбор пользователя
            print("Введите номер: ")
            val input = scanner.nextLine()
            try {
                val choice = input.toInt()
                if (choice in menuItems.indices) {
                    // Вызываем действие, соответствующее выбранному пункту
                    menuItems[choice].second.invoke()
                    return // Выход из метода после успешного выполнения
                } else {
                    println("Неверный выбор, попробуйте снова")
                }
            } catch (e: NumberFormatException) {
                // Если пользователь ввел не число
                println("Пожалуйста, введите число.")
            }
        }
    }

    /**
     * Метод для запроса ввода от пользователя с проверкой на непустой ввод
     * @param prompt Сообщение перед запросом ввода
     * @return Введенная пользователем строка (непустая)
     */
    fun readNonEmptyInput(prompt: String): String {
        while (true) {
            print(prompt)
            val input = scanner.nextLine()
            if (input.isNotBlank()) return input // Проверяем, что строка не пустая
            println("Поле не может быть пустым. Попробуйте снова")
        }
    }
}