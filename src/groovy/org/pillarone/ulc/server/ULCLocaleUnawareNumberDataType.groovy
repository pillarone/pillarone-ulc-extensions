package org.pillarone.ulc.server

import com.ulcjava.base.application.datatype.ULCAbstractErrorManager
import com.ulcjava.base.application.datatype.ULCNumberDataType

class ULCLocaleUnawareNumberDataType extends ULCNumberDataType {
    ULCLocaleUnawareNumberDataType(ULCAbstractErrorManager ulcAbstractErrorManager, Locale locale) {
        super(ulcAbstractErrorManager, locale)
    }

    @Override
    protected String typeString() {
        return "org.pillarone.ulc.client.UILocaleUnawareNumberDataType"

    }
}
