package com.kotlinplayground.classes

object Authenticate {
    fun authenticate(userName : String, password: String){
        println("User Authenticated for userName : $userName")
    }
}

class TokenValidator{

    fun validteToken(token: String){
        println("Token Validated")
    }
}

fun main() {
    Authenticate.authenticate("Dilip", "abc")
}