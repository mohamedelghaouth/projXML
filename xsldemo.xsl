<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!--xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl"-->
<xsl:template match="/">
<html>
<body>
<h1><xsl:value-of select="./nom"/></h1>
<xsl:for-each select="ecole/block">
	<h2><xsl:value-of select="nom"/></h2>
	<xsl:for-each select="./etage">
		<h1>etage <xsl:value-of select="./num"/></h1>
		<table border="1" cellspacing="0" cellpadding="3">
		<tr bgcolor="#FFFF00">
		<td>num</td>
		<td>hoccp</td>
		<td>cap</td>
		</tr>
		<xsl:for-each select="./sale">
			<tr>
			<td><xsl:value-of select="num"/></td>
			<td>
			<ul>
			<xsl:for-each select="./hoccp">
				<li><xsl:value-of select="."/></li>
			</xsl:for-each>
			</ul>
			</td>
			<td><xsl:value-of select="./cap"/></td>
			</tr>
		</xsl:for-each>
		</table>
	</xsl:for-each>
</xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
<!-- Stylus Studio meta-information - (c) 2004-2005. Progress Software Corporation. All rights reserved.
<metaInformation>
<scenarios/><MapperMetaTag><MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/><MapperBlockPosition></MapperBlockPosition><TemplateContext></TemplateContext><MapperFilter side="source"></MapperFilter></MapperMetaTag>
</metaInformation>
-->