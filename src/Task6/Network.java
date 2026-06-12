package Task6;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface NotificationSender{
    void send(Notification notification);
}

public class Network {

    public static void main(String args[]){
        Notification n = new Notification(
                "N101",
                "Ravi",
                "ravi@gmail.com",
                "9876543210",
                "Your class starts at 7:30 AM",
                "SMS",
                "HIGH"
        );
   NotificationSender  emailSender=notification->{
            System.out.println("Email sent to "+ notification.getEmail());
        };


    NotificationSender  smsSender=notification->{
        System.out.println("sms sent to "+ notification.getMobile());
        System.out.println("message: "+notification.getMessage());
    };
    NotificationSender whatsappSender = notification -> {
        System.out.println("WhatsApp Sent to " + notification.getMobile());
        System.out.println("Message: " + notification.getMessage());
    };

    NotificationSender pushSender = notification -> {
        System.out.println("Push Notification Sent");
        System.out.println("Message: " + notification.getMessage());
    };
        Map<String,NotificationSender> senders=new HashMap<>();
        senders.put("EMAIL", emailSender);
        senders.put("SMS", smsSender);
        senders.put("WHATSAPP", whatsappSender);
        senders.put("PUSH", pushSender);

        if(n.getPriority().equals("HIGH")){
            senders.get("EMAIL").send(n);
            senders.get("WHATSAPP").send(n);
        }
        else{
            senders.get(n.getNotificationType()).send(n);
        }


}
}