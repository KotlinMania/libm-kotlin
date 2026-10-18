// port-lint: tests math/floor.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals

class FloorTest {
    @Test
    fun sanityCheckF32() {
        assertEquals(0.0f, floorf(0.5f))
        assertEquals(1.0f, floorf(1.1f))
        assertEquals(2.0f, floorf(2.9f))
    }

    @Test
    fun specTestsF32() {
        assertEquals(0.0f, floorf(0.1f))
        assertEquals(-1.0f, floorf(-0.1f))
        assertEquals(0.0f, floorf(0.9f))
        assertEquals(-1.0f, floorf(-0.9f))
        assertEquals(1.0f, floorf(1.1f))
        assertEquals(-2.0f, floorf(-1.1f))
        assertEquals(1.0f, floorf(1.9f))
        assertEquals(-2.0f, floorf(-1.9f))
    }

    @Test
    fun sanityCheckF64() {
        assertEquals(1.0, floor(1.1))
        assertEquals(2.0, floor(2.9))
    }

    @Test
    fun specTestsF64() {
        assertEquals(0.0, floor(0.1))
        assertEquals(-1.0, floor(-0.1))
        assertEquals(0.0, floor(0.9))
        assertEquals(-1.0, floor(-0.9))
        assertEquals(1.0, floor(1.1))
        assertEquals(-2.0, floor(-1.1))
        assertEquals(1.0, floor(1.9))
        assertEquals(-2.0, floor(-1.9))
    }
}
