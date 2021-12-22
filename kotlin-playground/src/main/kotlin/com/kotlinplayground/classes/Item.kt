package com.kotlinplayground.classes

class Item() {
    var name: String = ""
    var price: Double = 0.0
        get() = field
        set(value) {
            if(value >= 0.0){
                field = value
            }else{
                throw IllegalArgumentException("Negative Price is not Allowed!")
            }
        }

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("Iphone")
    println("Item name is ${item.name}")
    item.price = 1.0

}