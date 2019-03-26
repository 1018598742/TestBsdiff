```

/usr/java/jdk1.8.0_191/bin/javah -classpath /home/fta/IdeaProjects/TestBsdiff/out/production/TestBsdiff -jni -d ./jni com.fta.bsdiff.Bsdiff


javah -classpath [.class] -jni -d [save absolute path] [packagename.classname]


fta@ubuntu:~/IdeaProjects/TestBsdiff/src$ 

gcc -fPIC -I/usr/java/jdk1.8.0_191/include/ -I/usr/java/jdk1.8.0_191/include/linux/ -I/home/fta/IdeaProjects/TestBsdiff/src -shared -o libapp_bsdiff.so bzlib.c bzip2.c blocksort.c compress.c crctable.c decompress.c huffman.c randtable.c bsdiff.c



gcc -fPIC -I"JDKdir/include" -I"JDKdir/include/linux/" -I"[save path]" -shared -o [save filename] [...all .c files]

```