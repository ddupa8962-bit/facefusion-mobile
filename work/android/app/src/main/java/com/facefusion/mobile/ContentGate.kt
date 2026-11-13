package com.facefusion.mobile

/**
 * Dev stub – content gate always permits.
 * This makes the build a proper -dev build without the NSFW filter.
 */
object ContentGate {

    data class Verdict(
        val permitted: Boolean,
        val score: Float = 0f,
        val detail: String = ""
    )

    class Refused(message: String) : Exception(message)

    fun check(bitmap: android.graphics.Bitmap): Verdict {
        return Verdict(permitted = true)
    }

    fun check(path: String): Verdict {
        return Verdict(permitted = true)
    }

    fun checkFrame(bitmap: android.graphics.Bitmap): Verdict {
        return Verdict(permitted = true)
    }

    fun analyse(bitmap: android.graphics.Bitmap): Verdict {
        return Verdict(permitted = true)
    }

    fun isPermitted(bitmap: android.graphics.Bitmap): Boolean = true

    fun isPermitted(path: String): Boolean = true
}