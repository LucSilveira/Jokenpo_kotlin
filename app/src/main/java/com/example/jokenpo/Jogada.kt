package com.example.jokenpo

class Jogada {
    var jogador : Int = 0
    var maquina : Int = 0
    var resultado : String = ""

    constructor( jogador : Int, maquina : Int, resultado : String){
        this.jogador = jogador
        this.maquina = maquina
        this.resultado = resultado
    }

    constructor()

    companion object {
        private val historico = mutableListOf<Jogada>()
    }

    fun AdicionarJogada(jogada : Jogada){

        historico.add( jogada )
    }

    fun ListarJogadas() : List<Jogada> {

        return historico.toList()
    }

    override fun toString(): String {
        return "sua jogada ${jogador}, maquina : ${maquina} e o resultado ${resultado}"
    }
}