// port-lint: tests math/trunc.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals

class TruncTest {
    @Test
    fun sanityCheckF32() {
        assertEquals(0.0f, truncf(0.5f))
        assertEquals(1.0f, truncf(1.1f))
        assertEquals(2.0f, truncf(2.9f))
    }

    @Test
    fun specTestsF32() {
        assertEquals(0.0f.toBits(), truncf(0.1f).toBits())
        assertEquals((-0.0f).toBits(), truncf(-0.1f).toBits())
        assertEquals(0.0f.toBits(), truncf(0.9f).toBits())
        assertEquals((-0.0f).toBits(), truncf(-0.9f).toBits())
        assertEquals(1.0f.toBits(), truncf(1.1f).toBits())
        assertEquals((-1.0f).toBits(), truncf(-1.1f).toBits())
        assertEquals(1.0f.toBits(), truncf(1.9f).toBits())
        assertEquals((-1.0f).toBits(), truncf(-1.9f).toBits())
    }

    @Test
    fun sanityCheckF64() {
        assertEquals(1.0, trunc(1.1))
        assertEquals(2.0, trunc(2.9))
    }

    @Test
    fun specTestsF64() {
        assertEquals(0.0.toBits(), trunc(0.1).toBits())
        assertEquals((-0.0).toBits(), trunc(-0.1).toBits())
        assertEquals(0.0.toBits(), trunc(0.9).toBits())
        assertEquals((-0.0).toBits(), trunc(-0.9).toBits())
        assertEquals(1.0.toBits(), trunc(1.1).toBits())
        assertEquals((-1.0).toBits(), trunc(-1.1).toBits())
        assertEquals(1.0.toBits(), trunc(1.9).toBits())
        assertEquals((-1.0).toBits(), trunc(-1.9).toBits())
    }
}
