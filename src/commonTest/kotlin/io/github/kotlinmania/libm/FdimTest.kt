// port-lint: tests math/fdim.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FdimTest {
    @Test
    fun testFdimf() {
        assertEquals(3.0f, fdimf(4.0f, 1.0f))
        assertEquals(0.0f, fdimf(1.0f, 4.0f))
        assertEquals(0.0f, fdimf(4.0f, 4.0f))
        assertTrue(fdimf(Float.NaN, 1.0f).isNaN())
        assertTrue(fdimf(1.0f, Float.NaN).isNaN())
    }

    @Test
    fun testFdim() {
        assertEquals(3.0, fdim(4.0, 1.0))
        assertEquals(0.0, fdim(1.0, 4.0))
        assertEquals(0.0, fdim(4.0, 4.0))
        assertTrue(fdim(Double.NaN, 1.0).isNaN())
        assertTrue(fdim(1.0, Double.NaN).isNaN())
    }
}
