package org.pillarone.ulc.server

import com.ulcjava.base.application.ULCBoxPane
import com.ulcjava.base.application.ULCFrame
import com.ulcjava.base.application.ULCTextField
import com.ulcjava.base.application.event.KeyEvent
import com.ulcjava.base.application.util.Dimension
import com.ulcjava.testframework.operator.ComponentByNameChooser
import com.ulcjava.testframework.operator.ULCFrameOperator
import com.ulcjava.testframework.operator.ULCTextFieldOperator
import com.ulcjava.testframework.standalone.AbstractSimpleStandaloneTestCase

class ULCNonEmptyTextFieldTests extends AbstractSimpleStandaloneTestCase {

    void testFieldEmptyValuesNotSaved(){
        ULCFrameOperator frameOperator = new ULCFrameOperator("test")
        ULCTextFieldOperator textFieldOperator = new ULCTextFieldOperator(frameOperator, new ComponentByNameChooser("textField"))
        String originalValue = textFieldOperator.text
        textFieldOperator.enterText('')
        textFieldOperator.pressKey(KeyEvent.VK_ENTER)
        assert originalValue == textFieldOperator.getULCTextField().text
    }

    @Override
    void start() {
        ULCFrame frame = new ULCFrame('test')
        ULCBoxPane boxPane = new ULCBoxPane()
        ULCTextField textField = new ULCNonEmptyTextField()
        textField.text = '3'
        textField.name ='textField'
        boxPane.add(textField)
        frame.contentPane = boxPane
        frame.size = new Dimension(300,300)
        frame.visible = true
    }
}
