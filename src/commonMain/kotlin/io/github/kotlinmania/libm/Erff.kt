// port-lint: source math/erff.rs
package io.github.kotlinmania.libm

import kotlin.math.abs
import kotlin.math.exp

private const val ERX_F: Float = 8.4506291151e-01f
private const val EFX8_F: Float = 1.0270333290e+00f
private const val PP0_F: Float = 1.2837916613e-01f
private const val PP1_F: Float = -3.2504209876e-01f
private const val PP2_F: Float = -2.8481749818e-02f
private const val PP3_F: Float = -5.7702702470e-03f
private const val PP4_F: Float = -2.3763017452e-05f
private const val QQ1_F: Float = 3.9791721106e-01f
private const val QQ2_F: Float = 6.5022252500e-02f
private const val QQ3_F: Float = 5.0813062117e-03f
private const val QQ4_F: Float = 1.3249473704e-04f
private const val QQ5_F: Float = -3.9602282413e-06f

private const val PA0_F: Float = -2.3621185683e-03f
private const val PA1_F: Float = 4.1485610604e-01f
private const val PA2_F: Float = -3.7220788002e-01f
private const val PA3_F: Float = 3.1834661961e-01f
private const val PA4_F: Float = -1.1089469492e-01f
private const val PA5_F: Float = 3.5478305072e-02f
private const val PA6_F: Float = -2.1663755178e-03f
private const val QA1_F: Float = 1.0642088205e-01f
private const val QA2_F: Float = 5.4039794207e-01f
private const val QA3_F: Float = 7.1828655899e-02f
private const val QA4_F: Float = 1.2617121637e-01f
private const val QA5_F: Float = 1.3637083583e-02f
private const val QA6_F: Float = 1.1984500103e-02f

private const val RA0_F: Float = -9.8649440333e-03f
private const val RA1_F: Float = -6.9385856390e-01f
private const val RA2_F: Float = -1.0558626175e+01f
private const val RA3_F: Float = -6.2375331879e+01f
private const val RA4_F: Float = -1.6239666748e+02f
private const val RA5_F: Float = -1.8460508728e+02f
private const val RA6_F: Float = -8.1287437439e+01f
private const val RA7_F: Float = -9.8143291473e+00f
private const val SA1_F: Float = 1.9651271820e+01f
private const val SA2_F: Float = 1.3765776062e+02f
private const val SA3_F: Float = 4.3456588745e+02f
private const val SA4_F: Float = 6.4538726807e+02f
private const val SA5_F: Float = 4.2900814819e+02f
private const val SA6_F: Float = 1.0863500214e+02f
private const val SA7_F: Float = 6.5702495575e+00f
private const val SA8_F: Float = -6.0424413532e-02f

private const val RB0_F: Float = -9.8649431020e-03f
private const val RB1_F: Float = -7.9928326607e-01f
private const val RB2_F: Float = -1.7757955551e+01f
private const val RB3_F: Float = -1.6063638306e+02f
private const val RB4_F: Float = -6.3756646729e+02f
private const val RB5_F: Float = -1.0250950928e+03f
private const val RB6_F: Float = -4.8351919556e+02f
private const val SB1_F: Float = 3.0338060379e+01f
private const val SB2_F: Float = 3.2579251099e+02f
private const val SB3_F: Float = 1.5367296143e+03f
private const val SB4_F: Float = 3.1998581543e+03f
private const val SB5_F: Float = 2.5530502930e+03f
private const val SB6_F: Float = 4.7452853394e+02f
private const val SB7_F: Float = -2.2440952301e+01f

private fun erfc1f(x: Float): Float {
    val s: Float = abs(x) - 1.0f
    val p: Float = PA0_F + s * (PA1_F + s * (PA2_F + s * (PA3_F + s * (PA4_F + s * (PA5_F + s * PA6_F)))))
    val q: Float = 1.0f + s * (QA1_F + s * (QA2_F + s * (QA3_F + s * (QA4_F + s * (QA5_F + s * QA6_F)))))
    return 1.0f - ERX_F - p / q
}

