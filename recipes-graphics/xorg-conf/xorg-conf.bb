DESCRIPTION = "Xorg configuration for Pi Cube"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://xorg.conf"

do_install() {
    install -d ${D}${sysconfdir}/X11
    install -m 0644 ${WORKDIR}/xorg.conf ${D}${sysconfdir}/X11/xorg.conf
}

FILES:${PN} += "${sysconfdir}/X11/xorg.conf"