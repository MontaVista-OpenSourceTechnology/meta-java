SUMMARY = "SSH implementation in Java"
HOMEPAGE = "http://www.jcraft.com/jsch"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=55e3b6a0987ccd0c34530f3df2d206ae"

SRC_URI = "${SOURCEFORGE_MIRROR}/jsch/jsch-${PV}.zip"

inherit java-library

DEPENDS = "jzlib"

RDEPENDS:${PN} = "libjzlib-java"
RDEPENDS:${PN}:class-native = ""

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s jzlib

  javac -sourcepath src -cp $cp -d build `find src -name "*.java"`

  fastjar cf ${JARFILENAME} -C build .
}

SRC_URI[sha256sum] = "ca9d2ae08fd7a8983fb00d04f0f0c216a985218a5eb364ff9bee73870f28e097"

CVE_STATUS[CVE-2016-5725] = "not-applicable-platform: Issue only applies on Windows"

BBCLASSEXTEND = "native"

