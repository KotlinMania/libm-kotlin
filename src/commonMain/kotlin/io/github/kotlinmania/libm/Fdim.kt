// port-lint: source math/fdim.rs
package io.github.kotlinmania.libm

/**
 * Positive difference (Float).
 *
 * Determines the positive difference between arguments, returning:
 * * x - y if x > y, or
 * * +0    if x <= y, or
 * * NaN   if either argument is NaN.
 */
public fun fdim(x: Float, y: Float): Float = fdimf(x, y)

/**
 * Positive difference (Double).
 *
 * Determines the positive difference between arguments, returning:
 * * x - y if x > y, or
 * * +0    if x <= y, or
 * * NaN   if either argument is NaN.
 */
public fun fdim(x: Double, y: Double): Double = if (x <= y) 0.0 else x - y
