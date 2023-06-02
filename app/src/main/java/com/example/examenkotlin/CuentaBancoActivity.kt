package com.example.examenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CuentaBancoActivity : AppCompatActivity() {

    private lateinit var lblNombre:TextView
    private lateinit var lblSaldo:TextView
    private lateinit var lblBanco:TextView

    private lateinit var btnDepositar:Button
    private lateinit var btnRetirar:Button
    private lateinit var btnSalir:Button
    private lateinit var txtCantidad: EditText
    private val cuenta=CuentaBanco(0,"","",0.0,0.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuenta_banco)

        iniciarComponentes()
        val nombre=intent.getStringExtra("nombre")
        val banco=intent.getStringExtra("banco")
        val saldo=intent.getStringExtra("saldo")


        lblNombre.setText(nombre)
        lblBanco.setText(banco)
        lblSaldo.setText(saldo)



        btnDepositar.setOnClickListener(View.OnClickListener { btnDepositar() })

        btnRetirar.setOnClickListener(View.OnClickListener { btnRetirar() })

        btnSalir.setOnClickListener(View.OnClickListener { btnSalir() })


    }

    private fun iniciarComponentes()
    {
        lblNombre=findViewById(R.id.lblNombreCliente)
        lblBanco=findViewById(R.id.lblBanco)
        lblSaldo=findViewById(R.id.lblSaldo)

        btnDepositar=findViewById(R.id.btnDeposito)
        btnRetirar=findViewById(R.id.btnRetiro)
        btnSalir=findViewById(R.id.btnSalir)
        txtCantidad=findViewById(R.id.txtCantidad)

    }

    private fun btnDepositar()
    {

        var resultado=0.0;
        if(txtCantidad.text.toString().equals(""))
        {
            Toast.makeText(applicationContext,"No deje campos vacios", Toast.LENGTH_SHORT).show();
        }
        else
        {
            cuenta.saldo=lblSaldo.text.toString().toDouble();
            cuenta.cantidad=txtCantidad.text.toString().toDouble()
            resultado=cuenta.depositar();
            lblSaldo.setText(resultado.toString())
        }

    }


    private fun btnRetirar()
    {

        var resultado=0.0;
        if(txtCantidad.text.toString().equals(""))
        {
            Toast.makeText(applicationContext,"No deje campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            cuenta.saldo=lblSaldo.text.toString().toDouble();
            cuenta.cantidad=txtCantidad.text.toString().toDouble()
            if(cuenta.retirar())
            {
                lblSaldo.setText(cuenta.saldo.toString())
            }
            else{
                Toast.makeText(applicationContext,"No tienes fondos suficientes", Toast.LENGTH_SHORT).show();

            }
        }

    }

    private fun btnSalir() {
        val confirmar = AlertDialog.Builder(this)

        confirmar.setTitle("BANCO")
        confirmar.setMessage("¿Desea Salir?")
        confirmar.setPositiveButton("Confirmar") { dialog, which ->
            finish()
        }
        confirmar.setNegativeButton("Cancelar") { dialog, which ->
            // No hacer nada
        }

        confirmar.show()
    }
}