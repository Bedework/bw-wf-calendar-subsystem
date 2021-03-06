package org.bedework.calendar.subsystem.extension;

import org.bedework.calendar.subsystem.extension.CalendarService;

import org.jboss.as.controller.AbstractRemoveStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.PathAddress;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.msc.service.ServiceName;

/**
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
class TypeRemove extends AbstractRemoveStepHandler{

    public static final TypeRemove INSTANCE = new TypeRemove();

    private TypeRemove() {
    }

    @Override
    protected void performRuntime(OperationContext context,
                                  ModelNode operation,
                                  ModelNode model) throws OperationFailedException {
        String suffix = PathAddress.pathAddress(operation.get(ModelDescriptionConstants.ADDRESS)).getLastElement().getValue();
        ServiceName name = CalendarService.createServiceName(suffix);
        context.removeService(name);
    }

}
