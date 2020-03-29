package machine

import java.util.Scanner



fun main() {
    val scanner = Scanner(System.`in`)
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    fun checkResource(needWater:Int, needMilk: Int, needBeans: Int, needCups:Int, getMoney: Int) {
        when {
            water - needWater < 0 -> {
                println ("Sorry, not enough water!")
            }
            milk - needMilk < 0 -> {
                println ("Sorry, not enough milk")
            }
            beans - needBeans < 0 -> {
                println  ("Sorry, not enough beans")
            }
            cups - needCups < 0 -> {
                println ("Sorry, not enough cups")
            }
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= needWater
                milk -= needMilk
                beans -= needBeans
                money += getMoney
                cups -= needCups
            }
        }
    }
    fun remaining(){
        println("The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$beans of coffee beans\n" +
                "$cups of disposable cups\n" +
                "\$$money of money\n")
    }
    fun buy(){
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (scanner.next()){
            "1" -> {
                checkResource(250, 0, 16,1,4)
            }
            "2" ->{
                checkResource(350, 75, 20,1,7)
            }
            "3" -> {
                checkResource(200, 100, 12,1,6)
            }
            "back" -> {}
            else -> println("Wrong choose")
        }
    }
    fun fill(){
        println("Write how many ml of water do you want to add: ")
        water += scanner.nextInt()
        println("Write how many ml of milk do you want to add: ")
        milk += scanner.nextInt()
        println("Write how many grams of coffee beans do you want to add: ")
        beans += scanner.nextInt()
        println("Write how many disposable cups of coffee do you want to add: ")
        cups += scanner.nextInt()

    }
    fun take(){
        println("I gave you '$'$money")
        money = 0
    }
    do{
        println("Write action (buy, fill, take, remaining, exit): ")
        val action = scanner.next()
        when(action){
            "remaining" -> remaining()
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
        }
    } while(action != "exit")

}
