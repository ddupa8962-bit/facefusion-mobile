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
    }

    class Refused(message: String) : Exception(message)

    // ---- inspection ----

    fun inspectStill(bitmap: Bitmap): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(path: String): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(file: File): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectStill(bitmap: Bitmap, context: Context?): Result = Result(Verdict.ALLOW, score = -1f)

    fun inspectClip(path: String): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectClip(file: File): Result = Result(Verdict.ALLOW, score = -1f)
    fun inspectClip(path: String, context: Context?): Result = Result(Verdict.ALLOW, score = -1f)

    // ---- message helpers used by MainActivity and ApiServer ----

    fun message(context: Context, subjectRes: Int, result: Result): String {
        return "Content check disabled (dev build)"
    }

    fun messageEnglish(context: Context, subjectRes: Int, result: Result): String {
        return "Content check disabled (dev build)"
    }
}