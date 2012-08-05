<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/script.js"></script>

<script type="text/javascript">
function disableButton() {
	document.getElementById("entryButton").disabled = true;
	document.getElementById("clearButton").disabled = true;
	document.getElementById("closeButton").disabled = true;
}

function entryUser() {
	var userId 		= document.getElementById("userId").value;
	var userName 	= document.getElementById("userName").value;
	var pref		= document.getElementById("pref").value;
	var telNumber	= document.getElementById("telNumber").value;

	if (userId == '' || userId == undefined) {
		window.alert('IDは必須です。入力してください。');
		return;
	}

	disableButton();

	/******************************************************************************
	 * 値受け取り用のhidden要素の取得
	 ******************************************************************************/
	var openerUserId 	= opener.document.getElementById("hUserId");
	var openerUserName 	= opener.document.getElementById("hUserName");
	var openerPref		= opener.document.getElementById("hPref");
	var openerTel		= opener.document.getElementById("hTelNumber");

	/******************************************************************************
	 * 親ウィンドウに入力値を設定
	 ******************************************************************************/
	openerUserId.value 		= userId;
	openerUserName.value	= userName;
	openerPref.value		= pref;
	openerTel.value			= telNumber;

	returnValue = true;

	window.close();
}
</script>

<%-- 画面全体レイアウト用 --%>
<table class="pageLayout">

<tr><td>

<%-- 編集モード --%>
<s:hidden value="%{mode}" />

<%-- 検索条件部のレイアウト --%>
<table>
<tr><td width="100%" class="formItemLayout">
	<table>
	<%-- ID --%>
	<tr>
	<td width="60" align="right">
		<span class="itemLabel">ID：</span></td>
	<td width="120">
		<s:if test="%{editMode == 1}">
			<s:textfield id="userId" name="userId"
				maxlength="3" size="2" value="%{userId}"/>
		</s:if>
		<s:elseif test="%{editMode == 2}">
			<s:textfield id="userId" name="userId"
				maxlength="3" size="2" value="%{userId}" disabled="true"/>
		</s:elseif>
	</td></tr>

	<%-- 氏名 --%>
	<tr><td width="80" align="right">
		<span class="itemLabel">氏名：</span></td>
	<td><s:textfield id="userName" name="userName"
			size="10" value="%{userName}"/></td></tr>

	<%-- 出身地 --%>
	<tr>
	<td width="60" align="right">
		<span class="itemLabel">出身地：</span></td>
	<td width="120">
		<s:textfield id="pref" name="pref"
			size="10" value="%{pref}"/></td></tr>

	<%-- 電話番号 --%>
	<tr>
	<td width="80" align="right">
		<span class="itemLabel">電話番号：</span></td>
	<td>
		<s:textfield id="telNumber" name="telNumber"
			size="10" value="%{telNumber}"/></td></tr>

	<%-- ボタン群 --%>
	<tr>
	<td width="210" align="center" colspan="2" style="padding: 20px 0px 0px 0px">
	<span class="button">
	<input id="entryButton" class="smallButton" type="button"
		value="登録" onclick="entryUser();" /></span>
	<span class="button">
	<input id="clearButton" class="smallButton" type="reset"
		value="クリア"/></span>
	<span class="button">
	<input id="closeButton" class="smallButton" type="button"
		value="閉じる" onclick="window.close();" /></span></td></tr>

	</table>

</td></tr>

</table>

</td></tr>

</table>