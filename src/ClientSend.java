import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ClientSend {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Socket socket=null;
        try{
            ArrayList<String> clientNames = new ArrayList<String>();
            clientNames.add("Client1");
            clientNames.add("Client2");
            System.out.println("Доступны клиенты: ");
            for(int i=0;i<clientNames.size();i++){
                System.out.println(i+" - "+clientNames.get(i));
            }
            System.out.print("Введите номер клиента: ");
            String sentence=scan.nextLine();
            System.out.print("Введите ваше сообщение: ");
            sentence+=" ";
            sentence+=scan.nextLine();
            socket = new Socket(InetAddress.getLocalHost(), 6789);
            System.out.println("Сообщение отправлено!");
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(sentence);
            ps.flush();
            socket.close();
        }
        catch(IOException e){
            System.out.println("Ошибка: "+ e);
        }
    }
}
