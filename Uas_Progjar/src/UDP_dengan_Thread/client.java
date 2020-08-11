package UDP_dengan_Thread;

import java.io.*;
import java.net.*;

/**
 *
 * @author Aspire 5
 */
public class client {

    public static void main(String[] args) throws Exception {
        byte[] bit = new byte[4096000];
        Socket sr = new Socket("localhost", 6777);
        InputStream is = sr.getInputStream();
        FileOutputStream fr = new FileOutputStream("D:/UAS_PROGJAR/MICHEL~2.mp3");
        is.read(bit, 0,bit.length);
        System.out.println("Proses Transfer");
        Thread.sleep(6000);
        fr.write(bit, 0, bit.length);
        System.out.println("Transfer Sucssesfull");

    }
}
