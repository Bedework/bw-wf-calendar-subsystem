package org.bedework.calendar.subsystem.extension;

import static org.bedework.calendar.subsystem.extension.TypeDefinition.TICK;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.ADD;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.DEFAULT;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.DESCRIPTION;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.OPERATION_NAME;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.REQUEST_PROPERTIES;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.REQUIRED;
import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.TYPE;

import java.util.List;
import java.util.Locale;

import org.jboss.as.controller.AbstractAddStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.PathAddress;
import org.jboss.as.controller.ServiceVerificationHandler;
import org.jboss.as.controller.descriptions.DescriptionProvider;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceController.Mode;
import org.jboss.msc.service.ServiceName;

/**
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 */
class TypeAdd extends AbstractAddStepHandler {

    public static final TypeAdd INSTANCE = new TypeAdd();

    private TypeAdd() {
    }

   
    @Override
    protected void populateModel(ModelNode operation, ModelNode model) throws OperationFailedException {
        TICK.validateAndSet(operation,model);
    }

    @Override
    protected void performRuntime(OperationContext context,
                                  ModelNode operation,
                                  ModelNode model)
            throws OperationFailedException {
        final String suffix = PathAddress.pathAddress(
                operation.get(ModelDescriptionConstants.ADDRESS)).getLastElement().getValue();

        CalendarService service = new CalendarService();
        ServiceName name = CalendarService.createServiceName(suffix);
        ServiceController<CalendarService> controller =
                context.getServiceTarget()
                .addService(name, service)
                .addListener(verificationHandler)
                .setInitialMode(Mode.ACTIVE)
                .install();
        newControllers.add(controller);
    }
}
