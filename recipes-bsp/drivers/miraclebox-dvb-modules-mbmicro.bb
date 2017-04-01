SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20170313"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "3bb30d6f40c3a09c8811b9678fb6dd6d"
SRC_URI[sha256sum] = "abaffc81a28527b6cdfca3c1c48eee02dd2e34900138da64209168668b39c54b"

#SRC_URI = "file://ceryon-7000s-dvbdrive-${SRCDATE}.zip"
SRC_URI = "http://source.mynonpublic.com/ceryon/ceryon-7000s-dvbdrive-${SRCDATE}.zip"

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
