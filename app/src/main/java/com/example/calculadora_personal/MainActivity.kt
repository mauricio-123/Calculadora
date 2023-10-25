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
  }


  val backspace = findViewById<ImageView>(R.id.backspace)
  backspace.setOnClickListener {
      val string = expressao.text.toString()

      if(string.isNotBlank()){
          expressao.text = string.substring(0,string.length-1)
      }
      text_resultado.text = ""
  }


 /* val  igual =
      findViewById<TextView>(R.id.igual)
  igual.setOnClickListener {
      try {
          val expressao = ExpressionBuilder(expressao.text.toString()).build()
          val resultado = expressao.evaluate()
          val longResult  = resultado.toLong()

          if(resultado == longResult.toDouble()){
              text_resultado.text = longResult.toString()
          }else{
              text_resultado.text = resultado.toString()
          }
      }catch (e: Exception){}
  }*/

}
    @Override
    fun acrescentarUmaExpressao(string:String, limpar_dados:Boolean) {
    val  text_resultado=
        findViewById<TextView>(R.id.text_resultado)
    val  expressao =
        findViewById<TextView>(R.id.expressao)

  if(text_resultado.text.isNotEmpty()){
      expressao.text = ""
  }

  if(limpar_dados){
      text_resultado.text = ""
      expressao.setText(string).toString()
  }else{
      expressao.setText(text_resultado.text).toString()
      expressao.setText(string).toString()
      text_resultado.text = ""
  }
    }
}