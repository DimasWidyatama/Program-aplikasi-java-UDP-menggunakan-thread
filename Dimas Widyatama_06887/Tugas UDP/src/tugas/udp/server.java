package tugas.udp;

/**
 *
 * @author Aspire 5
 */
import java.io.*;
import java.net.*;

public class server {

    public static void main(String[] args) throws SocketException, IOException {
        int PORT = 6799;
        DatagramSocket serverSocket = new DatagramSocket(PORT);
        System.out.println("Server berhasil dijalankan!");
        System.out.println("=============================================================");

        try {
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packetMasuk = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packetMasuk);

                InetAddress IPClient = packetMasuk.getAddress();
                int portClient = packetMasuk.getPort();

                String pesanMasuk = new String(packetMasuk.getData(), 0, packetMasuk.getLength());
                System.out.println("Pesan masuk: " + pesanMasuk);

                String pesanKeluar = ("Berhasil mengirim pesan '" + pesanMasuk + "' ke server");
                DatagramPacket packetKeluar = new DatagramPacket(pesanKeluar.getBytes(), pesanKeluar.length(), IPClient, portClient);
                serverSocket.send(packetKeluar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}