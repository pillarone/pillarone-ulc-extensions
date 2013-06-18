package org.pillarone.ulc.client

class UINonNullableNumberDataTypeTest extends GroovyTestCase {

    void testConvertString() {
        UINonEmptyNumberDataType dataType = new UINonEmptyNumberDataType()
        dataType.setClassType("Integer")
        dataType.initConverter()
        assertEquals(1, dataType.doStringToObjectConversion('', 1))
        assertEquals(null, dataType.doStringToObjectConversion('', null))
        assertEquals(null, dataType.doStringToObjectConversion(null, null))
        assertEquals(10, dataType.doStringToObjectConversion('10', null))
        assertEquals(10, dataType.doStringToObjectConversion('10', 2))
    }
}
