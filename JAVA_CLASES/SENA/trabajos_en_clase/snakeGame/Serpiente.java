package snakeGame;

import javax.swing.*;

public class Serpiente extends JFrame {

    public Serpiente()
    {
        setTitle("Snake - Cukebrita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        

        // añadir panel de juego 
        /********************************************************* */
        add(new GamePanel());
        pack();                         // ajusta el tamaño de la ventana al del panel 
        setLocationRelativeTo(null);    
        setVisible(true);
        /********************************************************* */


    }

    public static void main (String[] args ){
        
        new Serpiente();

    }
    
}
