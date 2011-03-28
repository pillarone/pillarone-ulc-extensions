package org.pillarone.ulc.server

import com.ulcjava.testframework.standalone.AbstractSimpleStandaloneTestCase
import com.ulcjava.base.application.util.Dimension
import com.ulcjava.testframework.operator.ULCFrameOperator


class ULCMinimalSizeFrameTests extends AbstractSimpleStandaloneTestCase {

    void start() {
        ULCMinimalSizeFrame frame = new ULCMinimalSizeFrame("test")
        frame.minimumSize = new Dimension(200, 200)
        frame.visible = true
    }

    void testButton() {
        ULCFrameOperator frame = new ULCFrameOperator("test")
        assertNotNull frame
    }
}
