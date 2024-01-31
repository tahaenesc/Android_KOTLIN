package com.example.myapplication

import android.view.View
import operator

fun Equals(view: View) {
    var newCount=dataView.text.toString()
    var result:Double?=null
    //when işlemi ile operator butonların işlevlerini sağladık
    when(operator){
        "/"->{
            result=oldCount.toDouble()/newCount.toDouble()
        }
        "*"->{
            result=oldCount.toDouble()*newCount.toDouble()
        }
        "-"->{
            result=oldCount.toDouble()-newCount.toDouble()
        }
        "+"->{
            result=oldCount.toDouble()+newCount.toDouble()
        }
    }
    dataView.setText(result.toString())
    newOperator=true

}
fun Ac(view: View) {
    dataView.setText("0")
    newOperator=true
}
fun Per(view: View) {
    //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
    var count:Double=dataView.text.toString().toDouble()/100
    dataView.setText(count.toString())
    newOperator=true
}