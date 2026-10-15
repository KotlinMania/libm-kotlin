// port-lint: source math/erf.rs
package io.github.kotlinmania.libm

import kotlin.math.abs
import kotlin.math.exp

private const val ERX: Double = 8.45062911510467529297e-01
private const val EFX8: Double = 1.02703333676410069053e+00
private const val PP0: Double = 1.28379167095512558561e-01
private const val PP1: Double = -3.25042107247001499370e-01
private const val PP2: Double = -2.84817495755985104766e-02
private const val PP3: Double = -5.77027029648944159157e-03
private const val PP4: Double = -2.37630166566501626084e-05
private const val QQ1: Double = 3.97917223959155352819e-01
private const val QQ2: Double = 6.50222499887672944485e-02
private const val QQ3: Double = 5.08130628187576562776e-03
private const val QQ4: Double = 1.32494738004321644526e-04
private const val QQ5: Double = -3.96022827877536812320e-06

private const val PA0: Double = -2.36211856075265944077e-03
private const val PA1: Double = 4.14856118683748331666e-01
private const val PA2: Double = -3.72207876035701323847e-01
private const val PA3: Double = 3.18346619901161753674e-01
private const val PA4: Double = -1.10894694282396677476e-01
private const val PA5: Double = 3.54783043256182359371e-02
private const val PA6: Double = -2.16637559486879084300e-03
private const val QA1: Double = 1.06420880400844228286e-01
private const val QA2: Double = 5.40397917702171048937e-01
private const val QA3: Double = 7.18286544141962662868e-02
private const val QA4: Double = 1.26171219808761642112e-01
private const val QA5: Double = 1.36370839120290507362e-02
private const val QA6: Double = 1.19844998467991074170e-02

private const val RA0: Double = -9.86494403484714822705e-03
private const val RA1: Double = -6.93858572707181764372e-01
private const val RA2: Double = -1.05586262253232909814e+01
private const val RA3: Double = -6.23753324503260060396e+01
private const val RA4: Double = -1.62396669462573470355e+02
private const val RA5: Double = -1.84605092906711035994e+02
private const val RA6: Double = -8.12874355063065934246e+01
private const val RA7: Double = -9.81432934416914548592e+00
private const val SA1: Double = 1.96512716674392571292e+01
private const val SA2: Double = 1.37657754143519042600e+02
private const val SA3: Double = 4.34565877475229228821e+02
private const val SA4: Double = 6.45387271733267880336e+02
private const val SA5: Double = 4.29008140027567833386e+02
private const val SA6: Double = 1.08635005541779435134e+02
private const val SA7: Double = 6.57024977031928170135e+00
private const val SA8: Double = -6.04244152148580987438e-02

private const val RB0: Double = -9.86494292470009928597e-03
private const val RB1: Double = -7.99283237680523006574e-01
private const val RB2: Double = -1.77579549177547519889e+01
private const val RB3: Double = -1.60636384855821916062e+02
private const val RB4: Double = -6.37566443368389627722e+02
private const val RB5: Double = -1.02509513161107724954e+03
private const val RB6: Double = -4.83519191608651397019e+02
private const val SB1: Double = 3.03380607434824582924e+01
private const val SB2: Double = 3.25792512996573918826e+02
private const val SB3: Double = 1.53672958608443695994e+03
private const val SB4: Double = 3.19985821950859553908e+03
private const val SB5: Double = 2.55305040643316442583e+03
private const val SB6: Double = 4.74528541206955367215e+02
private const val SB7: Double = -2.24409524465858183362e+01

private fun getHighWord(x: Double): UInt = (x.toRawBits().toULong() shr 32).toUInt()

private fun withSetLowWord(x: Double, lo: UInt): Double {
    val bits = (x.toRawBits().toULong() and 0xffffffff00000000uL) or lo.toULong()
    return Double.fromBits(bits.toLong())
}

private fun erfc1(x: Double): Double {
    val s: Double = abs(x) - 1.0
    val p: Double = PA0 + s * (PA1 + s * (PA2 + s * (PA3 + s * (PA4 + s * (PA5 + s * PA6)))))
    val q: Double = 1.0 + s * (QA1 + s * (QA2 + s * (QA3 + s * (QA4 + s * (QA5 + s * QA6)))))

    return 1.0 - ERX - p / q
}

