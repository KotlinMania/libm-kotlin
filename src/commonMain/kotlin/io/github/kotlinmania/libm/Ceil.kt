// port-lint: source math/ceil.rs
package io.github.kotlinmania.libm

/**
 * Ceil (Float).
 *
 * Finds the nearest integer greater than or equal to [x].
 */
public fun ceil(x: Float): Float = ceilf(x)

/**
 * Ceil (Double).
 *
 * Finds the nearest integer greater than or equal to [x].
 */
public fun ceil(x: Double): Double {
    val ix = x.toBits().toULong()
    val expBits = ((ix and 0x7ff0000000000000UL) shr 52).toInt()
    val e = expBits - 1023

    if (e >= 52) {
        return x
    }

    val isNegative = (ix and 0x8000000000000000UL) != 0UL

    if (e >= 0) {
        val m = 0x000fffffffffffffUL shr e
        if ((ix and m) == 0UL) {
            return x
        }

        var adjusted = ix
        if (!isNegative) {
            adjusted += m
        }
        adjusted = adjusted and m.inv()
        return Double.fromBits(adjusted.toLong())
    } else {
        if (isNegative) {
            return -0.0
        } else if ((ix shl 1) != 0UL) {
            return 1.0
        } else {
            return x
        }
    }
}
