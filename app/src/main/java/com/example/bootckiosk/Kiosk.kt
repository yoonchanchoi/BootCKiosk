package com.example.bootckiosk

import java.lang.NumberFormatException

fun main(){
    Kiosk().run()
}

class Kiosk {

    val menu = arrayListOf(
            ShakeshackMenu(1,"Burgers", "쉐이크쉑의 시그니처 비프 패티와 쫄깃한 식감의 토종효모 포테이토 번, 토마토, 양상추에 쉑소스를 올려 만든 심플하면서도 맛있는 쉑버거와 그 외 다양한 버거 메뉴가 있습니다." , "ShackMenu"),
            ShakeshackMenu(2,"Drinks", "매장에서 직접 만드는 상큼한 레몬에이드, 달지 않고 향긋한 아이스티, 레몬에이드와 아이스티를 반반 섞은 쉐이크쉑의 시그니처 음료 피프티/피프티도 잊지 마세요.", "ShackMenu" ),
            ShakeshackMenu(3,"ForzenCustards", "매장에서 매일 신선하게 제조하는 쫀득하고 진한 커스터드를 드셔보세요. 입안 가득 퍼지는 부드럽고 달콤한 맛이 당신의 하루를 더욱 완벽하게 만들 것입니다." , "ShackMenu"),
            ShakeshackMenu(4,"Chickens", "신선한 치킨 통살을 버터밀크에 수비드 하여 주문과 동시에 바삭하게 튀겼습니다.", "ShackMenu"),
            )

    fun run() {
        while (true) {
            val all = initData()
            println("[ SHAKESHACK MENU ]")
            menu.forEach {
                it.display()
            }
            println("0. 종료 | 프로그램 종료")
            val input = readln()
            when (input) {
                "0" -> {
                    println("프로그램을 종료합니다.")
                    return
                }

                "1" -> {
                    val title = "[ Burgers MENU ]"
                    val categorys =
                        all.filter { it.category == "Burger" } as ArrayList<ShakeshackMenu>
                    categoryMenu(title, categorys)
                    categorys.clear()

                }

                "2" -> {
                    val title = "[ Drinks MENU ]"
                    val categorys =
                        all.filter { it.category == "Drink" } as ArrayList<ShakeshackMenu>
                    categoryMenu(title, categorys)
                    categorys.clear()
                }

                "3" -> {
                    val title = "[ ForzenCustards MENU ]"
                    val categorys =
                        all.filter { it.category == "ForzenCustard" } as ArrayList<ShakeshackMenu>
                    categoryMenu(title, categorys)
                    categorys.clear()
                }

                "4" -> {
                    val title = "[ Chickens MENU ]"
                    val categorys =
                        all.filter { it.category == "Chicken" } as ArrayList<ShakeshackMenu>
                    categoryMenu(title, categorys)
                    categorys.clear()
                }

                else -> {
                    println("다시 입력해주세용")
                    println()
                }

            }
        }
    }

    fun categoryMenu(title: String, categoryMenus: ArrayList<ShakeshackMenu>) {

        var input = ""
        var select = -1
//        var flag =-1
        while (true) {

            println(title)
            for (i in 0 until categoryMenus.size) {
                categoryMenus[i].display()
            }
            println("0. 뒤로가기 | 뒤로가기")
            input = readln()

            try {
                 select = input.toInt()

            }catch (e: NumberFormatException){
                println("다시 입력해주세용")
                println()
                continue
            }
            if (select == 0) {
//                flag = 1
                return
            } else if (0 < select && select <= categoryMenus.size) {
                printSelecMenu(select, categoryMenus)
//                flag = 1
            } else {
                println("다시 입력해주세용")
                println()
                continue
            }
        }
    }

    fun printSelecMenu(select: Int, categoryMenus: ArrayList<ShakeshackMenu>) {

        categoryMenus.forEach {
            if (it.number == select) {
                it.selectDisplay()
                println()
            }
        }
    }




    private fun initData(): ArrayList<ShakeshackMenu>{
        val all = arrayListOf<ShakeshackMenu>()
        val burgers = arrayListOf<ShakeshackMenu>(
            Burger(1,"쉑버거", "비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거", 8400 , "Burger"),
            Burger(2,"스모크쉑", "애플 우드 칩으로 훈연한 짭짤한 베이컨, 매콤한 체리 페퍼, 비프 패티와 쉑소스가 토핑된 치즈버거",10600, "Burger" ),
            Burger(3,"슈룸 버거", "치즈로 속을 채워 바삭하게 튀겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리안 버거",10000, "Burger"),
            Burger(4,"쉑 스택", "포토벨로 버섯 패티, 비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거",14800,"Burger"),
            Burger(5,"햄버거", "포테이토 번과 비프 패티를 기본으로 신선한 양상추, 토마토, 피클, 양파 토핑을 취향에 따라 선택할 수 있는 버거",6800, "Burger" )
        )
        val drinks = arrayListOf<ShakeshackMenu>(
            Drink(1,"레몬에이드", "매장에서 직접 만드는 상큼한 레몬에이드", 4300, "Drink" ),
            Drink(2,"아이스 티", "직접 유기농 홍차를 우려낸 아이스 티", 3500, "Drink" ),
            Drink(3,"피프티/피프티", "레몬에이드와 유기농 홍차를 우려낸 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료",3800,"Drink" ),
            Drink(4,"탄산음료", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플",2900,"Drink" ),
            Drink(5,"루트 비어", "청량감 있는 독특한 미국식 무알콜 탄산음료",4800,"Drink"),
        )
        val forzenCustards = arrayListOf<ShakeshackMenu>(
            ForzenCustard(1,"쉐이크", "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크(바닐라/초콜릿/스트로베리/블랙 & 화이트/솔티드 카라멜/피넛 버터/커피)",6500,"ForzenCustard"),
            ForzenCustard(2,"플로트", "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료(루트 비어/퍼플 카우/크림시클)",6500,"ForzenCustard"),
            ForzenCustard(3,"컵 & 콘", "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림 (바닐라/초콜릿)",5400,"ForzenCustard"),
        )
        val chickens = arrayListOf<ShakeshackMenu>(
            ForzenCustard(1,"핫 치킨", "바삭하고 두툼한 치킨 통살과 스파이시 슬로, 핫 스파이시 시즈닝이 토핑된 치킨 버거 (닭가슴살/닭다리살 선택 가능)",9500,"Chicken"),
            ForzenCustard(2,"치킨쉑", "바삭하고 두툼한 치킨 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨 버거 (닭가슴살/닭다리살 선택 가능)",8000, "Chicken" ),
            ForzenCustard(3,"치킨 바이트", "한 입에 먹기 좋은 바삭한 치킨 바이트와 허니 머스터드 또는 BBQ 소스를 선택하여 함께 즐기는 메뉴",5900 ,"Chicken"),
        )
        all.addAll(burgers)
        all.addAll(drinks)
        all.addAll(forzenCustards)
        all.addAll(chickens)
        return all
    }

}



