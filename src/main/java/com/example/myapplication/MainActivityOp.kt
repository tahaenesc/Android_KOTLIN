import android.view.View
import android.widget.Button

var operator = "*"
var oldCount=""
var newOperator=true
//operator butonlarımız
fun btn_Operator(view: View) {
    var btn_Select= view as Button
    when(btn_Select.id){
        btn_Div.id->{
            operator="/"
        }
        btn_Mul.id->{
            operator="*"
        }
        btn_Sub.id->{
            operator="-"
        }
        btn_Sum.id->{
            operator="+"
        }
    }
    oldCount=dataView.text.toString()
    newOperator=true
}