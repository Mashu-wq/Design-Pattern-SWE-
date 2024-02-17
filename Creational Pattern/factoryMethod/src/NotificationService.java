/*
 * To implement the Factory Pattern, we will need to:

- Define an interface or abstract class that declares the factory method for creating objects.
- Create concrete classes that implement the interface or abstract class and provide their own implementation of the factory method.
- Define a client class that uses the factory method to create objects without knowing their exact class.
 */
//create notification interface
 interface Notification {
    void notifyUser();
}
//product for notification
 class SMSNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending an SMS notification");
    }
}
//email notification
 class EmailNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending an e-mail notification");
    }
}
//push notification
 class PushNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending a push notification");
    }
}
//create a factory class notificationFactory to instantiate concrete class
 class NotificationFactory {
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
        case "SMS":
            return new SMSNotification();
        case "EMAIL":
            return new EmailNotification();
        case "PUSH":
            return new PushNotification();
        default:
            throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}


public class NotificationService {
    public static void main(String[] args)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
    
}
