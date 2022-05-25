
class MobilePhone(val phonenumber: String, val contactlist : MutableList<Contact> = mutableListOf<Contact>()){

    fun addNewContact(NewPhoneContact: Contact = Contact("name", "number")){
        contactlist.add(NewPhoneContact)
    }

    fun updateContact(OldUpdatePhoneContact: Contact = Contact("name", "number"),
                      NewPhoneContact : Contact = Contact("name", "number") ): Int {
        var objCount = 0// Номер экземпляра объкета
        var answCode = -1// Если он существует в списке контактов
        for (contacts in contactlist){
            if ((contacts == (OldUpdatePhoneContact)) && (objCount == 0)){
                contacts.name = NewPhoneContact.name
                contacts.number = NewPhoneContact.number
                objCount = 0
                answCode = 1
            }
        }
        return answCode
    }

    fun removeContact(RemovedContact : Contact = Contact("name", "number")) : Int{
        if (contactlist.contains(RemovedContact)){
            println("Контакт успешно удален " + contactlist.remove(RemovedContact))
            return 0 // существует
        }
        else{
            println("Контакт не удален " + contactlist.remove(RemovedContact))
            return -1 // Не существует
        }

    }

    fun findContact(PhoneContact: Contact = Contact("name", "number")): Int {
        if (contactlist.contains(PhoneContact)){
            return contactlist.indexOf(PhoneContact)
        }
        else {
            return -1
        }
    }

    fun queryContact(findquery : String): String {
        var question = "null"
        for (item in contactlist){
            if (findquery == item.name && question == "null" ){
                question = item.toString()
            }
            else{
                return continue

            }
        }
        return question
    }
}

