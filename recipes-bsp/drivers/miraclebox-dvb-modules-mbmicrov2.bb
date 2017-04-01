SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20170313"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "eb81c85a241987db5ac035f78dba8bb8"
SRC_URI[sha256sum] = "53f243f87bba0464fb6bf9886d5b66566ce8dd20d9d58e3bcca360da723ec2b4"

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
