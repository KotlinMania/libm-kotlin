// port-lint: source math/fabsf.rs
package io.github.kotlinmania.libm

/**
 * Absolute value (magnitude) (Float).
 *
 * Calculates the absolute value (magnitude) of the argument [x],
 * by direct manipulation of the bit representation of [x].
 */
public fun fabsf(x: Float): Float {
    val absMask = 0x7fffffff
    return Float.fromBits(x.toBits() and absMask)
}
