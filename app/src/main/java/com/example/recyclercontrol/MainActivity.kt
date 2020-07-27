package com.example.recyclercontrol

import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recl: RecyclerView?=null
    val adapter2 =showAdater()
    private var edt: EditText? = null
    private var btn: Button? =null
    private var btn2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Sview()
        sRecycler()
        Listeners()
    }




    private fun Sview() {
        edt= findViewById(R.id.edt)
        btn= findViewById(R.id.btn)
        btn2=findViewById(R.id.btn2)
    }

    private fun getDAta(): ArrayList<dataclass>  {
        val list = arrayListOf<dataclass>()
        for (i in 0..200){
            list.add(dataclass(1,"go $i","hello$i"))
        }

        return list
    }

    private fun sRecycler() {
       recl?.adapter=adapter2
        adapter2.update(getDAta())

    }

    private fun Listeners() {
        btn?.setOnClickListener {
            !edt?.text.isNullOrEmpty()
            adapter2.remove(edt?.text.toString().toInt())
        }

        btn2?.setOnClickListener {
            adapter2.add(dataclass(1,"walter","hallo"))
        }
    }


}