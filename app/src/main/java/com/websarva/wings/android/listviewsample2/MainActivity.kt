package com.websarva.wings.android.listviewsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        var menuList = mutableListOf("唐揚げ定食","生姜焼き定食","ステーキ定食","野菜炒め定食","とんかつ定食",
            "メンチカツ定食","チキンカツ定食","コロッケ定食","回鍋肉定食","麻婆豆腐定食","青椒肉絲定食",
            "八宝菜定食","酢豚定食","豚の角煮定食","焼き鳥","焼き魚定食","焼肉定食")
        val adapter = ArrayAdapter(this@MainActivity,
            android.R.layout.simple_list_item_1,menuList)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }
   private inner class ListItemClickListener:
           AdapterView.OnItemClickListener{
               override fun onItemClick(parent:AdapterView<*>,view: View,position:Int, id:Long){
                   val dialogFragment = OrderConfirmDialogFragment()
                   dialogFragment.show(supportFragmentManager,"OrderConfirmDialogFragment")
               }
           }
}