import java.net.*;
import java.io.*;


public class Client1 {
    public static void main(String[] args) {
        Socket socket =null;
        try {
            socket = new Socket("localhost", 6375);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            if (msg != null) {
                System.out.println("Сообщение получено: " + msg);
                reader.close();
                socket.close();
            }
        }
            catch(IOException e){
                System.out.println("Ошибка: "+e);
        }
    }
}
