package com.travenor.travellingapp.data.models

import com.travenor.travellingapp.data.utils.Destinations

data class NavItemData(
    val icon: Int,
    val title: String,
    val route: Destinations,
)
