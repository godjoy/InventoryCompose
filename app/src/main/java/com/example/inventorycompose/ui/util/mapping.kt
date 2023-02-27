package com.example.inventorycompose.ui.util

import com.example.inventorycompose.R

fun Int.mapToDrawableId(): Int {
    return when(this) {
        1 -> R.drawable.baseline_local_florist_24
        2 -> R.drawable.baseline_local_florist_24
        3 -> R.drawable.baseline_local_florist_24
        4 -> R.drawable.baseline_local_florist_24
        5 -> R.drawable.baseline_local_florist_24
        6 -> R.drawable.baseline_local_florist_24
        7 -> R.drawable.baseline_local_florist_24
        8 -> R.drawable.baseline_local_florist_24
        9 -> R.drawable.baseline_local_florist_24
        10 -> R.drawable.baseline_local_florist_24
        11 -> R.drawable.baseline_local_florist_24
        12 -> R.drawable.baseline_local_florist_24
        13 -> R.drawable.baseline_local_florist_24
        14 -> R.drawable.baseline_local_florist_24
        15 -> R.drawable.baseline_local_florist_24
        16 -> R.drawable.baseline_local_florist_24
        else -> throw IllegalArgumentException("Illegal TreeId")
    }
}