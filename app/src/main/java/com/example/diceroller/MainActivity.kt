package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var do botão = procura o botão pelo id e joga na variavel
        val rollButton = findViewById<Button>(R.id.button)

        rollButton.setOnClickListener {//setando um listener que dispara quando clicado
            rollDice()  //chama essa função para criar e jogar o dado
        }
        rollDice() //joga um dado assim que o app inicia para mostrar num numero aleatorio
    }

    private fun rollDice() { //função que joga o dado
        val dice = Dice(6) //instancio um dado de 6 lados

        val diceRoll = dice.roll() //chamo uma função da classe Dice para jogar o dado

        val diceImage = findViewById<ImageView>(R.id.imageView) // Encontra uma ImgView no Layout

        val drawableResource = when(diceRoll){ //Determina qual imagem usar baseado na rolagem do dado
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource) //Atualiza a ImgView com o id da imagem correta
        diceImage.contentDescription = diceRoll.toString() //Atualiza a descrição do conteudo



    }
}

class Dice(private val numSides: Int) { //Classe para criar um dado que permite receber a quantidade de lados que este terá
    fun roll(): Int { // função de jogar o dado recebendo o numero de lados deste
        return (1..numSides).random() // retorna um numero randomico entre 1 e quantidade de lados do dado
    }
}