package munoz.guerrero.erick.lista

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment(), SeekBar.OnSeekBarChangeListener {


    var progreso: Int? = null
    var adaptador: ArrayAdapter<String>? = null
    var listView: ListView? = null

    var elementos = arrayOfNulls<String>(11)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val vistaRaiz = inflater.inflate(R.layout.fragment_main, container, false)

        val seek = vistaRaiz.findViewById<SeekBar>(R.id.seekBar) as SeekBar

        progreso = seek.progress //3

        seek.setOnSeekBarChangeListener(this)

        listView = vistaRaiz.findViewById<ListView>(R.id.listView) as ListView


        calculaTablas(progreso!!)

        return vistaRaiz
    }



    fun calculaTablas(progreso : Int){
        for(i in 0..10){
            val texto = "$progreso x $i = ${progreso*i}"
            elementos.set(i,texto)
        }

        adaptador = ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1,
                elementos)
        listView!!.adapter = adaptador

    }



    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        calculaTablas(p1)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

}
