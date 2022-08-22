package com.example.fooddeliveryapp


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerItems: AppCompatActivity() {

    
    lateinit var recyclerView: RecyclerView
    lateinit var itemAdapter: ItemAdapter
    lateinit var cartIcon: ImageButton
    var dataList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_list_of_items)

        recyclerView=findViewById(R.id.rvFoodItems)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        itemAdapter= ItemAdapter(applicationContext)
        recyclerView.adapter= itemAdapter

        dataList.add(Data("Masala Dosa", "Veg",R.mipmap.masla_dosa))
        dataList.add(Data("Plain Dosa", "Veg",R.mipmap.plain_dosa))
        dataList.add(Data("Phulka Roti", "Veg",R.mipmap.phulka_roti))
        dataList.add(Data("Tandoori Roti", "Veg",R.mipmap.tandoori_roti))
        dataList.add(Data("Tandoori Chicken", "N-Veg",R.mipmap.tandoori_chicken))
        dataList.add(Data("Chicken Biryani", "N-Veg", R.mipmap.chicken_biryani ))
        dataList.add(Data("Mutton Biryani", "N-Veg",R.mipmap.mutton_biryani))

        itemAdapter.setDataList(dataList)

        cartIcon= findViewById(R.id.cart_icon)

        cartIcon.setOnClickListener {
            val intent: Intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }
        fun addProductToCart(product: Data){
            singletonCart.addProduct(product)
            Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show()
        }

    }
}
