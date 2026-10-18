// port-lint: source math/truncf.rs
package io.github.kotlinmania.libm

/**
 * Rounds the number toward 0 to the closest integral value (Float).
 *
 * This effectively removes the decimal part of the number, leaving the integral part.
 */
public fun truncf(x: Float): Float {
    val ix = x.toBits().toUInt()
    val expBits = ((ix and 0x7f800000U) shr 23).toInt()
    val e = expBits - 127

    if (e >= 23) {
        return x
    }

    val mask =
        if (e < 0) {
            0x80000000U
        } else {
            (0x007fffffU shr e).inv()
        }

    if ((ix and mask.inv()) == 0U) {
        return x
    }

    return Float.fromBits((ix and mask).toInt())
}
