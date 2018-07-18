#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
This is README file with help about notification templates.

In XML document is every one element - "template" that contain notification template.

Name for file may be short description of template.

Some properties can be found on application.properties

Attributes:
	NAME			|	REQUIRED	|	DESCRIPTION
_____________________________________________________________________________________________________________________
	name			|	true		|	name of template, user friendly name for this template
	code			|	true		|	unique code that identify this template
	subject 		|	true		|	subject of email, text message and etc., in subject can be used velocity macro
	bodyHtml		|	true		|	message body with html and etc.. Use ADATA syntax for html
	bodyText		|	true		|	message body for text message and etc.
	parameter		|	true		|	list of parameters for message. Split by ','
	systemTemplate	|	true		|	flag if this template is system, if you want to add some non system templates use, rest or FE form.
	moduleId		|	true		|	Module ID information propagate to FE

EXAMPLE:
_____________________________________________________________________________________________________________________
<?xml version = "1.0" encoding = "UTF-8" standalone = "yes"?>
<!-- 
Some info about template...
...
...
parametes description...
...
 -->
<template>
	<code>provisioningSuccess</code>
	<subject>Proběhl provisioning účtu ${symbol_dollar}name</subject>
	<bodyHtml>Provisioning účtu ${symbol_dollar}name na systém ${symbol_dollar}system úspěšně proběhl.</bodyHtml>
	<bodyText>Provisioning uctu ${symbol_dollar}name na system ${symbol_dollar}system uspesne probehl.</bodyText>
	<parameter>name, system, operationType, objectClass</parameter>
	<systemTemplate>true</systemTemplate>
	<moduleId>core</moduleId>
</template>
_____________________________________________________________________________________________________________________


Velocity macros: 
http://velocity.apache.org/engine/1.7/user-guide.html