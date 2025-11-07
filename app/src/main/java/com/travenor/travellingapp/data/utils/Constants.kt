package com.travenor.travellingapp.data.utils

import android.util.Log
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.models.NavItemData
import com.travenor.travellingapp.data.models.OnboardingItem
import kotlinx.serialization.Serializable

object Constants {
    val onboardingPages = listOf(
        OnboardingItem(
            title = "Life is short and the\nworld is wide",
            description = "At Friends tours and travel, we customize reliable and trutworthy educational tours to destinations all over the world",
            image = R.drawable.onboard_img_1,
            indicator = R.drawable.onboard_ind_1
        ),
        OnboardingItem(
            title = "It’s a big world out\nthere go explore",
            description = "To get the best of your adventure you just need to leave and go where you like. we are waiting for you",
            image = R.drawable.onboard_img_2,
            indicator = R.drawable.onboard_ind_2
        ),
        OnboardingItem(
            title = "People don’t take trips,\ntrips take people",
            description = "To get the best of your adventure you just need to leave and go where you like. we are waiting for you",
            image = R.drawable.onboard_img_3,
            indicator = R.drawable.onboard_ind_3
        )
    )

    val navs = listOf<NavItemData>(
        NavItemData(R.drawable.bottom_nav_home, "Home", Destinations.Home),
        NavItemData(R.drawable.bottom_nav_calendar, "Calendar", Destinations.Home),
        NavItemData(R.drawable.bottom_nav_search, "", Destinations.Home),
        NavItemData(R.drawable.bottom_nav_chat, "Messages", Destinations.Home),
        NavItemData(R.drawable.bottom_nav_profile, "Profile", Destinations.Home),
    )

}

sealed class Destinations {
    @Serializable
    object Splash: Destinations()

    @Serializable
    object Onboarding: Destinations()

    @Serializable
    object SignIn: Destinations()

    @Serializable
    object SignUp: Destinations()

    @Serializable
    object ForgotPassword: Destinations()

    @Serializable
    object Home: Destinations()

    @Serializable
    data class PlaceDetails(val placeId: String) : Destinations()


    companion object {
        var bottomBarEnabledItems = listOf(
            "Home"
        )

        var topBarEnabledItems = listOf(
            "Home"
        )

        fun tryParse(objName: String): Destinations? {
            return when {
                objName.endsWith("Splash") -> Splash
                objName.endsWith("Onboarding") -> Onboarding
                objName.endsWith("SignIn") -> SignIn
                objName.endsWith("SignUp") -> SignUp
                objName.endsWith("ForgotPassword") -> ForgotPassword
                objName.endsWith("Home") -> Home
                else -> null
            }
        }

        fun isBottomBarShouldBeShown(destinationName: String): Boolean {
            val objName = destinationName.substringAfterLast(".")
            return bottomBarEnabledItems.contains(objName)
        }

        fun isTopBarShouldBeShown(destinationName: String): Boolean {
            val objName = destinationName.substringAfterLast(".")
            return topBarEnabledItems.contains(objName)
        }
    }
}