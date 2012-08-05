/******************************************************************************
 *
 * 共通系js
 *
 *****************************************************************************/
var UserInfo = function(userId, userName, pref, tel) {
	this.userId 	= userId;
	this.userName 	= userName;
	this.pref		= pref;
	this.tel		= tel;
};

function initDlgOption() {
	var option = '';

	option += 'resizable=no';
	option += ';scroll=no';
	option += ';status=no';

	return option;
}

function popupModal(url, width, height) {
	var option = initDlgOption();

	option += ';dialogWidth=' + width + 'px;'
				+ 'dialogHeight=' + height + 'px';
	var returnValue = window.showModalDialog(url, window, option);

	return returnValue;
}

