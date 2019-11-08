/*
 * Copyright (c) UChicago Argonne, LLC. All rights reserved.
 * See LICENSE file.
 */
package gov.anl.aps.cdb.portal.controllers.extensions;

import gov.anl.aps.cdb.portal.controllers.ItemController;
import gov.anl.aps.cdb.portal.controllers.ItemDomainCableInventoryController;
import gov.anl.aps.cdb.portal.utilities.SessionUtility;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author djarosz
 */
@Named(ItemCreateWizardDomainCableInventoryController.controllerNamed)
@SessionScoped
public class ItemCreateWizardDomainCableInventoryController extends ItemCreateWizardController implements Serializable {
    
    private final String ITEM_CREATE_WIZARD_ITEM_ELEMENT_CREATE_STEP = "reviewItemTab";
    
    public final static String controllerNamed = "itemCreateWizardDomainCableInventoryController";

    @Override
    public String getItemCreateWizardControllerNamed() {
        return controllerNamed; 
    }
    
    ItemDomainCableInventoryController itemDomainController = null; 
    
    private ItemDomainCableInventoryController getItemDomainCableInventoryController() {
        if (itemDomainController == null) {
            itemDomainController = ItemDomainCableInventoryController.getInstance(); 
        }
        return itemDomainController;         
    }
    
    @Override
    public ItemController getItemController() {
        return getItemDomainCableInventoryController(); 
    }
    
    public static ItemCreateWizardDomainCableInventoryController getInstance() {
        return (ItemCreateWizardDomainCableInventoryController) SessionUtility.findBean(controllerNamed);
    }
    
    @Override
    protected String getCreateItemWizardMenuItemValue(ItemCreateWizardSteps step) {
        switch (step) {
            case basicInformation:
                return null;
            case classification:
                return null;
            case permissions:
                return null;
            default:
                break;
        }

        return super.getCreateItemWizardMenuItemValue(step);
    }

    @Override
    public String getNextStepForCreateItemWizard(FlowEvent event) {
        if (getCurrent().getDerivedFromItem() == null) {
            SessionUtility.addWarningMessage("No Catalog Item Selected", "Please select a catalog item.");
            return ItemCreateWizardSteps.derivedFromItemSelection.getValue();
        }

        String nsEvent = event.getNewStep();

        if (nsEvent.equals(ITEM_CREATE_WIZARD_ITEM_ELEMENT_CREATE_STEP)) {
            getItemDomainCableInventoryController().setDefaultValuesForCurrentItem();
        }

        return super.getNextStepForCreateItemWizard(event);
    }
    
    @Override
    public String getLastCreateWizardStep() {
        return ITEM_CREATE_WIZARD_ITEM_ELEMENT_CREATE_STEP;
    }
            
    public boolean isAllowedSetDerivedFromItemForCurrentItem() {
        return false;
    }

}
