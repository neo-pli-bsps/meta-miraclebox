SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20161228"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "20c367e339120bc62bfeffe84f400946"
SRC_URI[sha256sum] = "3af2628b6d23398e6cee7c2b6524cfdd4ebce4fe9e6f776baea6e0975317bb2c"

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
