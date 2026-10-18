// port-lint: tests math/copysign.rs
package io.github.kotlinmania.libm

import kotlin.test.Test
import kotlin.test.assertEquals

class CopysignTest {
    @Test
    fun specTestsF32() {
        val zero = 0.0f
        val negZero = -0.0f
        val one = 1.0f
        val negOne = -1.0f
        val inf = Float.POSITIVE_INFINITY
        val negInf = Float.NEGATIVE_INFINITY
        val nan = Float.NaN
        val signMask = 0x7fffffff.inv()
        val negNan = Float.fromBits(Float.NaN.toBits() or signMask)

        assertEquals(zero.toBits(), copysignf(zero, zero).toBits())
        assertEquals(zero.toBits(), copysignf(negZero, zero).toBits())
        assertEquals(negZero.toBits(), copysignf(zero, negZero).toBits())
        assertEquals(negZero.toBits(), copysignf(negZero, negZero).toBits())

        assertEquals(one.toBits(), copysignf(one, one).toBits())
        assertEquals(one.toBits(), copysignf(negOne, one).toBits())
        assertEquals(negOne.toBits(), copysignf(one, negOne).toBits())
        assertEquals(negOne.toBits(), copysignf(negOne, negOne).toBits())

        assertEquals(inf.toBits(), copysignf(inf, inf).toBits())
        assertEquals(inf.toBits(), copysignf(negInf, inf).toBits())
        assertEquals(negInf.toBits(), copysignf(inf, negInf).toBits())
        assertEquals(negInf.toBits(), copysignf(negInf, negInf).toBits())

        assertEquals(nan.toBits() and signMask, copysignf(nan, nan).toBits() and signMask)
        assertEquals(nan.toBits() and signMask, copysignf(negNan, nan).toBits() and signMask)
        assertEquals(negNan.toBits() and signMask, copysignf(nan, negNan).toBits() and signMask)
        assertEquals(negNan.toBits() and signMask, copysignf(negNan, negNan).toBits() and signMask)
    }

    @Test
    fun specTestsF64() {
        val zero = 0.0
        val negZero = -0.0
        val one = 1.0
        val negOne = -1.0
        val inf = Double.POSITIVE_INFINITY
        val negInf = Double.NEGATIVE_INFINITY
        val nan = Double.NaN
        val signMask = 0x7fffffffffffffffL.inv()
        val negNan = Double.fromBits(Double.NaN.toBits() or signMask)

        assertEquals(zero.toBits(), copysign(zero, zero).toBits())
        assertEquals(zero.toBits(), copysign(negZero, zero).toBits())
        assertEquals(negZero.toBits(), copysign(zero, negZero).toBits())
        assertEquals(negZero.toBits(), copysign(negZero, negZero).toBits())

        assertEquals(one.toBits(), copysign(one, one).toBits())
        assertEquals(one.toBits(), copysign(negOne, one).toBits())
        assertEquals(negOne.toBits(), copysign(one, negOne).toBits())
        assertEquals(negOne.toBits(), copysign(negOne, negOne).toBits())

        assertEquals(inf.toBits(), copysign(inf, inf).toBits())
        assertEquals(inf.toBits(), copysign(negInf, inf).toBits())
        assertEquals(negInf.toBits(), copysign(inf, negInf).toBits())
        assertEquals(negInf.toBits(), copysign(negInf, negInf).toBits())

        assertEquals(nan.toBits() and signMask, copysign(nan, nan).toBits() and signMask)
        assertEquals(nan.toBits() and signMask, copysign(negNan, nan).toBits() and signMask)
        assertEquals(negNan.toBits() and signMask, copysign(nan, negNan).toBits() and signMask)
        assertEquals(negNan.toBits() and signMask, copysign(negNan, negNan).toBits() and signMask)
    }
}
