package com.example.bootckiosk

open class ShakeshackMenu(val number: Int, val name: String, val explan: String, val category: String) {
    open fun display() {
        println("${number}.$name | $explan")
    }

    open fun selectDisplay(){
        println("")
    }

}