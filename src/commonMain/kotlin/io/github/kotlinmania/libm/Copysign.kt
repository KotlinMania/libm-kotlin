// port-lint: source math/copysign.rs
package io.github.kotlinmania.libm

/**
 * Sign of Y, magnitude of X (Float).
 *
 * Constructs a number with the magnitude (absolute value) of its
 * first argument, [x], and the sign of its second argument, [y].
 */
public fun copysign(x: Float, y: Float): Float = copysignf(x, y)

/**
 * Sign of Y, magnitude of X (Double).
 *
 * Constructs a number with the magnitude (absolute value) of its
 * first argument, [x], and the sign of its second argument, [y].
 */
public fun copysign(x: Double, y: Double): Double {
    val ux = x.toBits()
    val uy = y.toBits()
    val signMask = 0x7fffffffffffffffL.inv()
    val absMask = 0x7fffffffffffffffL
    val resBits = (ux and absMask) or (uy and signMask)
    return Double.fromBits(resBits)
}
