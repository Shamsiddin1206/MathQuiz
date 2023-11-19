package shamsiddin.project.mathquiz

import kotlin.random.Random
import kotlin.random.nextInt

class MisolMaker private constructor(
    val a: Int,
    val b: Int,
    val c: Int,
    val sign: String
){
    companion object{
        fun generate(level: String): MisolMaker{
            var variable1: Int = 0
            var variable2: Int = 0
            var answer: Int = 0
            var sign: String = ""

            val symbols = mutableListOf<String>("+", "-", "/", "*")
            sign = symbols.random()

            when(level){
                "easy" -> {
                    variable1 = getNumbers(11)[0]
                    variable2 = getNumbers(11)[1]
                }
                "medium" -> {
                    variable1 = getNumbers(21)[0]
                    variable2 = getNumbers(21)[1]
                }
                "hard" -> {
                    variable1 = getNumbers(51)[0]
                    variable2 = getNumbers(51)[1]
                }
            }

            when(sign){
                "+" -> {
                    answer = variable1+variable2
                }
                "-" -> {
                    answer = variable1-variable2
                }
                "*" -> {
                    answer = variable1*variable2
                }
                "/" -> {
                    answer = variable1/variable2
                }
            }

            return MisolMaker(a = variable1, b = variable2, c = answer, sign = sign)
        }

        fun getNumbers(limit: Int): MutableList<Int>{
            var a = Random.nextInt(1, limit)
            var b = Random.nextInt(1, limit)
            while (a%b!=0){
                a = Random.nextInt(1, limit)
                b = Random.nextInt(1, limit)
            }
            return mutableListOf(a, b)
        }
    }

}