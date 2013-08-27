package org.pillarone.ulc.server

import com.ulcjava.base.application.ULCTextField

class ULCNonEmptyTextField extends ULCTextField {

    protected String typeString() {
        return "org.pillarone.ulc.client.UINonEmptyTextField";
    }
}
