package snakeGame;
import javax.swing.*;

public class Serpiente extends JFrame {
    
    public Serpiente() {
        setTitle("Snake - Cublebrita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //AÑADIR PANEL DE JUEGO
        add(new GamePanel());
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new Serpiente();
    }
    
}

