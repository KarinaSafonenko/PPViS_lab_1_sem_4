package by.safonenko.bsuir.ppvis;

import javax.swing.SwingUtilities;
/**
 * Created by Admin on 10.03.2017.
 */
public class AppStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
