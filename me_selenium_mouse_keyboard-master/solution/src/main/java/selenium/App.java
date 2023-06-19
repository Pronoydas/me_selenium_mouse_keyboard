package selenium;

import java.net.MalformedURLException;

public class App {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.out.println("From App.java");

        // TODO - Uncomment for the Clicks activity

    
        Clicks clicks = new Clicks();
        clicks.run();

        // TODO - Uncomment for Hover and Scroll activity
        HoverAndScroll hoverAndScroll = new HoverAndScroll();
        hoverAndScroll.run();
    }
}
