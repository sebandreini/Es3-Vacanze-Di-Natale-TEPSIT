package andreini_package;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadInvio implements Runnable {
    private Scanner sc;
    private PrintWriter out;

    public ThreadInvio(Socket socket) throws IOException {
        sc = new Scanner(System.in);
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        boolean primo = true;
        while (!Thread.interrupted()) {
            if (primo) {
                System.out.println("Dammi il nome utente:");
                primo = false;
            }
            String message = sc.nextLine();
            out.println(message);
        }
    }
}
