function divLogoutOnClick() {
	SeguridadDWR.logout(
		{
			callback: function(data) {
				window.location = "/ClaroWEB/";
			}, async: false
		}
	);
}