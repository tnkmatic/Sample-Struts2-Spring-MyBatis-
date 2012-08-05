<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/script.js"></script>

<script type="text/javascript">
function openUserPopup(editMode, userId) {
	/******************************************************************************
	 * 編集モードを意識してポップアップURLを組み立て
	 ******************************************************************************/
	var url = null;
	url = '${pageContext.request.contextPath}/trial/userdialog';
	url = url + '?' +  'editMode' + '=' + editMode;

	if (editMode == 2) {
		url = url + '&' + 'userId' + '=' + userId;
	}

	/******************************************************************************
	 * 編集用ポップアップの表示
	 ******************************************************************************/
	popupModal(url, 280, 260);

	/******************************************************************************
	 * 登録のリクエスト発行
	 ******************************************************************************/
	var eUserEditForm = document.getElementById("userEditForm");
	document.getElementById("hEditMode").value = editMode;
	eUserEditForm.submit();
}
</script>

<%-- 画面全体レイアウト用 --%>
<table class="pageLayout">

<%-- 更新系ボタン部 --%>
<tr><td width="100%" height="30" valign="top">

<div id="top" class="pageTop">
<span class="button">
	<input type="button" class="button"
		value="新規登録" onclick="openUserPopup(1)" />
</span>
<span class="button">
	<input type="button" class="button"
		value="削除"
		onclick="popupModal('${pageContext.request.contextPath}/trial/userdialog);" />
</span>
</div>

</td></tr>

<%-- 検索条件部 --%>
<tr><td width="100%">
<div id="condition">
<s:form method="get">

<%-- 検索条件部のレイアウト --%>
<table>
<tr><td width="100%" class="formItemLayout">
	<table><tr>
	<td width="60" align="right">
		<span class="itemLabel">ID：</span></td>
	<td width="120">
		<s:textfield id="userId" name="userId" label="ユーザID"
			maxlength="3" size="2"/></td>
	<td width="80" align="right">
		<span class="itemLabel">氏名：</span></td>
	<td>
		<s:textfield id="userName" name="userName" label="ユーザ名"
			size="10"/></td>
	</tr></table>
</td></tr>
<tr><td width="100%" class="formItemLayout">
	<table><tr>
	<td width="60" align="right">
		<span class="itemLabel">出身地：</span></td>
	<td width="120">
		<s:textfield id="pref" name="pref" label="出身地" size="10"/></td>
	<td width="80" align="right">
		<span class="itemLabel">電話番号：</span></td>
	<td>
		<s:textfield id="telNumber" name="telNumber" label="電話番号" size="10"/></td>
	<td>
		<span class="button">
			<s:submit cssClass="button" value="検索" action="userlist" />
		</span></td>
	</tr></table>
</td></tr>
</table>

</s:form>
</div>

</td></tr>

<%-- 結果表示部 --%>
<tr><td width="100%">
<div id="list">
<table class="resultLayout">
<caption>
検索結果：　<strong class="charRed"><s:property value="userCount"/></strong>　人
</caption>
<colgroup>
	<col width="5"   align="center" />
	<col width="50"  align="center" />
	<col width="100" align="left" />
	<col width="80"  align="left" />
	<col width="80"  align="center" />
	<col width="60"  align="center" />
</colgroup>

<tr>
	<th align="center"></th>
	<th align="center">ID</th>
	<th align="center">氏名</th>
	<th align="center">出身地</th>
	<th align="center">電話番号</th>
	<th align="center">更新</th>
</tr>



<s:iterator value="userList" >

<tr>
	<td class="list_c"><input type="checkbox" />
	<td class="list_c"><s:property value="userId"/></td>
	<td class="list_l"><s:property value="userName"/></td>
	<td class="list_l"><s:property value="pref"/></td>
	<td class="list_c"><s:property value="telNumber"/></td>
	<td class="list_c"><input type="button" value="編集"
			onclick="openUserPopup(2, <s:property value="userId"/>);"/></td>
</tr>

</s:iterator>
</table>

</div>
</td></tr>

</table>

<%-- 編集ポップアップの入力受取用 --%>
<s:form id="userEditForm" method="get" action="useredit">
	<s:hidden id="hEditMode" name="editMode" />
	<s:hidden id="hUserId" name="userId" />
	<s:hidden id="hUserName" name="userName" />
	<s:hidden id="hPref" name="pref" />
	<s:hidden id="hTelNumber" name="telNumber" />
</s:form>