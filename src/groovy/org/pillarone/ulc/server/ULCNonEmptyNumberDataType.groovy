package org.pillarone.ulc.server

import com.ulcjava.base.application.datatype.ULCAbstractErrorManager
import com.ulcjava.base.application.datatype.ULCNumberDataType

class ULCNonEmptyNumberDataType extends ULCNumberDataType {
    ULCNonEmptyNumberDataType(ULCAbstractErrorManager ulcAbstractErrorManager, Locale locale) {
        super(ulcAbstractErrorManager, locale)
    }

    @Override
    protected String typeString() {
        return "org.pillarone.ulc.client.UINonEmptyNumberDataType"

    }
}
