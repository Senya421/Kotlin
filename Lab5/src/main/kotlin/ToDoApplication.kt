import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class ToDoApplication : CommandLineRunner {

    var logger : Logger = LoggerFactory.getLogger(ToDoApplication::class.java)

    override fun run(vararg args: String?){
        logger.info("EXECUTING : command line runner")

        val toDo = ToDo()

        while(true){
            println("Введите команду из списка: addItem,addTag,deleteActive,deleteDone,printToConsole,exit")
            when(readLine()!!.toString()){
                "addItem" -> {
                    println("Введите описание")
                    toDo.addItem(ToDoItem(readLine()!!.toString(),Status.ACTIVE))
                }
                "addTag" -> {
                    println("Введите описание")
                    toDo.addTags(Tags(readLine()!!.toString()))
                }
                "deleteActive" -> {
                    toDo.deleteActive()
                }
                "deleteDONE" -> {
                    toDo.deleteDone()
                }
                "printToConsole" -> {
                    toDo.printToDoConsole()
                }
                "exit" -> {
                    break
                }
                else -> continue
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ToDoApplication>(*args)

}