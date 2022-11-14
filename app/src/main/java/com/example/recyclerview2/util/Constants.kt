package com.example.recyclerview2.util

import com.example.recyclerview2.R
import com.example.recyclerview2.list.AnimalList
import com.example.recyclerview2.model.Animal
import com.example.recyclerview2.model.Grid

object Constants {
    val list = listOf(
        Grid(
            R.drawable.img,
            "Android"
        ),
        Grid(
            R.drawable.img_1,
            "iOS"
        ),
        Grid(
            R.drawable.img_2,
            "Flutter"
        ),
        Grid(
            R.drawable.img_3,
            "React Native"
        ),
        Grid(
            R.drawable.img,
            "Android"
        ),
        Grid(
            R.drawable.img_1,
            "iOS"
        ),
        Grid(
            R.drawable.img_2,
            "Flutter"
        ),
        Grid(
            R.drawable.img_3,
            "React Native"
        ),
    )
    fun animalList(): MutableList<Animal> {
        return mutableListOf(
            Animal(
                "Bobik",
                R.drawable.img_11,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_12,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_13,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_14,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_15,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_11,
                true,
                2,
                "The best dog!"
            ),
            Animal(
                "Bobik",
                R.drawable.img_12,
                true,
                2,
                "The best dog!"
            ),
        )
    }
    fun foodList(): MutableList<AnimalList> {
        return mutableListOf(
            AnimalList(
                R.drawable.img_11,
                "Simba",
                456
            ),
            AnimalList(
                R.drawable.img_12,
                "Simba",
                456
            ),
            AnimalList(
                R.drawable.img_13,
                "Simba",
                456
            ),
            AnimalList(
                R.drawable.img_14,
                "Simba",
                456
            ),
            AnimalList(
                R.drawable.img_15,
                "Simba",
                456
            ),
        )
    }
}