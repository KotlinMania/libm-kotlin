// port-lint: source math/ceilf.rs
package io.github.kotlinmania.libm

/**
 * Ceil (Float).
 *
 * Finds the nearest integer greater than or equal to [x].
 */
public fun ceilf(x: Float): Float {
    val ix = x.toBits().toUInt()
    val expBits = ((ix and 0x7f800000U) shr 23).toInt()
    val e = expBits - 127

    if (e >= 23) {
        return x
    }

    val isNegative = (ix and 0x80000000U) != 0U

    if (e >= 0) {
        val m = 0x007fffffU shr e
        if ((ix and m) == 0U) {
            return x
        }

        var adjusted = ix
        if (!isNegative) {
            adjusted += m
        }
        adjusted = adjusted and m.inv()
        return Float.fromBits(adjusted.toInt())
    } else {
        if (isNegative) {
            return -0.0f
        } else if ((ix shl 1) != 0U) {
            return 1.0f
        } else {
            return x
        }
    }
}
