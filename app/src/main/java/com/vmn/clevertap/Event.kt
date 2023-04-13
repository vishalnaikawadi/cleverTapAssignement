package com.vmn.clevertap

import com.clevertap.android.sdk.CleverTapAPI
import java.util.*


interface EventListener {
    fun sendUserDetails(instance: CleverTapAPI?)
    fun sendEventProductViewed(instance: CleverTapAPI?)
}

class EventImpl : EventListener {

    override fun sendUserDetails(instance: CleverTapAPI?) {

        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = Constants.NAME // String
        profileUpdate["Identity"] = 61026032 // String or number
        profileUpdate["Email"] = Constants.EMAIL // Email address of the user
        profileUpdate["Phone"] = "+14155551234" // Phone (with the country code, starting with +)
        profileUpdate["Gender"] = "M" // Can be either M or F
        profileUpdate["DOB"] =
            Date() // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate["MSG-email"] = false // Disable email notifications
        profileUpdate["MSG-push"] = true // Enable push notifications
        profileUpdate["MSG-sms"] = false // Disable SMS notifications
        profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications
        val stuff = ArrayList<String>()
        stuff.add("bag")
        stuff.add("shoes")
        profileUpdate["MyStuff"] = stuff //ArrayList of Strings
        val otherStuff = arrayOf("Jeans", "Perfume")
        profileUpdate["MyStuff"] = otherStuff //String Array
        instance?.onUserLogin(profileUpdate)
    }

    override fun sendEventProductViewed(instance: CleverTapAPI?) {
        val prodViewedAction = mapOf(
            "Product ID" to 1,
            "Product Image" to "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg",
            "Product Name" to "CleverTap",
            "Email" to Constants.EMAIL
        )
        instance?.pushEvent("Product viewed", prodViewedAction)
    }

}