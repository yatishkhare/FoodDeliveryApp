package com.example.fooddeliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cart:AppCompatActivity() {
   lateinit var rvCart: RecyclerView
   lateinit var cartAdapter: ItemAdapter
   //var dataCart = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_activity)
        rvCart = findViewById(R.id.rvCart)
        rvCart.layoutManager= LinearLayoutManager(applicationContext)
        cartAdapter=ItemAdapter(applicationContext)
        rvCart.adapter= cartAdapter

        val productList= singletonCart.products
        cartAdapter.setDataList(productList)
    }


}