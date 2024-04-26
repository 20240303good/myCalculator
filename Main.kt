package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


class Calculator {
    var a:Double = 0.0
    var op:Char = ' '
    var b:Double = 0.0

    init{
        println("계산기가 생성되었습니다.")
    }

    fun add() = println("= ${a+b}")
    fun sub()= println("= ${a-b}")
    fun div(){
        if(b == 0.0) println("error! 0.0으로 나눌 수 없습니다.")
        else println("= ${a/b}")
    }
    fun mul() = println("= ${a*b}")

    fun calculate(input: String){
        if(input == ""){
            println("error! 연산식이 입력되지 않았습니다.")
            return
        }

        for(i in 0 until input.length){
            if(input[i] == '+'|| input[i] == '-'|| input[i] == '/'|| input[i] == '*'){
                a = input.substring(0, i).toDouble()
                op = input[i]
                b = input.substring(i+1).toDouble()
                break;
            }
        }

        when(op){
            ' ' -> println("error! 연산자가 입력되지 않았습니다.")
            '+' -> add()
            '-' -> sub()
            '/' -> div()
            '*' -> mul()
            else -> println("error! 유효한 연산자가 아닙니다.")
        }
    }
}


fun main() {
    val calculator1 = Calculator()

    var input:String = ""
    while(input != "q"){
        println("계산할 수식을 입력하세요. (종료: q)")
        input = readLine() ?: ""
        calculator1.calculate(input)
    }
    println("계산기가 종료되었습니다.")
}