// port-lint: source math/fmin_fmax.rs
package io.github.kotlinmania.libm

/**
 * Return the lesser of two arguments or, if either argument is NaN, the other argument (Float).
 *
 * This coincides with IEEE 754-2011 minNum.
 */
public fun fminf(x: Float, y: Float): Float {
    val res = if (y.isNaN() || x < y) x else y
    return res * 1.0f
}

/**
 * Return the lesser of two arguments or, if either argument is NaN, the other argument (Float).
 */
public fun fmin(x: Float, y: Float): Float = fminf(x, y)

/**
 * Return the lesser of two arguments or, if either argument is NaN, the other argument (Double).
 *
 * This coincides with IEEE 754-2011 minNum.
 */
public fun fmin(x: Double, y: Double): Double {
    val res = if (y.isNaN() || x < y) x else y
    return res * 1.0
}

/**
 * Return the greater of two arguments or, if either argument is NaN, the other argument (Float).
 *
 * This coincides with IEEE 754-2011 maxNum.
 */
public fun fmaxf(x: Float, y: Float): Float {
    val res = if (y.isNaN() || x > y) x else y
    return res * 1.0f
}

/**
 * Return the greater of two arguments or, if either argument is NaN, the other argument (Float).
 */
public fun fmax(x: Float, y: Float): Float = fmaxf(x, y)

/**
 * Return the greater of two arguments or, if either argument is NaN, the other argument (Double).
 *
 * This coincides with IEEE 754-2011 maxNum.
 */
public fun fmax(x: Double, y: Double): Double {
    val res = if (y.isNaN() || x > y) x else y
    return res * 1.0
}
