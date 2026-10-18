// port-lint: source math/trunc.rs
package io.github.kotlinmania.libm

/**
 * Rounds the number toward 0 to the closest integral value (Float).
 *
 * This effectively removes the decimal part of the number, leaving the integral part.
 */
public fun trunc(x: Float): Float = truncf(x)

/**
 * Rounds the number toward 0 to the closest integral value (Double).
 *
 * This effectively removes the decimal part of the number, leaving the integral part.
 */
public fun trunc(x: Double): Double {
    val ix = x.toBits().toULong()
    val expBits = ((ix and 0x7ff0000000000000UL) shr 52).toInt()
    val e = expBits - 1023

    if (e >= 52) {
        return x
    }

    val mask =
        if (e < 0) {
            0x8000000000000000UL
        } else {
            (0x000fffffffffffffUL shr e).inv()
        }

    if ((ix and mask.inv()) == 0UL) {
        return x
    }

    return Double.fromBits((ix and mask).toLong())
}
