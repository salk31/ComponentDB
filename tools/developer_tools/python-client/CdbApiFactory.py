#!/bin/python3

# Copyright (c) UChicago Argonne, LLC. All rights reserved.
# See LICENSE file.
import base64
import os

from cdbApi import ApiException, DomainApi, FileUploadObject
from cdbApi.api.item_api import ItemApi
from cdbApi.api.downloads_api import DownloadsApi
from cdbApi.api.property_api import PropertyApi
from cdbApi.api.users_api import UsersApi
from cdbApi.api.source_api import SourceApi
from cdbApi.api.cable_catalog_item_api import CableCatalogItemApi
from cdbApi.api_client import ApiClient
from cdbApi.api.authentication_api import AuthenticationApi
from cdbApi.configuration import Configuration


class CdbApiFactory:

	HEADER_TOKEN_KEY = "token"

	def __init__(self, cdbUrl):
		self.config = Configuration(host=cdbUrl)
		self.apiClient = ApiClient(configuration=self.config)
		self.itemApi = ItemApi(api_client=self.apiClient)
		self.downloadsApi = DownloadsApi(api_client=self.apiClient)
		self.propertyApi = PropertyApi(api_client=self.apiClient)
		self.usersApi = UsersApi(api_client=self.apiClient)
		self.domainApi = DomainApi(api_client=self.apiClient)
		self.sourceApi = SourceApi(api_client=self.apiClient)
		self.cableCatalogItemApi = CableCatalogItemApi(api_client=self.apiClient)

		self.authApi = AuthenticationApi(api_client=self.apiClient)

	def getItemApi(self):
		return self.itemApi

	def getDomainApi(self):
		return self.domainApi

	def getDownloadApi(self):
		return self.downloadsApi

	def getPropertyApi(self):
		return self.propertyApi

	def getUsersApi(self):
		return self.usersApi

	def getSourceApi(self):
		return self.sourceApi

	def getCableCatalogItemApi(self):
		return self.cableCatalogItemApi

	def authenticateUser(self, username, password):
		response = self.authApi.authenticate_user_with_http_info(username=username, password=password)

		token = response[-1][self.HEADER_TOKEN_KEY]
		self.apiClient.set_default_header(self.HEADER_TOKEN_KEY, token)

	def testAuthenticated(self):
		self.authApi.verify_authenticated()

	def logOutUser(self):
		self.authApi.log_out()

	@classmethod
	def createFileUploadObject(cls, filePath):
		data = open(filePath, "rb").read()
		b64String = base64.b64encode(data).decode()

		fileName = os.path.basename(filePath)
		return FileUploadObject(file_name=fileName, base64_binary=b64String)

if __name__ == '__main__':
	# Example
	apiFactory = CdbApiFactory("https://cdb-dev.aps.anl.gov/cdb_dev")
	itemApi = apiFactory.getItemApi()

	catalogItems = itemApi.get_catalog_items()
	catalogItem = catalogItems[0]

	# Lists of items seem to be lists of dict items
	catalogId = catalogItem.get('id')

	# Single items seem to be appropriate type
	catalogFetchedById = itemApi.get_item_by_id(catalogId)
	print(catalogFetchedById.name)

	inventoryItemPerCatalog = itemApi.get_items_derived_from_item_by_item_id(catalogId)
	print(inventoryItemPerCatalog)

	print("\n\n\nWould you like to test authentication? (y/N): ")
	resp = input()
	if resp == 'y' or resp == "Y":
		import getpass
		print("Username: ")
		username = input()
		print("Password: ")
		password = getpass.getpass()

		try:
			apiFactory.authenticateUser(username, password)
			apiFactory.testAuthenticated()
			apiFactory.logOutUser()
		except ApiException:
			print("Authentication failed!")
			exit(1)

		print("Success!")
