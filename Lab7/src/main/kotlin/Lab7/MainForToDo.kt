package Lab4
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    var toDo: ToDo = ctx.getBean(ToDo::class.java)
    toDo.addItem(ToDoItem("Помыть полы", Status.ACTIVE))
    toDo.addItem(ToDoItem("Сходить на пары", Status.ACTIVE))
    toDo.addItem(ToDoItem("Сделать практику", Status.DONE))
    toDo.addItem(ToDoItem("Сходить в качалку", Status.ACTIVE))

    toDo.addTags(Tags("Качалка"))
    toDo.addTags(Tags("Дом"))
    toDo.addTags(Tags("Универ"))
    println("Вывод списка")
    toDo.printToDoConsole()
    //println("Вывод списка после удаления Status.ACTIVE")
    //toDo.deleteActive()
    //toDo.printToDoConsole()
    //println("Вывод списка после удаления Status.DONE")
    //toDo.deleteDone()
    //toDo.printToDoConsole()

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