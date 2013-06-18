package org.pillarone.ulc.client

class UILocaleUnawareNumberDataTypeTest extends GroovyTestCase {

    void testStringConversion() {
        UILocaleUnawareNumberDataType dataType = new UILocaleUnawareNumberDataType()
        dataType.setClassType("Double")
        dataType.setDecimalSeparator('.' as char)
        dataType.initConverter()
        assertEquals(0.1d, dataType.doStringToObjectConversion('0.1',null))
        assertEquals(0.1d, dataType.doStringToObjectConversion('0.1',1d))
        assertEquals(1d, dataType.doStringToObjectConversion('',1d))
        assertEquals(null, dataType.doStringToObjectConversion('',null))
        assertEquals(0.1d, dataType.doStringToObjectConversion('0,1',1d))

    }

}
