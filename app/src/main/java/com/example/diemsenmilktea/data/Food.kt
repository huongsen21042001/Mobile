package com.example.diemsenmilktea.data

import android.media.Image
import com.example.diemsenmilktea.R

data class Food(val name: String, val img: Int)

public val FoodData = listOf(
    Food("Trà sữa trân châu", R.drawable.trasuatranchau),
    Food("Trà sữa thái xanh", R.drawable.trasuathaixanh),
    Food("Trà xoài", R.drawable.traxoai),
    Food("Trà dâu", R.drawable.tradau),
    Food("Milo dầm", R.drawable.milodam),
    Food("Cookie Milo đá xay", R.drawable.milodaxay)
    )