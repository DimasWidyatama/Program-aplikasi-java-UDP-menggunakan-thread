package UDP_dengan_Thread;

import java.io.*;
import java.net.*;

/**
 *
 * @author Aspire 5
 */
public class server {

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(6777);
        Socket sr = s.accept();
        FileInputStream fr = new FileInputStream("D:/MY MUSIK/MICHEL~2.mp3");
        byte bit[] = new byte[4096000];
        fr.read(bit, 0, bit.length);
        System.out.println("Proses Transfer");
        Thread.sleep(6000);
        OutputStream os = sr.getOutputStream();
        os.write(bit, 0, bit.length);
        System.out.println("Transfer Sucssesfull");

    }
}
