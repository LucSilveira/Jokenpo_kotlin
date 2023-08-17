package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import android.widget.ListView

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        // Recebendo o listView
        val listaHistorico = findViewById<ListView>(R.id.listView)

        val historico = Jogada().ListarJogadas()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historico);
        listaHistorico.adapter = adapter
    }
}