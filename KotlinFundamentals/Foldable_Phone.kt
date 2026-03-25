open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}


class Foldable_Phone(var isPhoneFolded: Boolean = true) : Phone() {
    
    override fun switchOn(){
        if(!isPhoneFolded){
            isScreenLightOn = true
        }
    }
    
    fun changeFoldState(){
        isPhoneFolded = !isPhoneFolded
        if(!isPhoneFolded){
            switchOn()
        }else{
            switchOff()
        }
    }
    
}

fun main() {    
    val tempFoldablePhone = Foldable_Phone()
    
    tempFoldablePhone.switchOn()
    tempFoldablePhone.checkPhoneScreenLight()
    tempFoldablePhone.changeFoldState()
    tempFoldablePhone.switchOn()
    tempFoldablePhone.checkPhoneScreenLight()
}