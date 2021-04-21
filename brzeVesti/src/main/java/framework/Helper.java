
package framework;


public class Helper {
    
    public static int getRandomIntiger() {
        return (int) (Math.random() * 1000);
    }
    
    public static String genereateTitle() {
        return "Nikola-" + getRandomIntiger();
    }
    
}
