import java.net.*;
import java.io.*;

class socketClient {
	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(10009);

		Socket clientSocket = serverSocket.accept();

		DataInputStream din = new DataInputStream(clientSocket.getInputStream());
		
		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
		String str = "", str2 = "";

		while(!str.equals("stop")) {
			str = din.readUTF();
			System.out.println("client says: " + str);
		}
		
		din.close();
		clientSocket.close();
		serverSocket.close();

	}
}