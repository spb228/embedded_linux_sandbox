DESCRIPTION = "A friendly program that prints Hello World!" 
PRIORITY = "optional" 
SECTION = "examples" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  HelloWorld recipe                          *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

SRC_URI = "file://helloworld.c" 

RDEPENDS:${PN} += "glib-2.0"

S = "${WORKDIR}"
 
do_compile() { 
	${CC} ${CFLAGS} ${LDFLAGS} helloworld.c -o helloworld
} 

do_install() { 
	install -d ${D}${bindir} 
	install -m 0755 helloworld ${D}${bindir} 
}

