import javax.swing.*;

public class Main {
    /**
     * Mainloop for the programm
     * @param args
     */
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });

    }
}
