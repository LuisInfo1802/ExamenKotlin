package com.example.examenkotlin

class CuentaBanco {

        var numCuenta=0;
        var nombre="";
        var banco="";
        var saldo=0.0
        var cantidad=0.0;

    constructor(numCuenta: Int, nombre: String, banco: String, saldo: Double, cantidad: Double) {
        this.numCuenta = numCuenta
        this.nombre = nombre
        this.banco = banco
        this.saldo = saldo
        this.cantidad = cantidad
    }


    fun depositar(): Double
    {


        saldo=saldo+cantidad
            return saldo;
    }

    fun retirar(): Boolean{

        var resultado=false;

        if(saldo>=cantidad)
        {
            resultado=true
            saldo=saldo-cantidad;
        }
        return resultado;
    }



}