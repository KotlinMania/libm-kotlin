package io.github.kotlinmania.libm

public object Libm {
    public fun erf(x: Double): Double = io.github.kotlinmania.libm.erf(x)
    public fun erff(x: Float): Float = io.github.kotlinmania.libm.erff(x)
    public fun erfc(x: Double): Double = io.github.kotlinmania.libm.erfc(x)
    public fun erfcf(x: Float): Float = io.github.kotlinmania.libm.erfcf(x)
}

public val libm: Libm = Libm
