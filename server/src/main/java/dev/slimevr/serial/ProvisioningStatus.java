package dev.slimevr.serial;

public enum ProvisioningStatus {

	NONE,
	SERIAL_INIT,
	PROVISIONING,
	CONNECTING,
	CONNECTION_ERROR,
	LOOKING_FOR_SERVER,
	COULD_NOT_FIND_SERVER,
	DONE
}
