SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20170502"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "79de31d98919908d767374c9c5ede7b1"
SRC_URI[sha256sum] = "7bcb54df13dbee45ac9974a1331af1177a969c58b2703c1a25a29453551d1020"

SRC_URI = "http://source.mynonpublic.com/ceryon/ceryon-7005s-dvbdrive-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    echo "dvbdrive" >> ${D}/${sysconfdir}/modules-load.d/dvbdrive.conf
    install -m 0755 ${WORKDIR}/dvbdrive.ko ${D}/lib/modules/${KV}/extra
    install -d ${D}/etc/rcS.d
}

FILES_${PN} += "${sysconfdir}/modules-load.d/dvbdrive.conf"
