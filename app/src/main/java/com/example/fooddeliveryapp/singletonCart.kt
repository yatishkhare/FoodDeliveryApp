package com.example.fooddeliveryapp

object singletonCart {


    var products: ArrayList<Data> = arrayListOf()
        private set

    fun addProduct(product: Data) {
        products.add(product)
    }

}