package org.bedework.calendar.subsystem.extension;

import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.operations.common.GenericSubsystemDescribeHandler;
import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.as.controller.registry.OperationEntry;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.DESCRIBE;

/**
 * @author <a href="tcerar@redhat.com">Tomaz Cerar</a>
 */
public class CalendarSubsystemDefinition extends SimpleResourceDefinition {

    public static final CalendarSubsystemDefinition INSTANCE = new CalendarSubsystemDefinition();

    private CalendarSubsystemDefinition() {
        super(CalendarExtension.SUBSYSTEM_PATH,
              CalendarExtension.getResourceDescriptionResolver(null),
                //We always need to add an 'add' operation
                SubsystemAdd.INSTANCE,
                //Every resource that is added, normally needs a remove operation
                SubsystemRemove.INSTANCE);
    }

    @Override
    public void registerOperations(final ManagementResourceRegistration resourceRegistration) {
        super.registerOperations(resourceRegistration);
        //We always need to add a 'describe' operation
        resourceRegistration.registerOperationHandler(DESCRIBE, GenericSubsystemDescribeHandler.INSTANCE, GenericSubsystemDescribeHandler.INSTANCE, false, OperationEntry.EntryType.PRIVATE);
    }
}
