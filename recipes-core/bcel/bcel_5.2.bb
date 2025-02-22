SUMMARY = "Java Bytecode manipulation library"
AUTHOR = "Apache Software Foundation"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=44030f19e8bad73725f39d16fd05ff12"
PR = "r1"
SRC_URI = "http://archive.apache.org/dist/jakarta/bcel/source/${BP}-src.tar.gz"

inherit java-library

DEPENDS = "xerces-j regexp"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s xercesImpl regexp

  javac -encoding ISO-8859-1 -sourcepath src/java -d build -cp $cp `find src/java -name \*.java`

  fastjar cf ${JARFILENAME} -C build .
}

SRC_URI[sha256sum] = "68039d59a38379d7b65ea3fc72276c43ba234776460e14361af35771bcaab295"

BBCLASSEXTEND = "native"

