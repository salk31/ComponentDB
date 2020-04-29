/*
 * Copyright (c) UChicago Argonne, LLC. All rights reserved.
 * See LICENSE file.
 */
package gov.anl.aps.cdb.portal.model.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.anl.aps.cdb.portal.constants.ItemDomainName;
import gov.anl.aps.cdb.portal.controllers.ItemController;
import gov.anl.aps.cdb.portal.controllers.ItemDomainCatalogController;
import gov.anl.aps.cdb.portal.controllers.ItemDomainInventoryController;
import gov.anl.aps.cdb.portal.controllers.ItemDomainMachineDesignController;
import gov.anl.aps.cdb.portal.controllers.ItemProjectController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author djarosz
 */
@Entity
@DiscriminatorValue(value = ItemDomainName.MACHINE_DESIGN_ID + "")
public class ItemDomainMachineDesign extends LocatableItem {   
    
    private static final Logger LOGGER = LogManager.getLogger(ItemDomainMachineDesign.class.getName());

    private transient List<ItemElement> combinedItemElementList; 
    private transient ItemElement combinedItemElementListParentElement; 
    private transient ItemElement currentItemElement; 
    
    private transient String importIsTemplate = "";
    private transient ItemDomainMachineDesign importContainerItem = null;
    private transient String importPath = "";
    private transient String importAssignedCatalogItemString = "";
    private transient String importAssignedInventoryItemString = "";

    @Override
    public Item createInstance() {
        return new ItemDomainMachineDesign();
    }   

    @JsonIgnore
    public List<ItemElement> getCombinedItemElementList(ItemElement element) {
        if (combinedItemElementListParentElement != null) {
            if (!element.equals(combinedItemElementListParentElement)) {
                combinedItemElementList = null; 
            }
        } else {
            combinedItemElementList = null; 
        }
        
        if (combinedItemElementList == null) {
            combinedItemElementList = new ArrayList<>();
            combinedItemElementListParentElement = element; 
            
            Item containedItem2 = combinedItemElementListParentElement.getContainedItem2();
            if (containedItem2 != null) {
                combinedItemElementList.addAll(containedItem2.getItemElementDisplayList());
            }
            combinedItemElementList.addAll(getItemElementDisplayList()); 
        } 
        
        return combinedItemElementList;
    }
    
    /**
     * Machine Design Heirarchy ensures each item is a child of only one item. 
     * Method returns item element at which the current item is referenced. 
     * 
     * @param item
     * @return 
     */
    @JsonIgnore
    public ItemElement getCurrentItemElement() {
        if (currentItemElement == null) {
            List<ItemElement> itemElementMemberList = getItemElementMemberList();
            if (itemElementMemberList.size() > 0) {
                for (ItemElement itemElement : itemElementMemberList) {
                    Item parentItem = itemElement.getParentItem(); 
                    if (ItemDomainMachineDesignController.isItemMachineDesign(parentItem)) {
                        currentItemElement = itemElement; 
                        break; 
                    }
                }
            } else {
                currentItemElement = new ItemElement();
                currentItemElement.setContainedItem(this);
            }
        }
        
        return currentItemElement; 
    }
    
    @JsonIgnore
    public ItemDomainMachineDesign getParentMachineDesign() {
        List<ItemElement> itemElementMemberList = this.getItemElementMemberList();        
        
        if (itemElementMemberList != null) {
            for (ItemElement memberElement : itemElementMemberList) {
                Item parentItem = memberElement.getParentItem();
                if (parentItem instanceof ItemDomainMachineDesign) {
                    // Should only be one. 
                    return (ItemDomainMachineDesign) parentItem;                
                }
            }
        }
       
       return null;
    }

    @Override
    public ItemController getItemDomainController() {
        return ItemDomainMachineDesignController.getInstance();
    }

    @Override
    public String toString() {
        // Only top level machine design will get the special derived from formatting... DerivedItem - [name]
        if (this.getDerivedFromItem() != null) {
            if (this.getParentMachineDesign() != null) {
                return this.getName();
            }
        }
        
        return super.toString();
    }

    public String getImportIsTemplate() {
        return importIsTemplate;
    }

    public void setImportIsTemplate(String importIsTemplate) {
        this.importIsTemplate = importIsTemplate;
    }
    
    public ItemDomainMachineDesign getImportContainerItem() {
        return importContainerItem;
    }

    public String getImportContainerString() {
        ItemDomainMachineDesign itemContainer = this.getImportContainerItem();
        if (itemContainer != null) {
            return itemContainer.getName();
        } else {
            return "";
        }
    }
    
    public void setImportContainerItem(ItemDomainMachineDesign item) {
        importContainerItem = item;
    }

    public void setImportContainerItemId(String id) {
        ItemDomainMachineDesign itemContainer = (ItemDomainMachineDesign)(getEntityById(ItemDomainMachineDesignController.getInstance(), id));
        if (itemContainer != null) {
            setImportContainerItem(itemContainer);
        } else {
            LOGGER.error("setImportContainerItemId() unknown machine design item id " + id);
        }
    }

    public String getImportPath() {
        return importPath;
    }

    public void setImportPath(String importPath) {
        this.importPath = importPath;
    }

    public String getAlternateName() {
        return getItemIdentifier1();
    }

    public void setAlternateName(String n) {
        setItemIdentifier1(n);
    }

    public void setAssignedItem(Item item) {
        // "assign" catalog or inventory item
        ItemElement selfElement = this.getSelfElement();
        selfElement.setContainedItem2(item);
    }

    public Item getAssignedItem() {
        ItemElement selfElement = this.getSelfElement();
        return selfElement.getContainedItem2();
    }

    public String getAssignedItemString() {
        Item assignedItem = this.getAssignedItem();
        if (assignedItem != null) {
            return assignedItem.getName();
        } else {
            return "";
        }
    }

    public void setAssignedCatalogItemId(String itemId) {
        Item item = (Item) (getEntityById(ItemDomainCatalogController.getInstance(), itemId));

        if (item != null) {
            setAssignedItem(item);
            setImportAssignedCatalogItemString(item.getName());
        } else {
            LOGGER.error("setAssignedItemId() unknown assigned catalog item id " + itemId);
        }
     }

    public void setAssignedInventoryItemId(String itemId) {
        Item item = (Item) (getEntityById(ItemDomainInventoryController.getInstance(), itemId));

        if (item != null) {
            setAssignedItem(item);
            setImportAssignedInventoryItemString(item.getName());
        } else {
            LOGGER.error("setAssignedItemId() unknown assigned inventory item id " + itemId);
        }
     }

    public String getImportAssignedCatalogItemString() {
        return importAssignedCatalogItemString;
    }

    public void setImportAssignedCatalogItemString(String importAssignedCatalogItemString) {
        this.importAssignedCatalogItemString = importAssignedCatalogItemString;
    }

    public String getImportAssignedInventoryItemString() {
        return importAssignedInventoryItemString;
    }

    public void setImportAssignedInventoryItemString(String importAssignedInventoryItemString) {
        this.importAssignedInventoryItemString = importAssignedInventoryItemString;
    }
    
    public void setProjectId(String projectId) {
        ItemProject project = (ItemProject) (getEntityById(ItemProjectController.getInstance(), projectId));
        if (project != null) {
            List<ItemProject> projectList = new ArrayList<>();
            projectList.add(project);
            this.setItemProjectList(projectList);
        }
    }
    
}
