package org.pillarone.ulc.server

import com.ulcjava.base.application.AbstractAction
import com.ulcjava.base.application.ULCBoxPane
import com.ulcjava.base.application.ULCFrame
import com.ulcjava.base.application.event.ActionEvent
import com.ulcjava.testframework.operator.ComponentByNameChooser
import com.ulcjava.testframework.operator.ULCFrameOperator
import com.ulcjava.testframework.operator.ULCToggleButtonOperator
import com.ulcjava.testframework.standalone.AbstractSimpleStandaloneTestCase

class ULCVerticalToggleButtonTests extends AbstractSimpleStandaloneTestCase {


    void start() {
        ULCBoxPane boxPane = new ULCBoxPane()
        ULCVerticalToggleButton button = new ULCVerticalToggleButton(new DoNothing("text"))
        button.name = "button"

        boxPane.add(button)

        ULCFrame frame = new ULCFrame("test")
        frame.contentPane = boxPane
        frame.visible = true
    }

    void testButton() {
        ULCFrameOperator frame = new ULCFrameOperator("test")
        ULCToggleButtonOperator button = new ULCToggleButtonOperator(frame, new ComponentByNameChooser("button"))
        button.clickMouse()
    }

}

class DoNothing extends AbstractAction {

    DoNothing() {
    }

    DoNothing(String s) {
        super(s)
    }

    void actionPerformed(ActionEvent actionEvent) {

    }
}

