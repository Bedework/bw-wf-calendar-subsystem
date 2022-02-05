package org.bedework.calendar.subsystem.extension;

import org.jboss.as.controller.AbstractBoottimeAddStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.ServiceVerificationHandler;
import org.jboss.dmr.ModelNode;
import org.jboss.logging.Logger;
import org.jboss.msc.service.ServiceController;

import java.util.List;

/**
 * Handler responsible for adding the subsystem resource to the model
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
class SubsystemAdd extends AbstractBoottimeAddStepHandler {

  static final SubsystemAdd INSTANCE = new SubsystemAdd();

  private final Logger log = Logger.getLogger(SubsystemAdd.class);

  private SubsystemAdd() {
  }

  @Override
  protected void populateModel(final ModelNode operation,
                               final ModelNode model) {

  }

  @Override
  public void performBoottime(final OperationContext context,
                              final ModelNode operation,
                              final ModelNode model,
                              final ServiceVerificationHandler verificationHandler, final List<ServiceController<?>> newControllers) {

    //Add deployment processors here
    //Remove this if you don't need to hook into the deployers, or you can add as many as you like
    //see SubDeploymentProcessor for explanation of the phases
  }
}
