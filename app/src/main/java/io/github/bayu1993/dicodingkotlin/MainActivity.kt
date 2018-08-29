package io.github.bayu1993.dicodingkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import io.github.bayu1993.dicodingkotlin.Adapter.ClubAdapter
import io.github.bayu1993.dicodingkotlin.model.Club

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Club> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recClub = findViewById<RecyclerView>(R.id.recycler_club)
        initData()
        recClub.layoutManager = LinearLayoutManager(this)
        recClub.adapter = ClubAdapter(this, items) {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.clubs)
        val image = resources.getStringArray(R.array.url_clubs)
        items.clear()

        for (i in name.indices) {
            items.add(Club(name[i], image[i]))
        }
        Log.d("test item", "$items")
    }
}
