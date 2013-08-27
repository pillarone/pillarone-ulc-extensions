package org.pillarone.ulc.client;

import com.ulcjava.base.client.UITextField;

/**
 * UI Textfield that prevents empty values in textFields.
 */
public class UINonEmptyTextField extends UITextField {
    @Override
    protected void updateToModel(boolean displayFormattedValue) {
        String text = getBasicTextComponent().getText();
        if (text != null && text.length() > 0) {
            super.updateToModel(displayFormattedValue);
        }
    }
}
