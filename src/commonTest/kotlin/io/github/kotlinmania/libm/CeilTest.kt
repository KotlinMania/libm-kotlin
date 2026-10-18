// port-lint: tests math/ceil.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals

class CeilTest {
    @Test
    fun sanityCheckF32() {
        assertEquals(2.0f, ceilf(1.1f))
        assertEquals(3.0f, ceilf(2.9f))
    }

    @Test
    fun specTestsF32() {
        assertEquals(1.0f.toBits(), ceilf(0.1f).toBits())
        assertEquals((-0.0f).toBits(), ceilf(-0.1f).toBits())
        assertEquals(1.0f.toBits(), ceilf(0.9f).toBits())
        assertEquals((-0.0f).toBits(), ceilf(-0.9f).toBits())
        assertEquals(2.0f.toBits(), ceilf(1.1f).toBits())
        assertEquals((-1.0f).toBits(), ceilf(-1.1f).toBits())
        assertEquals(2.0f.toBits(), ceilf(1.9f).toBits())
        assertEquals((-1.0f).toBits(), ceilf(-1.9f).toBits())
    }

    @Test
    fun sanityCheckF64() {
        assertEquals(2.0, ceil(1.1))
        assertEquals(3.0, ceil(2.9))
    }

    @Test
    fun specTestsF64() {
        assertEquals(1.0.toBits(), ceil(0.1).toBits())
        assertEquals((-0.0).toBits(), ceil(-0.1).toBits())
        assertEquals(1.0.toBits(), ceil(0.9).toBits())
        assertEquals((-0.0).toBits(), ceil(-0.9).toBits())
        assertEquals(2.0.toBits(), ceil(1.1).toBits())
        assertEquals((-1.0).toBits(), ceil(-1.1).toBits())
        assertEquals(2.0.toBits(), ceil(1.9).toBits())
        assertEquals((-1.0).toBits(), ceil(-1.9).toBits())
    }
}
