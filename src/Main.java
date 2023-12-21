import java.util.Scanner;
import java.net.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Socket client1st = null;
        Socket sender = null;
        Socket client2nd = null;
        try {
            System.out.println("Сервер запущен!");
            ServerSocket client1 = new ServerSocket(6375);
            ServerSocket client2 = new ServerSocket(6376);
            ServerSocket sender1 = new ServerSocket(6789);
            client1st = client1.accept();
            sender = sender1.accept();
            client2nd = client2.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(sender.getInputStream()));
            String msg = reader.readLine();
            String[] data = msg.split(" ", 2);
            String receivind = data[0];
            msg = data[1];
            if (receivind.equals("0")) {
                PrintStream ps = new PrintStream(client1st.getOutputStream());
                ps.println(msg);
                ps.flush();
                client1st.close();
            }
            else
            {
                PrintStream ps = new PrintStream(client2nd.getOutputStream());
                ps.println(msg);
                ps.flush();
                client2nd.close();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка "+e);
        }
    }
}