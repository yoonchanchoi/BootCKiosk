package com.example.bootckiosk

class ForzenCustard(number:Int, name: String, explan: String, private val price: Int, category: String) :
    ShakeshackMenu(number, name, explan, category){
    override fun display() {
        println("${number}.$name | $price | $explan")
    }
    override fun selectDisplay(){
        println("${name}의 가격은 ${price}원입니다.")
    }
}