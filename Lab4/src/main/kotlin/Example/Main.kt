package Example

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    var toDo : ToDo = ctx.getBean(ToDo::class.java)
    toDo.add(ToDoItem("Пойти покушать", Status.ACTIVE))
    toDo.add(ToDoItem("Сходить в качалку", Status.ACTIVE))
    toDo.add(ToDoItem("Сходить на пары", Status.Done))
    toDo.add(ToDoItem("Спать", Status.ACTIVE))

    println(toDo)

}
