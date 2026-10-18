package io.github.kotlinmania.libm

public object Libm {
    public fun erf(x: Double): Double =
        io.github.kotlinmania.libm
            .erf(x)

    public fun erff(x: Float): Float =
        io.github.kotlinmania.libm
            .erff(x)

    public fun erfc(x: Double): Double =
        io.github.kotlinmania.libm
            .erfc(x)

    public fun erfcf(x: Float): Float =
        io.github.kotlinmania.libm
            .erfcf(x)

    public fun copysign(x: Double, y: Double): Double =
        io.github.kotlinmania.libm
            .copysign(x, y)

    public fun copysignf(x: Float, y: Float): Float =
        io.github.kotlinmania.libm
            .copysignf(x, y)

    public fun fabs(x: Double): Double =
        io.github.kotlinmania.libm
            .fabs(x)

    public fun fabsf(x: Float): Float =
        io.github.kotlinmania.libm
            .fabsf(x)

    public fun fdim(x: Double, y: Double): Double =
        io.github.kotlinmania.libm
            .fdim(x, y)

    public fun fdimf(x: Float, y: Float): Float =
        io.github.kotlinmania.libm
            .fdimf(x, y)

    public fun floor(x: Double): Double =
        io.github.kotlinmania.libm
            .floor(x)

    public fun floorf(x: Float): Float =
        io.github.kotlinmania.libm
            .floorf(x)

    public fun ceil(x: Double): Double =
        io.github.kotlinmania.libm
            .ceil(x)

    public fun ceilf(x: Float): Float =
        io.github.kotlinmania.libm
            .ceilf(x)

    public fun trunc(x: Double): Double =
        io.github.kotlinmania.libm
            .trunc(x)

    public fun truncf(x: Float): Float =
        io.github.kotlinmania.libm
            .truncf(x)

    public fun round(x: Double): Double =
        io.github.kotlinmania.libm
            .round(x)

    public fun roundf(x: Float): Float =
        io.github.kotlinmania.libm
            .roundf(x)

    public fun fmin(x: Double, y: Double): Double =
        io.github.kotlinmania.libm
            .fmin(x, y)

    public fun fminf(x: Float, y: Float): Float =
        io.github.kotlinmania.libm
            .fminf(x, y)

    public fun fmax(x: Double, y: Double): Double =
        io.github.kotlinmania.libm
            .fmax(x, y)

    public fun fmaxf(x: Float, y: Float): Float =
        io.github.kotlinmania.libm
            .fmaxf(x, y)
}

public val libm: Libm = Libm
