import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ToDoTest {

    val toDo :  ToDo = ToDo()
    @Test
    fun addItem() {
        var testaddItem = ToDoItem("Сходить в кино", Status.ACTIVE)
        toDo.addItem(testaddItem)
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        assertTrue(toDo.find("Сходить в кино")!! == testaddItem, "sheesh" )

    }

    @Test
    fun deleteItem() {
        toDo.addItem(ToDoItem("Сходить на свидание", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteItem("Сходить на свидание")
        assertTrue(toDo.find("Сходить на свидание") == null, "oh")

    }

    @Test
    fun deleteActive() {
        toDo.addItem(ToDoItem("Сходить на свидание", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteActive()
        assertTrue(toDo.find("Сходить на свидание") == null, "oh")
    }

    @Test
    fun deleteDone() {
        toDo.addItem(ToDoItem("Сходить на свидание", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteDone()
        assertTrue(toDo.find("Почитать книгу") == null, "oh")
    }

    @Test
    fun deleteAll() {
        toDo.addItem(ToDoItem("Сходить на свидание", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteAll()
        assertTrue(toDo.find("Почитать книгу") == null, "oh")
        assertTrue(toDo.find("Сходить на свидание") == null, "oh")

    }

    @Test
    fun find() {
        var testfindItem = ToDoItem("Почитать книгу", Status.DONE)
        toDo.addItem(testfindItem)
        assertTrue(toDo.find("Почитать книгу") !! == testfindItem, "oh")
    }

    @Test
    fun changeItemDescription() {
        var testchangeItem = ToDoItem("Почитать книгу", Status.DONE)
        toDo.addItem(testchangeItem)
        toDo.changeItemDescription("Почитать книгу", "Сходить в магазни", Status.ACTIVE)
        assertTrue(toDo.find("Сходить в магазни",)!!.description.equals("Сходить в магазни"), "WOW")
    }

    @Test
    fun filterStatus() {
    }

    @Test
    fun addTags() {
        var testaddTags = Tags("Дом")
        toDo.addTags(testaddTags)
        assertTrue(toDo.findTags("Дом")!! == testaddTags, "sad")
    }

    @Test
    fun findTags() {
        var testfindTags = Tags("Качалка")
        toDo.addTags(testfindTags)
        assertTrue(toDo.findTags("Качалка") !! == testfindTags, "oh")
    }

    @Test
    fun deleteTags() {
        toDo.addTags(Tags("Качалка"))
        toDo.deleteTags("Качалка")
        assertTrue(toDo.findTags("Качалка") == null, "shesh")
    }
}