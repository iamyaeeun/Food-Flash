package org.techtown.textrecognitionapp2.org.techtown.textrecognitionapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.textrecognitionapp2.*
import org.techtown.textrecognitionapp2.databinding.ActivityMainBinding
import org.techtown.textrecognitionapp2.databinding.FragmentInformationBinding


class MainActivity : AppCompatActivity() {

    val binding_main by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val binding by lazy { FragmentInformationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding_main.root)

        val data:MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        setMainFragment()
    }
    fun setMainFragment() {
        val mainFragment: MainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.commit()
    }
    fun goBarcode() {
        val barcodeFragment = BarcodeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, barcodeFragment)
        transaction.addToBackStack("barcode")
        transaction.commit()
    }
    fun goExpirationDate() {
        val expirationDateFragment = ExpirationDateFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, expirationDateFragment)
        transaction.addToBackStack("expirationDate")
        transaction.commit()
    }
    fun goMain() {
        //onBackPressed()
        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.addToBackStack("main")
        transaction.commit()
    }

    fun goInformation() {
        //onBackPressed()
        val informationFragment = InformationFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, informationFragment)
        transaction.addToBackStack("Information")
        transaction.commit()
    }

    fun loadData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..100) {
            val title = "비요뜨 ${no}"
            val date = System.currentTimeMillis()
            var memo = Memo(no,title, date)
            data.add(memo)
        }
        return data
    }
}