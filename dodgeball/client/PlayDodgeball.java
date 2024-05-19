package dodgeball.client;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Join a game of dodgeball.
 */
public class PlayDodgeball {
  public static void main(String[] args) throws AWTException, FileNotFoundException, IOException {
    Client client = new Client();
    new Thread(client).start();
  }
}