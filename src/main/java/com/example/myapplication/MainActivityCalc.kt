package com.example.myapplication

import android.view.View

class MainActivityCalc {
    fun btn_Click(view: View) {
        // if ile ekranı clear yapıyoruz
        if (newOperator){
            dataView.setText("")
        }
        newOperator=false
        //butonlarımız click yaptıgımızda ekranda islemleri gostermeyi sagliyoruz
        var btnSelect = view as Button
        var btnClickValue:String = dataView.text.toString()
        when(btnSelect.id){
            btn_Zero.id->{
                btnClickValue+="0"
            }
            btn_One.id->{
                btnClickValue+="1"
            }
            btn_Two.id->{
                btnClickValue+="2"
            }
            btn_Three.id->{
                btnClickValue+="3"
            }
            btn_Four.id->{
                btnClickValue+="4"
            }
            btn_Five.id->{
                btnClickValue+="5"
            }
            btn_Six.id->{
                btnClickValue+="6"
            }
            btn_Seven.id->{
                btnClickValue+="7"
            }
            btn_Eight.id->{
                btnClickValue+="8"
            }
            btn_Nine.id->{
                btnClickValue+="9"
            }

            btn_Sub.id->{
                btnClickValue="-"+btnClickValue
            }
        }
        //plain texti gösteriyoruz
        dataView.setText(btnClickValue)
    }
}