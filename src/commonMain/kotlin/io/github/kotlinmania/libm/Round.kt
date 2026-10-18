// port-lint: source math/round.rs
package io.github.kotlinmania.libm

/**
 * Round [x] to the nearest integer, breaking ties away from zero (Float).
 */
public fun round(x: Float): Float = roundf(x)

/**
 * Round [x] to the nearest integer, breaking ties away from zero (Double).
 */
public fun round(x: Double): Double {
    if (x.isNaN()) {
        return x
    }
    val f0p5 = 0.5
    val f0p25 = 0.25
    val epsilon = Double.fromBits(0x3cb0000000000000L)
    val step = f0p5 - f0p25 * epsilon
    return trunc(x + copysign(step, x))
}
