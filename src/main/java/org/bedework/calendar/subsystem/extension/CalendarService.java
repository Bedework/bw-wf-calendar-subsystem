package org.bedework.calendar.subsystem.extension;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

/**
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
public class CalendarService implements Service<CalendarService> {

  public CalendarService() {
  }

  @Override
  public CalendarService getValue() throws IllegalStateException, IllegalArgumentException {
    return this;
  }

  @Override
  public void start(StartContext context) throws StartException {
  }

  @Override
  public void stop(StopContext context) {
  }

  public static ServiceName createServiceName(String suffix) {
    return ServiceName.JBOSS.append("calendar", suffix);
  }
}
