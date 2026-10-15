#if canImport(Testing)
import Testing
import Libm

@Suite("Libm Swift Export Tests")
struct LibmExportTests {
    @Test("Libm swift module imported cleanly")
    func testSwiftModuleLoads() throws {
        #expect(Bool(true), "Libm swift module imported cleanly")
    }
}
#elseif canImport(XCTest)
import XCTest
import Libm

final class LibmExportTests: XCTestCase {
    func testSwiftModuleLoads() throws {
        XCTAssertTrue(true, "Libm swift module imported cleanly")
    }
}
#endif
