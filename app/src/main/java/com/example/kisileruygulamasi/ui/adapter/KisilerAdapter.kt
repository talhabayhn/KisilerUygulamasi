package com.example.kisileruygulamasi.ui.adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(
    var mContext:Context,
    var kisilerListesi:List<Kisiler>,
    var viewModel: AnasayfaViewModel

    ): RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>(){

    inner class CardTasarimHolder(var tasarim : CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)   // card tasarımını temsil eden holder class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent , false)
        return CardTasarimHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val kisii = kisilerListesi.get(position)
        val tasarimm = holder.tasarim
        tasarimm.kisiNesnesi= kisii


        tasarimm.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisii)
            Navigation.gecisYap(it,gecis)
        }

        tasarimm.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisii.kisi_ad} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                   viewModel.sil(kisii.kisi_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

}