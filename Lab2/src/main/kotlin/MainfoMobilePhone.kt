fun main() {
    val contactlist : MobilePhone = MobilePhone("Телефоная книга")
    contactlist.addNewContact(Contact("Толик", "+1321312"))
    contactlist.addNewContact(Contact("Маша", "+2132312323"))
    contactlist.addNewContact(Contact("Дмитрий", "+213232112323"))
    println("Вывод списка контактов")
    println(contactlist.contactlist)

    println(contactlist.removeContact(Contact("Толик", "+1321312")))
    println("Список контактов после удаления")
    println(contactlist.contactlist)

    println("Контакт найден " + contactlist.findContact(Contact("Маша", "+2132312323")))
    val con1 = Contact("Дмитрий", "+213232112323")
    val con2 = Contact("Акакий", "+21321981237")
    contactlist.addNewContact(con1)
    println(contactlist.updateContact(con1,con2))
    println(contactlist.contactlist)
    println("Контакт найден по имени " + contactlist.queryContact("Игорь"))

}