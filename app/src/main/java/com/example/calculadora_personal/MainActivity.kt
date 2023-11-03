package com.example.calculadora_personal

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val numero_zero = findViewById<TextView>(R.id.numero_zero)
        val numero_um = findViewById<TextView>(R.id.numero_um)
        val numero_dois = findViewById<TextView>(R.id.numero_dois)
        val numero_tres = findViewById<TextView>(R.id.numero_tres)
        val numero_quatro = findViewById<TextView>(R.id.numero_quatro)
        val numero_cinco = findViewById<TextView>(R.id.numero_cinco)
        val numero_seis = findViewById<TextView>(R.id.numero_seis)
        val numero_sete = findViewById<TextView>(R.id.numero_sete)
        val numero_oito = findViewById<TextView>(R.id.numero_oito)
        val numero_nove= findViewById<TextView>(R.id.numero_nove)
        val ponto = findViewById<TextView>(R.id.ponto)

          numero_zero.setOnClickListener { acrescentarUmaExpressao("0",true)}
          numero_um.setOnClickListener{ acrescentarUmaExpressao("1",true) }
          numero_dois.setOnClickListener{ acrescentarUmaExpressao("2",true) }
          numero_tres.setOnClickListener{ acrescentarUmaExpressao("3",true) }
          numero_quatro.setOnClickListener{ acrescentarUmaExpressao("4",true) }
          numero_cinco.setOnClickListener{ acrescentarUmaExpressao("5",true) }
          numero_seis.setOnClickListener{ acrescentarUmaExpressao("6",true) }
          numero_sete.setOnClickListener{ acrescentarUmaExpressao("7",true) }
          numero_oito.setOnClickListener{ acrescentarUmaExpressao("8",true) }
          numero_nove.setOnClickListener{ acrescentarUmaExpressao("9",true) }
          ponto.setOnClickListener { acrescentarUmaExpressao(".",true) }


          //operadores
          val soma = findViewById<TextView>(R.id.soma)
          soma.setOnClickListener { acrescentarUmaExpressao("+",false) }
          val subtracao= findViewById<TextView>(R.id.subtracao)
          subtracao.setOnClickListener { acrescentarUmaExpressao("-",false) }
          val multiplicacao =
              findViewById<TextView>(R.id.multiplicacao)
          multiplicacao.setOnClickListener { acrescentarUmaExpressao("*",false) }
          val divisao = findViewById<TextView>(R.id.divisao)
          divisao.setOnClickListener { acrescentarUmaExpressao("/",false) }

          val limpar = findViewById<TextView>(R.id.limpar)
          val expressao = findViewById<TextView>(R.id.expressao)
          val text_resultado = findViewById<TextView>(R.id.text_resultado)
          limpar.setOnClickListener {
              expressao.text = ""
              text_resultado.text = ""
              LimpiarEstado()
          }


          val backspace = findViewById<ImageView>(R.id.backspace)
          backspace.setOnClickListener {
              val string = expressao.text.toString()
              LimpiarEstado()

              if(string.isNotBlank()){
                  expressao.text = string.substring(0,string.length-1)
              }
              text_resultado.text = ""

          }

        fun operciones (primern: Double,segundoN:Double, signo: String){
            var totalEntero = 0.0

            //Suma
            if(signo == "+"){
            totalEntero =primern + segundoN
                var totalEntero = if ((totalEntero - totalEntero.toInt() == 0.0)) totalEntero.toInt() else totalEntero
            totalMostrar = totalEntero.toString()
            text_resultado.text = totalMostrar
            expressao.text = ""
            text_resultado.setText(totalMostrar).toString()
            LimpiarEstado()
            }

            //Resta
            if(signo == "-"){
                totalEntero =primern - segundoN
                var totalEntero = if ((totalEntero - totalEntero.toInt() == 0.0)) totalEntero.toInt() else totalEntero
                totalMostrar = totalEntero.toString()
                text_resultado.text = totalMostrar
                expressao.text = ""
                text_resultado.setText(totalMostrar).toString()
                LimpiarEstado()
            }

            //Multiplicacion
            if(signo == "*"){
                totalEntero =primern * segundoN
                var totalEntero = if ((totalEntero - totalEntero.toInt() == 0.0)) totalEntero.toInt() else totalEntero
                totalMostrar =totalEntero.toString()
                text_resultado.text = totalMostrar
                expressao.text = ""
                text_resultado.setText(totalMostrar).toString()
                LimpiarEstado()
            }

            //Divicion
            if(signo == "/"){
                totalEntero =primern / segundoN
                var totalEntero = if ((totalEntero - totalEntero.toInt() == 0.0)) totalEntero.toInt() else totalEntero
                totalMostrar =totalEntero.toString()
                text_resultado.text = totalMostrar
                expressao.text = ""
                text_resultado.setText(totalMostrar).toString()
                LimpiarEstado()
            }

        }



        val  igual =
            findViewById<TextView>(R.id.igual)
        igual.setOnClickListener {

            try {
                operciones(PrimerNumero,SegundoNumero,Signo)
            }catch (e: Exception){
                print(e)
            }
        }






    }
    fun espresarvalores(numero: String): Double {var x = numero; return x.toDouble()}
     var  totalMostrar = ""
    private var SegundoNumero = 0.0
    private var PrimerNumero = 0.0
    private var Signo = ""
    private var CambioSigno = false
    fun LimpiarEstado(){
        totalMostrar = ""
        SegundoNumero = 0.0
        PrimerNumero = 0.0
        Signo =""
        CambioSigno = false
    }


            @Override
            fun acrescentarUmaExpressao(NumeroSigno:String, validacioXsignoOnumero:Boolean) {
            val  text_resultado=
                findViewById<TextView>(R.id.text_resultado)
            val  expressao =
                findViewById<TextView>(R.id.expressao)
             if(text_resultado.text.isNotEmpty()){
              expressao.text = ""
            }

            if(validacioXsignoOnumero){
                text_resultado.setText(text_resultado.text.toString()+NumeroSigno).toString()

                if (CambioSigno )
                    SegundoNumero = espresarvalores(text_resultado.text.toString())
                else{
                    PrimerNumero = espresarvalores(text_resultado.text.toString())
                }
            }else{
                if (PrimerNumero==0.0){
                    PrimerNumero = espresarvalores(text_resultado.text.toString())
                }
                expressao.setText(NumeroSigno).toString()
                text_resultado.setText("")
                CambioSigno = true
                Signo = NumeroSigno
          }
    }
}