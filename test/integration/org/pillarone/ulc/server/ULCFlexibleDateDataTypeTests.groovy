package org.pillarone.ulc.server

import com.ulcjava.testframework.standalone.AbstractSimpleStandaloneTestCase
import com.ulcjava.base.application.ULCFrame
import com.ulcjava.base.application.ULCTextField
import com.ulcjava.base.application.ULCBoxPane
import com.ulcjava.testframework.operator.ULCFrameOperator
import com.ulcjava.testframework.operator.ULCTextFieldOperator
import com.ulcjava.testframework.operator.ComponentByNameChooser
import java.text.SimpleDateFormat


class ULCFlexibleDateDataTypeTests extends AbstractSimpleStandaloneTestCase {

    void start() {
        ULCFrame frame = new ULCFrame("test")

        ULCTextField textField = new ULCTextField()
        textField.dataType = new ULCFlexibleDateDataType(["yyyy-MM-dd"], "dd.MM.yyyy")
        textField.value = new Date()
        textField.name = "textField"

        ULCBoxPane boxPane = new ULCBoxPane()
        boxPane.add(textField)

        frame.contentPane = boxPane
        frame.visible = true
    }

    void testDataType() {
        ULCFrameOperator frameOperator = new ULCFrameOperator("test")
        ULCTextFieldOperator textFieldOperator = new ULCTextFieldOperator(frameOperator, new ComponentByNameChooser("textField"))
        assertEquals new SimpleDateFormat("dd.MM.yyyy").format(new Date()), textFieldOperator.text
    }


}
