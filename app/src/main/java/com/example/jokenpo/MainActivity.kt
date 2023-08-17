package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var btn_historico : Button
    lateinit var btn_papel : ImageButton
    lateinit var btn_pedra : ImageButton
    lateinit var btn_tesoura : ImageButton
    lateinit var imgMaquina : ImageView
    lateinit var resultado : TextView

    // Criando a lista de resultados das jogadas
    val historico = mutableListOf<Jogada>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_papel = findViewById<ImageButton>(R.id.btn_papel)
        btn_pedra = findViewById<ImageButton>(R.id.btn_pedra)
        btn_tesoura = findViewById<ImageButton>(R.id.btn_tesoura)
        resultado = findViewById<TextView>(R.id.resultado);
        btn_historico = findViewById<Button>(R.id.btn_historico)

        btn_papel.setOnClickListener{
            resultado.setText(Jogar(0))
        }

        btn_pedra.setOnClickListener{
            resultado.setText(Jogar(1))
        }

        btn_tesoura.setOnClickListener{
            resultado.setText(Jogar(2))
        }


        btn_historico.setOnClickListener(){
            val intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }
    }

//    Criando uma função para condição do jokenpo
    private fun Jogar(sequencia : Int) : String
    {
        var resultado = ""
        val resMaquina = ResultadoMaquina();

        if( sequencia == resMaquina)
        {
            resultado = "Empatou"

        }else{
            if( resMaquina == 0 && sequencia == 2 || resMaquina == 1 && sequencia == 0 || resMaquina == 2 && sequencia == 1 )
            {
                resultado = "Ganhou"

            }else{
                resultado = "Perdeu"
            }
        }

        // Alimentando a jogada no historico
        Jogada().AdicionarJogada( Jogada(sequencia, resMaquina, resultado) )

        return resultado
    }

    private fun ResultadoMaquina() : Int
    {
        imgMaquina = findViewById<ImageView>(R.id.random_img);
        imgMaquina.visibility = View.VISIBLE

        var numRandom = Random.nextInt(3);

        when(numRandom)
        {
            0 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.papel))
            1 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.pedra))
            2 -> imgMaquina.setImageDrawable(getDrawable(R.drawable.tesoura))
        }

        return numRandom;
    }
}

private fun Any.putParcelableArrayListExtra(s: String, arrayList: ArrayList<Jogada>) {

}
