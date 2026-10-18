// port-lint: source math/fabs.rs
package io.github.kotlinmania.libm

/**
 * Absolute value (magnitude) (Float).
 *
 * Calculates the absolute value (magnitude) of the argument [x],
 * by direct manipulation of the bit representation of [x].
 */
public fun fabs(x: Float): Float = fabsf(x)

/**
 * Absolute value (magnitude) (Double).
 *
 * Calculates the absolute value (magnitude) of the argument [x],
 * by direct manipulation of the bit representation of [x].
 */
public fun fabs(x: Double): Double {
    val absMask = 0x7fffffffffffffffL
    return Double.fromBits(x.toBits() and absMask)
}
