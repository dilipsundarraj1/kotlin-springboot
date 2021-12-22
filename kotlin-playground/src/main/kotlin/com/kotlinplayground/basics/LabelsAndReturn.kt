package com.kotlinplayground.basics

fun main() {

    for(i in 1..5){
        println("i is $i ")
        if(i==3) break
    }

    label()

   /* for (i in 1..10)  {
        if(i==3) return
        println("Value before return : $i")
    }*/

     listOf(1,2,3,4,5).forEach each@{
        //if(it==3) return@forEach // implicit label
         if(it==3) return@each // explicit label
    }

    println("End of program")

}

fun label() {
    loop@ for(i in 1..5){
        println("i in label $i: ")
        innerLoop@ for (j in 1..10){
            if(j==2) break@innerLoop // this is just equivalent to the continue
          //  if(j==2) break@loop
        }
    }
}
