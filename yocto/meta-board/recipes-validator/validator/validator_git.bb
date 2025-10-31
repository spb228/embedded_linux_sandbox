# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/containers/validator.git;protocol=https;branch=master"

# Modify these as desired
PV = "0.2.2+git"
SRCREV = "92d1b85f93d2f3b3fe801d36f0d93608b4b099ac"

S = "${WORKDIR}/git"

# NOTE: the following prog dependencies are unknown, ignoring: go-md2man
# NOTE: unable to map the following pkg-config dependencies: glib-2.0
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "openssl"
DEPENDS += "glib-2.0 openssl"
RDEPENDS:${PN} += "glib-2.0"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES:${PN} += "${datadir}"
do_install:append() {
    rm -rf ${D}/usr/lib/dracut
}
