// port-lint: source math/roundf.rs
package io.github.kotlinmania.libm

/**
 * Round [x] to the nearest integer, breaking ties away from zero (Float).
 */
public fun roundf(x: Float): Float {
    if (x.isNaN()) {
        return x
    }
    val f0p5 = 0.5f
    val f0p25 = 0.25f
    val epsilon = Float.fromBits(0x34000000)
    val step = f0p5 - f0p25 * epsilon
    val sum = Float.fromBits((x + copysignf(step, x)).toBits())
    return truncf(sum)
}
