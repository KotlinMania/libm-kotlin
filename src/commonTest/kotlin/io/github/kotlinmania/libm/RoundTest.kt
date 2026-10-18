// port-lint: tests math/round.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals

class RoundTest {
    @Test
    fun zeroesF32() {
        assertEquals((0.0f).toBits(), roundf(0.0f).toBits())
        assertEquals((-0.0f).toBits(), roundf(-0.0f).toBits())
    }

    @Test
    fun sanityCheckF32() {
        assertEquals(-1.0f, roundf(-1.0f))
        assertEquals(3.0f, roundf(2.8f))
        assertEquals(-1.0f, roundf(-0.5f))
        assertEquals(1.0f, roundf(0.5f))
        assertEquals(-2.0f, roundf(-1.5f))
        assertEquals(2.0f, roundf(1.5f))
    }

    @Test
    fun zeroesF64() {
        assertEquals((0.0).toBits(), round(0.0).toBits())
        assertEquals((-0.0).toBits(), round(-0.0).toBits())
    }

    @Test
    fun sanityCheckF64() {
        assertEquals(-1.0, round(-1.0))
        assertEquals(3.0, round(2.8))
        assertEquals(-1.0, round(-0.5))
        assertEquals(1.0, round(0.5))
        assertEquals(-2.0, round(-1.5))
        assertEquals(2.0, round(1.5))
    }
}
