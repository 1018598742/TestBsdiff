package test;

public class TestBsdiff {

    public native static int diff(String oldFile, String newFile, String patchch);

    public native static int add(int a, int b);

    static {
        String absolutePath = System.getProperty("user.dir") + "/lib/libapp_bsdiff.so";
        System.load(absolutePath);
        System.out.println("loading C libary ");
    }

    public static void main(String args[]) {
        int sum = 0;
        sum = TestBsdiff.add(1, 2);
        System.out.print(sum);
    }

}
