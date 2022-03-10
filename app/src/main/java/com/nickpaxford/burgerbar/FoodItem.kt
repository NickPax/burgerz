package com.nickpaxford.burgerbar

data class FoodItem (
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image_name: String,
    val category_id: Int,
    val featured: String,
    val active: String
)