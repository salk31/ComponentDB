from cdbSeleniumModules.cdbSeleniumModuleBase import CdbSeleniumModuleBase


class Source(CdbSeleniumModuleBase):

    VIEW_BASE_NAME = 'source'
    ENTITY_TYPE_NAME = 'source'
    COLUMN_IDX = 1
    FORM_NAME = "viewSource%sForm"
    LIST_FORM_NAME = FORM_NAME % 'List'
    VIEW_FORM_NAME = FORM_NAME % ''
    EDIT_FORM_NAME = 'editSourceForm'

    def navigate_to_source_list(self):
        self._navigate_to_dropdown('administrativeButton', 'adminSourcesButton', '%s/list' % self.VIEW_BASE_NAME)

    def test_source_pages(self):
        dataTableXpathFormula = '//*[@id="%s:%sListDataTable_data"]/tr[1]/td[%d]/a'
        self._click_on_xpath(dataTableXpathFormula % (self.LIST_FORM_NAME, self.ENTITY_TYPE_NAME, self.COLUMN_IDX))
        self._wait_for_url_contains('%s/view' % self.VIEW_BASE_NAME)

        self._click_on_id('%s:%sViewEditButton' % (self.VIEW_FORM_NAME, self.ENTITY_TYPE_NAME))
        self._wait_for_url_contains('%s/edit' % self.VIEW_BASE_NAME)

        self._click_on_id('%s:%sEditViewButton' % (self.EDIT_FORM_NAME, self.ENTITY_TYPE_NAME))
        self._wait_for_url_contains('%s/view' % self.VIEW_BASE_NAME)