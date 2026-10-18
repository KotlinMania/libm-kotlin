// port-lint: tests math/fmin_fmax.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FminFmaxTest {
    @Test
    fun specTestsF32() {
        assertEquals(1.0f, fminf(1.0f, 2.0f))
        assertEquals(1.0f, fminf(Float.NaN, 1.0f))
        assertEquals(1.0f, fminf(1.0f, Float.NaN))
        assertTrue(fminf(Float.NaN, Float.NaN).isNaN())
        assertEquals(2.0f, fmaxf(1.0f, 2.0f))
        assertEquals(1.0f, fmaxf(Float.NaN, 1.0f))
        assertEquals(1.0f, fmaxf(1.0f, Float.NaN))
        assertTrue(fmaxf(Float.NaN, Float.NaN).isNaN())
    }

    @Test
    fun specTestsF64() {
        assertEquals(1.0, fmin(1.0, 2.0))
        assertEquals(1.0, fmin(Double.NaN, 1.0))
        assertEquals(1.0, fmin(1.0, Double.NaN))
        assertTrue(fmin(Double.NaN, Double.NaN).isNaN())
        assertEquals(2.0, fmax(1.0, 2.0))
        assertEquals(1.0, fmax(Double.NaN, 1.0))
        assertEquals(1.0, fmax(1.0, Double.NaN))
        assertTrue(fmax(Double.NaN, Double.NaN).isNaN())
    }
}
