DESCRIPTION = "Default brightness state file for Pi Cube"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://brightness.state"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/brightness.state ${D}${sysconfdir}/brightness.state
}

FILES:${PN} += "${sysconfdir}/brightness.state"