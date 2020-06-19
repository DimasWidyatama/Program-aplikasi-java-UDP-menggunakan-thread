package tugas.udp;
/**
 *
 * @author Aspire 5
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    
        public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        InetAddress host = InetAddress.getLocalHost();
        DatagramSocket clientSocket = new DatagramSocket();
        int PORT = 6799;
        
        try {
            while (true) {
                Scanner inputan = new Scanner(System.in);
                System.out.print("> Masukkan pesan = ");
                String pesan = inputan.nextLine();

                DatagramPacket packetKeluar = new DatagramPacket(pesan.getBytes(), pesan.length(), host, PORT);
                clientSocket.send(packetKeluar);

                byte[] buffer = new byte[256];
                DatagramPacket packetMasuk = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(packetMasuk);

                String pesanMasuk = new String(packetMasuk.getData(), 0, packetMasuk.getLength());
                System.out.println("> Status      = " + pesanMasuk);
                System.out.println("> IP Server   = " + packetMasuk.getAddress());
                System.out.println("> Port Server = " + packetMasuk.getPort());

                System.out.println("=============================================================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }   
}