private fun erfc2(ix: UInt, xIn: Double): Double {
    var x = xIn
    val s: Double
    val r: Double
    val bigS: Double
    val z: Double

    if (ix < 0x3ff40000u) {
        return erfc1(x)
    }

    x = abs(x)
    s = 1.0 / (x * x)
    if (ix < 0x4006db6du) {
        r = RA0 + s * (RA1 + s * (RA2 + s * (RA3 + s * (RA4 + s * (RA5 + s * (RA6 + s * RA7))))))
        bigS = 1.0 +
            s * (
                SA1 +
                    s * (SA2 + s * (SA3 + s * (SA4 + s * (SA5 + s * (SA6 + s * (SA7 + s * SA8))))))
                )
    } else {
        r = RB0 + s * (RB1 + s * (RB2 + s * (RB3 + s * (RB4 + s * (RB5 + s * RB6)))))
        bigS = 1.0 + s * (SB1 + s * (SB2 + s * (SB3 + s * (SB4 + s * (SB5 + s * (SB6 + s * SB7))))))
    }
    z = withSetLowWord(x, 0u)

    return exp(-z * z - 0.5625) * exp((z - x) * (z + x) + r / bigS) / x
}

/**
 * Error function (f64)
 *
 * Calculates an approximation to the “error function”, which estimates
 * the probability that an observation will fall within x standard
 * deviations of the mean (assuming a normal distribution).
 */
public fun erf(x: Double): Double {
    val r: Double
    val s: Double
    val z: Double
    val y: Double
    var ix: UInt
    val sign: Int

    ix = getHighWord(x)
    sign = (ix shr 31).toInt()
    ix = ix and 0x7fffffffu
    if (ix >= 0x7ff00000u) {
        return 1.0 - 2.0 * sign.toDouble() + 1.0 / x
    }
    if (ix < 0x3feb0000u) {
        if (ix < 0x3e300000u) {
            return 0.125 * (8.0 * x + EFX8 * x)
        }
        z = x * x
        r = PP0 + z * (PP1 + z * (PP2 + z * (PP3 + z * PP4)))
        s = 1.0 + z * (QQ1 + z * (QQ2 + z * (QQ3 + z * (QQ4 + z * QQ5))))
        y = r / s
        return x + x * y
    }
    if (ix < 0x40180000u) {
        y = 1.0 - erfc2(ix, x)
    } else {
        val x1p1022 = Double.fromBits(0x0010000000000000L)
        y = 1.0 - x1p1022
    }

    return if (sign != 0) -y else y
}

/**
 * Complementary error function (f64)
 *
 * Calculates the complementary probability.
 * Is `1 - erf(x)`. Is computed directly, so that you can use it to avoid
 * the loss of precision that would result from subtracting
 * large probabilities (on large `x`) from 1.
 */
public fun erfc(x: Double): Double {
    val r: Double
    val s: Double
    val z: Double
    val y: Double
    var ix: UInt
    val sign: Int

    ix = getHighWord(x)
    sign = (ix shr 31).toInt()
    ix = ix and 0x7fffffffu
    if (ix >= 0x7ff00000u) {
        return 2.0 * sign.toDouble() + 1.0 / x
    }
    if (ix < 0x3feb0000u) {
        if (ix < 0x3c700000u) {
            return 1.0 - x
        }
        z = x * x
        r = PP0 + z * (PP1 + z * (PP2 + z * (PP3 + z * PP4)))
        s = 1.0 + z * (QQ1 + z * (QQ2 + z * (QQ3 + z * (QQ4 + z * QQ5))))
        y = r / s
        if (sign != 0 || ix < 0x3fd00000u) {
            return 1.0 - (x + x * y)
        }
        return 0.5 - (x - 0.5 + x * y)
    }
    if (ix < 0x403c0000u) {
        return if (sign != 0) {
            2.0 - erfc2(ix, x)
        } else {
            erfc2(ix, x)
        }
    }

    val x1p1022 = Double.fromBits(0x0010000000000000L)
    return if (sign != 0) {
        2.0 - x1p1022
    } else {
        x1p1022 * x1p1022
    }
}
