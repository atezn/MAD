fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       // Fill in code 
		if(referrer != null){
            println("name:$name \nage:$age \nhobby:$hobby \nreferrer:${referrer.name} \nreferrer hobby:${referrer.hobby} \n")
        }else{
            println("name:$name \nage:$age \nhobby:$hobby \nreferrer:none\n")
        }
        
    }
}