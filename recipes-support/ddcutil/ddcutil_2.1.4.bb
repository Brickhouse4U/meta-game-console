SUMMARY = "Query and change monitor settings via DDC/CI"
HOMEPAGE = "https://www.ddcutil.com"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/rockowitz/ddcutil/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[sha256sum] = "cd8325d399399edba3df4ec58a4051c7c54fcf4fbc8f62937c6f19adb303f4ba"

S = "${WORKDIR}/ddcutil-${PV}"

inherit autotools pkgconfig

DEPENDS = "glib-2.0 libdrm udev i2c-tools jansson"

EXTRA_OECONF = "--disable-usb"

FILES:${PN} += "${bindir}/ddcutil ${nonarch_base_libdir}/modules-load.d/ddcutil.conf"