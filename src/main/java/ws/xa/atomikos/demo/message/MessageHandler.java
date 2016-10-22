package ws.xa.atomikos.demo.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {
    @JmsListener(destination = "accounts")
    public void onMessage(String content) {
        System.out.println("On Message ----> " + content);
        System.out.println("\n\n");
    }

}
