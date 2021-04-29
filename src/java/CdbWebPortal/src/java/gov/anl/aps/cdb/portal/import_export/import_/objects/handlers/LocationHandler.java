/*
 * Copyright (c) UChicago Argonne, LLC. All rights reserved.
 * See LICENSE file.
 */
package gov.anl.aps.cdb.portal.import_export.import_.objects.handlers;

import gov.anl.aps.cdb.portal.controllers.ItemDomainLocationController;
import gov.anl.aps.cdb.portal.import_export.import_.objects.MachineImportCommon;
import gov.anl.aps.cdb.portal.import_export.import_.objects.ValidInfo;
import gov.anl.aps.cdb.portal.model.db.entities.CdbEntity;
import gov.anl.aps.cdb.portal.model.db.entities.ItemDomainLocation;
import gov.anl.aps.cdb.portal.model.db.entities.ItemDomainMachineDesign;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author craig
 */
/**
 * Using a custom handler for location so we can ignore the word "parent" in a
 * column that otherwise expects location item id's. We could use the standard
 * IdRef handler if we didn't need to worry about "parent".
 */
public class LocationHandler extends SingleColumnInputHandler {

    public LocationHandler() {
        super(MachineImportCommon.HEADER_LOCATION);
    }

    @Override
    public ValidInfo handleInput(
            Row row,
            Map<Integer, String> cellValueMap,
            Map<String, Object> rowMap) {

        boolean isValid = true;
        String validString = "";

        String parsedValue = cellValueMap.get(getColumnIndex());

        ItemDomainLocation itemLocation = null;
        if ((parsedValue != null) && (!parsedValue.isEmpty())) {
            // location is specified

            // ignore word "parent"
            if (!parsedValue.equalsIgnoreCase("parent")) {
                int id;
                try {
                    id = Integer.valueOf(parsedValue);
                    itemLocation = ItemDomainLocationController.getInstance().findById(id);
                    if (itemLocation == null) {
                        String msg = "Unable to find object for: " + getColumnName()
                                + " with id: " + parsedValue;
                        isValid = false;
                        validString = msg;

                    } else {
                        // set location
                        rowMap.put(MachineImportCommon.KEY_LOCATION, itemLocation);
                    }

                } catch (NumberFormatException ex) {
                    String msg = "Invalid id number: " + parsedValue + " for column: " + getColumnName();
                    isValid = false;
                    validString = msg;
                }
            }
        }

        return new ValidInfo(isValid, validString);
    }


    @Override
    public ValidInfo updateEntity(Map<String, Object> rowMap, CdbEntity entity) {
        
        boolean isValid = true;
        String validString = "";
        
        ItemDomainMachineDesign item = null;
        if (!(entity instanceof ItemDomainMachineDesign)) {
            isValid = false;
            validString = "Item must be ItemDomainMachineDesign to use LocationHandler.";
            return new ValidInfo(isValid, validString);
        } else {
            item = (ItemDomainMachineDesign) entity;
        }
                
        // set location
        ItemDomainLocation itemLocation = (ItemDomainLocation) rowMap.get(MachineImportCommon.KEY_LOCATION);
        if (itemLocation != null) {
            item.setImportLocationItem(itemLocation);
        }

        if ((item.getIsItemTemplate()) && (item.getImportLocationItem() != null)) {
            // template not allowed to have location
            isValid = false;
            validString = "Template cannot have location item.";
            return new ValidInfo(isValid, validString);
        }
        
        return new ValidInfo(isValid, validString);
    }

}