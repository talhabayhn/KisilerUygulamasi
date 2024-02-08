package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel : KisiDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)

        binding.kisiDetayFragment =this
        binding.kisiDetayToolbarBaslik="Kişi Detay"

        val bundle:KisiDetayFragmentArgs by navArgs()  // veriyi alan taraf args alır
        val gelenkisi = bundle.kisi
        binding.kisiNesnesi = gelenkisi
        return  binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm : KisiDetayViewModel by viewModels()
        viewModel = vm
    }

    fun buttonGuncelle(kisi_id:Int,kisi_ad:String, kisi_tel:String){
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

}