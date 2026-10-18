# libm-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Flibm-kotlin-blue.svg)](https://github.com/KotlinMania/libm-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/libm-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/libm-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/libm-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/libm-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`libm`](https://github.com/rust-lang/libm).

**Original Project:** This port is based on [`libm`](https://github.com/rust-lang/libm). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `libm`

> The text below is reproduced from [`https://github.com/rust-lang/libm`](https://github.com/rust-lang/libm). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs where appropriate so they continue to resolve from this repository.

# `libm`

A Rust implementations of the C math library.

## Usage

`libm` provides fallback implementations for Rust's [float math functions] in
`core`, and the [`core_float_math`] feature. If what is available suits your
needs, there is no need to add `libm` as a dependency.

If more functionality is needed, this crate can also be used directly:

```toml
[dependencies]
libm = "0.2.11"
```

[float math functions]: https://doc.rust-lang.org/std/primitive.f32.html
[`core_float_math`]: https://github.com/rust-lang/rust/issues/137578

## Contributing

Please check [CONTRIBUTING.md](../CONTRIBUTING.md)

## Minimum Rust version policy

This crate supports rustc 1.63 and newer.

## License

Usage is under the MIT license, available at
<https://opensource.org/license/mit>.

### Contribution

Contributions are licensed under both the MIT license and the Apache License,
Version 2.0, available at <htps://www.apache.org/licenses/LICENSE-2.0>. Unless
you explicitly state otherwise, any contribution intentionally submitted for
inclusion in the work by you, as defined in the Apache-2.0 license, shall be
dual licensed as mentioned, without any additional terms or conditions.

See [LICENSE.txt](LICENSE.txt) for full details.

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:libm-kotlin:0.1.0")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same license terms as the upstream [`libm`](https://github.com/rust-lang/libm). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the libm authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`libm`](https://github.com/rust-lang/libm) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.
