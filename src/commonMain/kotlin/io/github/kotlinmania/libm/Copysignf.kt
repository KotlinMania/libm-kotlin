// port-lint: source math/copysignf.rs
package io.github.kotlinmania.libm

/**
 * Sign of Y, magnitude of X (Float).
 *
 * Constructs a number with the magnitude (absolute value) of its
 * first argument, [x], and the sign of its second argument, [y].
 */
public fun copysignf(x: Float, y: Float): Float {
    val ux = x.toBits()
    val uy = y.toBits()
    val signMask = 0x7fffffff.inv()
    val absMask = 0x7fffffff
    val resBits = (ux and absMask) or (uy and signMask)
    return Float.fromBits(resBits)
}
