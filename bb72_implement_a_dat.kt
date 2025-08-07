import java.util.*

data class Option(val name: String, val description: String, val action: () -> Unit)

class CLI {

    private val scanner = Scanner(System.`in`)
    private val options = mutableListOf<Option>()

    fun addOption(name: String, description: String, action: () -> Unit) {
        options.add(Option(name, description, action))
    }

    fun run() {
        while (true) {
            printMenu()
            val choice = scanner.nextInt()
            if (choice in 1..options.size) {
                options[choice - 1].action()
            } else {
                println("Invalid choice. Please try again.")
            }
        }
    }

    private fun printMenu() {
        println("Select an option:")
        for ((index, option) in options.withIndex()) {
            println("${index + 1}. ${option.name} - ${option.description}")
        }
    }
}

fun main() {
    val cli = CLI()
    cli.addOption("Create User", "Create a new user") {
        println("Create User selected")
    }
    cli.addOption("Delete User", "Delete an existing user") {
        println("Delete User selected")
    }
    cli.addOption("List Users", "List all users") {
        println("List Users selected")
    }
    cli.run()
}