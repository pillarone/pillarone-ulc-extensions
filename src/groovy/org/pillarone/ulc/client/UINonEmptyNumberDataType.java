package org.pillarone.ulc.client;

import com.ulcjava.base.client.datatype.DataTypeConversionException;
import com.ulcjava.base.client.datatype.UINumberDataType;

public class UINonEmptyNumberDataType extends UINumberDataType {

    @Override
    protected Object doStringToObjectConversion(String newString, Object previousValue) throws DataTypeConversionException {
        return super.doStringToObjectConversion(convertStringIfNeeded(newString, previousValue), previousValue);
    }

    /**
     * Returns the previous value in case an empty string is passed.
     * @param value
     * @param previousValue
     * @return
     */
    private String convertStringIfNeeded(final String value, final Object previousValue) {
        if ("".equals(value)) {
            return previousValue != null ? previousValue.toString() : "";
        }
        return value;
    }
}