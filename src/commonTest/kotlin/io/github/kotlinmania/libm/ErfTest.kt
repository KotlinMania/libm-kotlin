// port-lint: tests math/erf.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ErfTest {
    @Test
    fun testErfF64() {
        assertEquals(0.0.toBits(), erf(0.0).toBits())
        assertEquals((-0.0).toBits(), erf(-0.0).toBits())
        assertEquals(1.0, erf(Double.POSITIVE_INFINITY))
        assertEquals(-1.0, erf(Double.NEGATIVE_INFINITY))
        assertTrue(erf(Double.NaN).isNaN())
        assertEquals(1.0, erfc(0.0))
        assertEquals(0.0, erfc(Double.POSITIVE_INFINITY))
        assertEquals(2.0, erfc(Double.NEGATIVE_INFINITY))
        assertTrue(erfc(Double.NaN).isNaN())
    }

    @Test
    fun testErfF32() {
        assertEquals(0.0f.toBits(), erff(0.0f).toBits())
        assertEquals((-0.0f).toBits(), erff(-0.0f).toBits())
        assertEquals(1.0f, erff(Float.POSITIVE_INFINITY))
        assertEquals(-1.0f, erff(Float.NEGATIVE_INFINITY))
        assertTrue(erff(Float.NaN).isNaN())
        assertEquals(1.0f, erfcf(0.0f))
        assertEquals(0.0f, erfcf(Float.POSITIVE_INFINITY))
        assertEquals(2.0f, erfcf(Float.NEGATIVE_INFINITY))
        assertTrue(erfcf(Float.NaN).isNaN())
    }
}
