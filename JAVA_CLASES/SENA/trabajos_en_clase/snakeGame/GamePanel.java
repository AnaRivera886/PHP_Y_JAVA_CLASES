package snakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.util.Timer;



public class GamePanel extends JPanel implements ActionListener{
    
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int CELL_SIZE = 50; //TAMAÑO DE CADA CELDA
    private static final int COLS = WIDTH / CELL_SIZE;
    private static final int ROWS = HEIGHT / CELL_SIZE;

    // COORDENADAS DE LA SERPIENTE
    private Timer timer;
    private int[] snakeX = new int[100]; //MAXIMO 100 SEGMENTOS
    private int[] snakeY = new int[100];
    private int snakeLength = 5; // lONGITUD INICIAL
    private char direction = 'R'; // U: ARRIBA, D: ABAJO, l: IZQUIEDA, R: DERECHA

    private void moveSnake(){
        //MOVER EL CUERPO: CADA SEGMENTO SIGUE AL ANTERIOR
        for (int i = snakeLength - 1; i > 0; i--){
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // MOVER LA CABEZA SEGUN LA DIRECCION
        switch (direction) {
            case 'U': snakeY[0] -= CELL_SIZE; break;
            case 'D': snakeY[0] += CELL_SIZE; break;
            case 'L': snakeX[0] -= CELL_SIZE; break;
            case 'R': snakeX[0] += CELL_SIZE; break;
        }
    }
    
    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        
        // INICIALIZAR SERPIENTE
        int startX = (COLS / 2) * CELL_SIZE;
        int startY = (ROWS / 2) * CELL_SIZE;
        
        for (int i = 0; i < snakeLength; i++){
            snakeX[i] = startX - (i * CELL_SIZE);
            snakeY[i] = startY;
        }
        
        //CONFIGURAR TIMER PARA MOVIMIENTO (CADA 200MS)
        timer = new Timer(200, this);
        timer.start();

    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // SOLO SE DIBUJA EL FONDO NEGRO POR AHORA

        // DIBUJAR CUADRICULA
        g.setColor(new Color(40, 30, 40));
        
        // LINEAS HORZONTALES
        for (int y = 0; y < HEIGHT; y += CELL_SIZE){
            g.drawLine(0, y, WIDTH, y);
        // LINEAS VERTICALES
        for (int x = 0; x < WIDTH; x += CELL_SIZE){
            g.drawLine(x, 0, x, HEIGHT);
        }
        }
        // DIBUJAR SERPIENTE
        for (int i = 0; i < snakeLength; i++){
            if (i == 0 ){
                g.setColor(Color.GREEN); // CABEZA MAS BRILLANTE
            }else{
                g.setColor(new Color(0, 160, 0)); //CUERPO MAS OSCURO
            }
            g.fillRect(snakeX[i], snakeY[i], CELL_SIZE, CELL_SIZE);
        }

    }
}


