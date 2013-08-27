package org.pillarone.ulc.client;

import com.ulcjava.base.client.datatype.DataTypeConversionException;
import com.ulcjava.base.client.datatype.UINumberDataType;

public class UILocaleUnawareNumberDataType extends UINumberDataType {

    @Override
    protected Object doStringToObjectConversion(String newString, Object previousValue) throws DataTypeConversionException {
        return super.doStringToObjectConversion(convertStringIfNeeded(newString), previousValue);
    }

    private String convertStringIfNeeded(final String value) {
        if (value.contains(",") && getDecimalSeparator() != ',') {
            return value.replace(',', getDecimalSeparator());
        }
        if (value.contains(".") && getDecimalSeparator() != '.') {
            return value.replace('.', getDecimalSeparator());
        }
        return value;
    }
}