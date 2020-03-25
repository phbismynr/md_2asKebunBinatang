package com.ismynr.aplikasikabunbinatang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_binatang_buas.view.*

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Kelinci", "Kelinci Hutan", R.drawable.kelinci, false)
        )
        listBinatang.add(
            Binatang("Kucing", "Kucing Kamputng", R.drawable.kucing, false)
        )
        listBinatang.add(
            Binatang("Monyet", "Monyet Si Pemanjat", R.drawable.monyet, false)
        )
        listBinatang.add(
            Binatang("Ular", "Ular Cobra Dengan Bisa Mematikan", R.drawable.ular, true)
        )
        listBinatang.add(
            Binatang("Sapi", "Sapi Qurban", R.drawable.sapi, false)
        )
        listBinatang.add(
            Binatang("Singa", "Ya Singa Si Raja Hutan", R.drawable.singa, true)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter
    }

    inner class AdapterBinatang: BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context? = null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>): super(){
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binatang = listBinatang[position]
            if(binatang.binatangBuas == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang_buas, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)

                myView.imgGambarBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView

            }else{
                var binatang = listBinatang[position]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)

                myView.imgGambarBinatang.setOnClickListener {
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listBinatang[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }
}
