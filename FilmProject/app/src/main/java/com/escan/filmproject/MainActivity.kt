package com.escan.filmproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter: RvAdapter
    lateinit var filmArrayList: ArrayList<Filmler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1,"django","django","27.99")
        val f2 = Filmler(2,"birzamanlaranadoluda","Bir Zamanlar Anadoluda","27.99")
        val f3 = Filmler(3,"inception","Inception","36.99")
        val f4 = Filmler(4,"interstellar","Interstellar","36.99")
        val f5 = Filmler(5,"thehatefuleight","The Hate Fule Eight","27.99")
        val f6 = Filmler(6,"thepianist","The Pianist","37.99")

        filmArrayList = ArrayList<Filmler>()
        filmArrayList.add(f1)
        filmArrayList.add(f2)
        filmArrayList.add(f3)
        filmArrayList.add(f4)
        filmArrayList.add(f5)
        filmArrayList.add(f6)

        rvAdapter = RvAdapter(filmArrayList,this)
        recyclerView.adapter = rvAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflater xml ile activity mizi bağlıcağımız zaman kullanırız
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //item.itemId = Kullanıcının tıkladığı id
        if (item.itemId == R.id.films){
            val intent = Intent(MainActivity@this,MainActivity::class.java)
            startActivity(intent)
        }
        if (item.itemId == R.id.baskets){
            val intent = Intent(MainActivity@this,Basket::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item) //itemi döndür
    }
}