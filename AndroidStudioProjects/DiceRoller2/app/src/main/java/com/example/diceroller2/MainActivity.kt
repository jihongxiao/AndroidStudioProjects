package com.example.diceroller2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //本案例中使用findViewById找到ui
        /* Android 会自动将ID号码指派给应用程序的资源
        资源ID的形式为R.<type>.<name>
        对于View的ID <type>为id, 例如R.id.button
        *
         */
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //调用Toast.makeText()即可建立内含文字“Dice Roller!"的Toast
            Toast.makeText(this,"Dice Roller!",Toast.LENGTH_LONG).show()
            rollDice()  //执行滚动功能
        }

    }
    private fun rollDice(){
        //建立新的Dice物件执行函数
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val luckyTextView: TextView = findViewById(R.id.textView2)
        val luckyNumber= 6
        if(luckyNumber == diceRoll){
            luckyTextView.text = getString(R.string.LuckyNumber)
        }
        else{
            luckyTextView.text=""
        }

        val diceImage: ImageView = findViewById(R.id.imageView)
/*        if(diceRoll==1){
            diceImage.setImageResource(R.drawable.dice_1)
        }
        else if(diceRoll ==2){
            diceImage.setImageResource(R.drawable.dice_2)
        }*/
        //相同的逻辑只需使用when表达式
        val drawableResource: Int = when(diceRoll){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}
/*
*骰子蓝图 Class Dice
* 具有滚动的功能 fun roll()
 */
class Dice(private val numSides: Int) {
    fun roll(): Int{
        return (1..numSides).random()
    }

}
