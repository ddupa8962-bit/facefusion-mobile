package com.facefusion.mobile

import android.content.Context
import android.graphics.Bitmap
import java.io.File

/**
 * Dev stub – always allows. Removes the NSFW filter.
 */
object ContentGate {

    const val THRESHOLD = 0.25f
    const val VIDEO_RATE_PERCENT = 10.0
    const val QUANTISED_BIAS = 0.087f

    enum class Verdict { ALLOW, BLOCK, ERROR }

    data class Result(
        val verdict: Verdict,
        val score: Float = 0f,
        val sampled: Int = 0,
        val flagged: Int = 0,
        val detail: String = "dev-allow",
    ) {
        val permitted: Boolean get() = verdict == Verdict.ALLOW
        val refused: Boolean get() = verdict == Verdict.BLOCK

        // Both property and function forms to satisfy all call sites
        val message: String get() = detail
        val messageEnglish: String get() = detail

        fun message(): String = detail
        fun message(context: Context): String = detail
        fun message(what: Int): String = detail
        fun message(context: Context, what: Int): String = detail

        fun messageEnglish(): String = detail
        fun messageEnglish(context: Context): String = detail
    }

    class Refused(message: String) : Exception(message)

    fun inspectStill(bitmap: Bitmap): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(path: String): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(file: File): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(bitmap: Bitmap, context: Context?): Result = Result(Verdict.ALLOW, score = -1f)

    fun inspectClip(path: String): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectClip(file: File): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectClip(path: String, context: Context?): Result = Result(Verdict.ALLOW, score = -1f)
}