private fun erfc2f(ixIn: UInt, xIn: Float): Float {
    var ix = ixIn
    var x = xIn
    val s: Float
    val r: Float
    val bigS: Float
    val z: Float

    if (ix < 0x3fa00000u) {
        return erfc1f(x)
    }

    x = abs(x)
    s = 1.0f / (x * x)
    if (ix < 0x4036db6du) {
        r = RA0_F + s * (RA1_F + s * (RA2_F + s * (RA3_F + s * (RA4_F + s * (RA5_F + s * (RA6_F + s * RA7_F))))))
        bigS = 1.0f +
            s * (
                SA1_F +
                    s * (SA2_F + s * (SA3_F + s * (SA4_F + s * (SA5_F + s * (SA6_F + s * (SA7_F + s * SA8_F))))))
            )
    } else {
        r = RB0_F + s * (RB1_F + s * (RB2_F + s * (RB3_F + s * (RB4_F + s * (RB5_F + s * RB6_F)))))
        bigS = 1.0f + s * (SB1_F + s * (SB2_F + s * (SB3_F + s * (SB4_F + s * (SB5_F + s * (SB6_F + s * SB7_F))))))
    }
    ix = x.toRawBits().toUInt()
    z = Float.fromBits((ix and 0xffffe000u).toInt())

    return exp(-z * z - 0.5625f) * exp((z - x) * (z + x) + r / bigS) / x
}

/**
 * Error function (f32)
 *
 * Calculates an approximation to the “error function”, which estimates
 * the probability that an observation will fall within x standard
 * deviations of the mean (assuming a normal distribution).
 */
public fun erff(x: Float): Float {
    val r: Float
    val s: Float
    val z: Float
    val y: Float
    var ix: UInt
    val sign: Int

    ix = x.toRawBits().toUInt()
    sign = (ix shr 31).toInt()
    ix = ix and 0x7fffffffu
    if (ix >= 0x7f800000u) {
        return 1.0f - 2.0f * sign.toFloat() + 1.0f / x
    }
    if (ix < 0x3f580000u) {
        if (ix < 0x31800000u) {
            return 0.125f * (8.0f * x + EFX8_F * x)
        }
        z = x * x
        r = PP0_F + z * (PP1_F + z * (PP2_F + z * (PP3_F + z * PP4_F)))
        s = 1.0f + z * (QQ1_F + z * (QQ2_F + z * (QQ3_F + z * (QQ4_F + z * QQ5_F))))
        y = r / s
        return x + x * y
    }
    if (ix < 0x40c00000u) {
        y = 1.0f - erfc2f(ix, x)
    } else {
        val x1p120 = Float.fromBits(0x03800000)
        y = 1.0f - x1p120
    }

    return if (sign != 0) -y else y
}

/**
 * Complementary error function (f32)
 *
 * Calculates the complementary probability.
 * Is `1 - erf(x)`. Is computed directly, so that you can use it to avoid
 * the loss of precision that would result from subtracting
 * large probabilities (on large `x`) from 1.
 */
public fun erfcf(x: Float): Float {
    val r: Float
    val s: Float
    val z: Float
    val y: Float
    var ix: UInt
    val sign: Int

    ix = x.toRawBits().toUInt()
    sign = (ix shr 31).toInt()
    ix = ix and 0x7fffffffu
    if (ix >= 0x7f800000u) {
        return 2.0f * sign.toFloat() + 1.0f / x
    }

    if (ix < 0x3f580000u) {
        if (ix < 0x23800000u) {
            return 1.0f - x
        }
        z = x * x
        r = PP0_F + z * (PP1_F + z * (PP2_F + z * (PP3_F + z * PP4_F)))
        s = 1.0f + z * (QQ1_F + z * (QQ2_F + z * (QQ3_F + z * (QQ4_F + z * QQ5_F))))
        y = r / s
        if (sign != 0 || ix < 0x3e800000u) {
            return 1.0f - (x + x * y)
        }
        return 0.5f - (x - 0.5f + x * y)
    }
    if (ix < 0x41e00000u) {
        return if (sign != 0) {
            2.0f - erfc2f(ix, x)
        } else {
            erfc2f(ix, x)
        }
    }

    val x1p120 = Float.fromBits(0x03800000)
    return if (sign != 0) {
        2.0f - x1p120
    } else {
        x1p120 * x1p120
    }
}
