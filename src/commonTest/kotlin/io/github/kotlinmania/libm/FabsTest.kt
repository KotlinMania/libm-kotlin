// port-lint: tests math/fabs.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FabsTest {
    @Test
    fun sanityCheckF32() {
        assertEquals(1.0f.toBits(), fabsf(-1.0f).toBits())
        assertEquals(2.8f.toBits(), fabsf(2.8f).toBits())
    }

    @Test
    fun specTestsF32() {
        val signMask = 0x7fffffff.inv()
        assertEquals(0.0f.toBits(), fabsf(0.0f).toBits())
        assertEquals(0.0f.toBits(), fabsf(-0.0f).toBits())
        assertEquals(Float.POSITIVE_INFINITY.toBits(), fabsf(Float.POSITIVE_INFINITY).toBits())
        assertEquals(Float.POSITIVE_INFINITY.toBits(), fabsf(Float.NEGATIVE_INFINITY).toBits())
        assertTrue(fabsf(Float.NaN).isNaN())
        assertEquals(0, fabsf(Float.NaN).toBits() and signMask)
    }

    @Test
    fun sanityCheckF64() {
        assertEquals(1.0, fabs(-1.0))
        assertEquals(2.8, fabs(2.8))
    }

    @Test
    fun specTestsF64() {
        val signMask = 0x7fffffffffffffffL.inv()
        assertEquals(0.0.toBits(), fabs(0.0).toBits())
        assertEquals(0.0.toBits(), fabs(-0.0).toBits())
        assertEquals(Double.POSITIVE_INFINITY.toBits(), fabs(Double.POSITIVE_INFINITY).toBits())
        assertEquals(Double.POSITIVE_INFINITY.toBits(), fabs(Double.NEGATIVE_INFINITY).toBits())
        assertTrue(fabs(Double.NaN).isNaN())
        assertEquals(0L, fabs(Double.NaN).toBits() and signMask)
    }
}
