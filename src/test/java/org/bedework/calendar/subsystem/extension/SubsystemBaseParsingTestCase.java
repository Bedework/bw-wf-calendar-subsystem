package org.bedework.calendar.subsystem.extension;


import org.jboss.as.subsystem.test.AbstractSubsystemBaseTest;

import java.io.IOException;


/**
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
public class SubsystemBaseParsingTestCase extends AbstractSubsystemBaseTest {

    public SubsystemBaseParsingTestCase() {
        super(CalendarExtension.SUBSYSTEM_NAME, new CalendarExtension());
    }

    @Override
    protected String getSubsystemXml() throws IOException {
        return readResource("subsystem.xml");
    }
}
