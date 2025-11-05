package com.travenor.travellingapp.data.utils

import com.travenor.travellingapp.R
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


    companion object {
        var bottomBarEnabledItems = listOf(
            Home
        )

        fun tryParse(objName: String): Destinations? {

            return when(objName) {
                "Splash" -> Splash
                "Onboarding" -> Onboarding
                "SignIn" -> SignIn
                "SignUp" -> SignUp
                "ForgotPassword" -> ForgotPassword
                "Home" -> Home

                else -> null
            }
        }

        fun isBottomBarShouldBeShown(destinationName: String): Boolean {
            val obj = tryParse(destinationName)
            return bottomBarEnabledItems.contains(obj)
        }
    }
}