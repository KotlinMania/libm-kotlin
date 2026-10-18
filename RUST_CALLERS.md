# Rust callers — `libm-kotlin`

## What this file is

For every Rust crate this repo owns (under `tmp/`), this file lists every **cross-repo** workspace caller: every `use` statement in another `*-kotlin` repo's Rust source that imports a symbol from one of this repo's crates.

## Crates in this repo

| package | module | inbound use sites | distinct caller crates | distinct caller repos |
|---|---|---:|---:|---:|
| `libm` | `libm` | 68 | 3 | 3 |

## `libm`

### Inbound symbols

#### `libm::erf` / `libm::erff` / `libm::erfc` / `libm::erfcf`
- `candle-kotlin/candle-core` `src/cpu/erf.rs` — calls `libm::erf`, `libm::erff`, `libm::erfc`, `libm::erfcf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.erf`, `erff`, `erfc`, `erfcf`.

#### `libm::copysign` / `libm::copysignf`
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::copysign`, `libm::copysignf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.copysign`, `copysignf`.

#### `libm::fabs` / `libm::fabsf`
- `ab-glyph-kotlin/ab_glyph` `rasterizer/src/nostd_float.rs` — `libm::fabsf`.
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::fabs`, `libm::fabsf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.fabs`, `fabsf`.

#### `libm::floor` / `libm::floorf`
- `ab-glyph-kotlin/ab_glyph` `rasterizer/src/nostd_float.rs`, `glyph/src/nostd_float.rs` — `libm::floorf`.
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::floor`, `libm::floorf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.floor`, `floorf`.

#### `libm::ceil` / `libm::ceilf`
- `ab-glyph-kotlin/ab_glyph` `rasterizer/src/nostd_float.rs`, `glyph/src/nostd_float.rs` — `libm::ceilf`.
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::ceil`, `libm::ceilf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.ceil`, `ceilf`.

#### `libm::round` / `libm::roundf`
- `ab-glyph-kotlin/ab_glyph` `glyph/src/nostd_float.rs` — `libm::roundf`.
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::round`, `libm::roundf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.round`, `roundf`.

#### `libm::trunc` / `libm::truncf`
- `ab-glyph-kotlin/ab_glyph` `glyph/src/nostd_float.rs` — `libm::truncf`.
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::trunc`, `libm::truncf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.trunc`, `truncf`.

#### `libm::fdim` / `libm::fdimf`
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::fdim`, `libm::fdimf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.fdim`, `fdimf`.

#### `libm::fmin` / `libm::fminf` / `libm::fmax` / `libm::fmaxf`
- `num-traits-kotlin/num-traits` `src/float.rs` — `libm::fmin`, `libm::fminf`, `libm::fmax`, `libm::fmaxf`.
  - Canonical Kotlin mapping: `import io.github.kotlinmania.libm.fmin`, `fminf`, `fmax`, `fmaxf`.
