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
        val detail: String = "",
    ) {
        val permitted: Boolean get() = verdict == Verdict.ALLOW
        val refused: Boolean get() = verdict == Verdict.BLOCK
        val message: String get() = detail
        val messageEnglish: String get() = detail
    }

    class Refused(message: String) : Exception(message)

    fun inspectStill(bitmap: Bitmap): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    fun inspectStill(path: String): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    fun inspectStill(file: File): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    fun inspectClip(path: String): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    fun inspectClip(file: File): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    fun inspectClip(path: String, context: Context? = null): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }

    // Extra overloads that appear in the call sites
    fun inspectStill(bitmap: Bitmap, context: Context? = null): Result {
        return Result(Verdict.ALLOW, score = -1f, detail = "dev-allow")
    }
}