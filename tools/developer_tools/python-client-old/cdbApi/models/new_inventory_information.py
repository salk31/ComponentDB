# coding: utf-8

"""
    Component Database API

    The API that provides access to Component Database data.  # noqa: E501

    The version of the OpenAPI document: 3.12.3
    Contact: djarosz@anl.gov
    Generated by: https://openapi-generator.tech
"""


import pprint
import re  # noqa: F401

import six

from cdbApi.configuration import Configuration


class NewInventoryInformation(object):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.
    """

    """
    Attributes:
      openapi_types (dict): The key is attribute name
                            and the value is attribute type.
      attribute_map (dict): The key is attribute name
                            and the value is json key in definition.
    """
    openapi_types = {
        'catalog_id': 'int',
        'tag': 'str',
        'serial_number': 'str',
        'description': 'str',
        'qr_id': 'int'
    }

    attribute_map = {
        'catalog_id': 'catalogId',
        'tag': 'tag',
        'serial_number': 'serialNumber',
        'description': 'description',
        'qr_id': 'qrId'
    }

    def __init__(self, catalog_id=None, tag=None, serial_number=None, description=None, qr_id=None, local_vars_configuration=None):  # noqa: E501
        """NewInventoryInformation - a model defined in OpenAPI"""  # noqa: E501
        if local_vars_configuration is None:
            local_vars_configuration = Configuration()
        self.local_vars_configuration = local_vars_configuration

        self._catalog_id = None
        self._tag = None
        self._serial_number = None
        self._description = None
        self._qr_id = None
        self.discriminator = None

        if catalog_id is not None:
            self.catalog_id = catalog_id
        if tag is not None:
            self.tag = tag
        if serial_number is not None:
            self.serial_number = serial_number
        if description is not None:
            self.description = description
        if qr_id is not None:
            self.qr_id = qr_id

    @property
    def catalog_id(self):
        """Gets the catalog_id of this NewInventoryInformation.  # noqa: E501


        :return: The catalog_id of this NewInventoryInformation.  # noqa: E501
        :rtype: int
        """
        return self._catalog_id

    @catalog_id.setter
    def catalog_id(self, catalog_id):
        """Sets the catalog_id of this NewInventoryInformation.


        :param catalog_id: The catalog_id of this NewInventoryInformation.  # noqa: E501
        :type: int
        """

        self._catalog_id = catalog_id

    @property
    def tag(self):
        """Gets the tag of this NewInventoryInformation.  # noqa: E501


        :return: The tag of this NewInventoryInformation.  # noqa: E501
        :rtype: str
        """
        return self._tag

    @tag.setter
    def tag(self, tag):
        """Sets the tag of this NewInventoryInformation.


        :param tag: The tag of this NewInventoryInformation.  # noqa: E501
        :type: str
        """

        self._tag = tag

    @property
    def serial_number(self):
        """Gets the serial_number of this NewInventoryInformation.  # noqa: E501


        :return: The serial_number of this NewInventoryInformation.  # noqa: E501
        :rtype: str
        """
        return self._serial_number

    @serial_number.setter
    def serial_number(self, serial_number):
        """Sets the serial_number of this NewInventoryInformation.


        :param serial_number: The serial_number of this NewInventoryInformation.  # noqa: E501
        :type: str
        """

        self._serial_number = serial_number

    @property
    def description(self):
        """Gets the description of this NewInventoryInformation.  # noqa: E501


        :return: The description of this NewInventoryInformation.  # noqa: E501
        :rtype: str
        """
        return self._description

    @description.setter
    def description(self, description):
        """Sets the description of this NewInventoryInformation.


        :param description: The description of this NewInventoryInformation.  # noqa: E501
        :type: str
        """

        self._description = description

    @property
    def qr_id(self):
        """Gets the qr_id of this NewInventoryInformation.  # noqa: E501


        :return: The qr_id of this NewInventoryInformation.  # noqa: E501
        :rtype: int
        """
        return self._qr_id

    @qr_id.setter
    def qr_id(self, qr_id):
        """Sets the qr_id of this NewInventoryInformation.


        :param qr_id: The qr_id of this NewInventoryInformation.  # noqa: E501
        :type: int
        """

        self._qr_id = qr_id

    def to_dict(self):
        """Returns the model properties as a dict"""
        result = {}

        for attr, _ in six.iteritems(self.openapi_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(map(
                    lambda item: (item[0], item[1].to_dict())
                    if hasattr(item[1], "to_dict") else item,
                    value.items()
                ))
            else:
                result[attr] = value

        return result

    def to_str(self):
        """Returns the string representation of the model"""
        return pprint.pformat(self.to_dict())

    def __repr__(self):
        """For `print` and `pprint`"""
        return self.to_str()

    def __eq__(self, other):
        """Returns true if both objects are equal"""
        if not isinstance(other, NewInventoryInformation):
            return False

        return self.to_dict() == other.to_dict()

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        if not isinstance(other, NewInventoryInformation):
            return True

        return self.to_dict() != other.to_dict()
