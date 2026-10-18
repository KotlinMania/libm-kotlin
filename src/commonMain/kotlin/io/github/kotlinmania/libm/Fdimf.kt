// port-lint: source math/fdimf.rs
package io.github.kotlinmania.libm

/**
 * Positive difference (Float).
 *
 * Determines the positive difference between arguments, returning:
 * * x - y if x > y, or
 * * +0    if x <= y, or
 * * NaN   if either argument is NaN.
 */
public fun fdimf(x: Float, y: Float): Float = if (x <= y) 0.0f else x - y
