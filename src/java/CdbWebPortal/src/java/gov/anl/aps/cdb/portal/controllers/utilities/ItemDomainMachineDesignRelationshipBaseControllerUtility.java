/*
 * Copyright (c) UChicago Argonne, LLC. All rights reserved.
 * See LICENSE file.
 */
package gov.anl.aps.cdb.portal.controllers.utilities;

import gov.anl.aps.cdb.common.exceptions.InvalidArgument;
import gov.anl.aps.cdb.portal.constants.ItemElementRelationshipTypeNames;
import gov.anl.aps.cdb.portal.model.db.beans.RelationshipTypeFacade;
import gov.anl.aps.cdb.portal.model.db.entities.EntityType;
import gov.anl.aps.cdb.portal.model.db.entities.ItemDomainMachineDesign;
import gov.anl.aps.cdb.portal.model.db.entities.ItemElementRelationship;
import gov.anl.aps.cdb.portal.model.db.entities.RelationshipType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darek
 */
public abstract class ItemDomainMachineDesignRelationshipBaseControllerUtility extends ItemDomainMachineDesignBaseControllerUtility {

    private RelationshipTypeFacade relationshipTypeFacade;

    public abstract ItemElementRelationshipTypeNames getRelationshipTypeName();

    public ItemDomainMachineDesignRelationshipBaseControllerUtility() {
        relationshipTypeFacade = RelationshipTypeFacade.getInstance();
    }

    public ItemElementRelationship applyRelationship(ItemDomainMachineDesign relatedElement, ItemDomainMachineDesign relatingElement) throws InvalidArgument {
        // Verify the controlled node is not assigned to any entity type. Only standard machine design supported. 
        boolean failedControlledNodeTypeCheck = true;
        if (relatedElement instanceof ItemDomainMachineDesign) {
            List<EntityType> controlledEntityTypeList = relatedElement.getEntityTypeList();
            if (controlledEntityTypeList.isEmpty()) {
                failedControlledNodeTypeCheck = false;
            }
        }
        if (failedControlledNodeTypeCheck) {
            throw new InvalidArgument("Only standard machine designs with no entity type can be controlled.");
        }

        // Verify the controlling node is associated with the control hierarchy.
        ItemDomainMachineDesign controllingControlTypeItem = relatingElement;
        ItemElementRelationshipTypeNames relationshipTypeName = getRelationshipTypeName();
        String relationshipName = relationshipTypeName.getValue();
        int relationshipId = relationshipTypeName.getDbId();

        while (controllingControlTypeItem != null) {
            if (ItemDomainMachineDesign.isItemControl(controllingControlTypeItem)) {
                break;
            }
            
            Integer itemId = controllingControlTypeItem.getId();
            List<ItemDomainMachineDesign> controllingParents = itemFacade.fetchRelationshipParentItems(itemId, relationshipId);

            if (controllingParents.size() > 1) {
                throw new InvalidArgument("Invalid data. Item is controlled by multiple items.");
            } else if (controllingParents.size() == 1) {
                controllingControlTypeItem = controllingParents.get(0);
                continue;
            }

            controllingControlTypeItem = null;
        }

        if (controllingControlTypeItem == null) {
            throw new InvalidArgument("Controlling element provided is not associated with the machine control hierarchy.");
        }

        RelationshipType templateRelationship
                = relationshipTypeFacade.findByName(relationshipName);

        List<ItemDomainMachineDesign> machineItems = itemFacade.fetchRelationshipParentItems(relatedElement.getId(), relationshipId); 

        switch (machineItems.size()) {
            case 0:
                // Perfect to proceed
                break;
            case 1:
                ItemDomainMachineDesign relatedItem = machineItems.get(0);
                String name = relatedItem.getName();
                if (relatedItem.equals(relatingElement)) {
                    throw new InvalidArgument("Relationship with " + name + " already exists");
                }
                throw new InvalidArgument("The item is already related by: " + name);
            default:
                throw new InvalidArgument("The item already has relationship defined");
        }

        // Todo check if a relationship already exists.
        // Create item element relationship between the template and the clone 
        ItemElementRelationship itemElementRelationship = new ItemElementRelationship();
        itemElementRelationship.setRelationshipType(templateRelationship);
        itemElementRelationship.setFirstItemElement(relatedElement.getSelfElement());
        itemElementRelationship.setSecondItemElement(relatingElement.getSelfElement());

        relatedElement.getItemElementRelationshipList().add(itemElementRelationship);
        relatingElement.getItemElementRelationshipList1().add(itemElementRelationship);

        return itemElementRelationship;
    }

}