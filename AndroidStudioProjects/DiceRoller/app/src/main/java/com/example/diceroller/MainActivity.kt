package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

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

    }
}
/*
*骰子蓝图 Class Dice
* 具有滚动的功能 fun roll()
 */
class Dice(val numSides: Int) {
    fun roll(): Int{
        return (1..numSides).random()
    }

}
