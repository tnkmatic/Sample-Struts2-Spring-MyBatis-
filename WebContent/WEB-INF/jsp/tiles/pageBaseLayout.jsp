<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css"
	media="all" />

<%-- ページタイトル --%>
<title>
<t:insertAttribute name="pageTitle" ignore="true" />
</title>

</head>

<body class="application">

<%-- 全体レイアウト用 --%>
<table cellpadding="4" cellspacing="4" >

	<%-- ヘッダー部 --%>
	<tr><td align="center" height="30" colspan="2">
	<t:insertAttribute name="pageHeader" />
	</td></tr>

	<tr>
	<%-- メニュー部 --%>
	<td width="120" valign="top" align="left" height="100%">
	<t:insertAttribute name="pageMenu" />
	</td>
	<%-- ボディ部 --%>
	<td align="left" height="100%">
	<t:insertAttribute name="pageBody" />
	</td>
	</tr>

	<%-- フッター部 --%>
	<tr align="center">
	<td height="30" colspan="2">
	<t:insertAttribute name="pageFotter" />
	</td>
	</tr>

</table>

</body>
</html>