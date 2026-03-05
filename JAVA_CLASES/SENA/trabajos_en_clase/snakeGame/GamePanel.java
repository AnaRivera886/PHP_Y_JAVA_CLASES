package snakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.cert.CertPath;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    private int foodX;
    private int foodY;
    private Random random = new Random();

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int CELL_SIZE = 50; // Tamaño de cada celda
    private static final int COLS = WIDTH / CELL_SIZE;
    private static final int ROWS = HEIGHT / CELL_SIZE;
    // 9
    private boolean running = true;
    private int score = 0;

    // METODO PARA VERIFICAR SI COME
    private void checkFood() {
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            snakeLength++;
            score += 10;
            spawnFood();
        }
    }

    // METODO PARA VERIFICAR COLISIONES
    private void checkCollisions() {
        // PAREDES
        if (snakeX[0] < 0 || snakeX[0] >= WIDTH || snakeY[0] >= HEIGHT) {
            running = false;
        }

        // PROPIO CUPERO
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                running = false;
                break;
            }
        }

        if (!running) {
            timer.stop();
        }

    }

    // coordenadas de la serpiente
    private Timer timer;
    private int[] snakeX = new int[100]; // maximo 100 segmentos
    private int[] snakeY = new int[100];
    private int snakeLength = 5; // longitud inicial
    private char direction = 'R'; // U : arriba, D: abajo L: izquierda R: derecha

    private void moveSnake() {
        // mover el cuerpo y cada segmento sigue el anterior
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // Mover la cabeza segun direccion
        switch (direction) {
            case 'U':
                snakeY[0] -= CELL_SIZE;
                break;
            case 'D':
                snakeY[0] += CELL_SIZE;
                break;
            case 'L':
                snakeX[0] -= CELL_SIZE;
                break;
            case 'R':
                snakeX[0] += CELL_SIZE;
                break;
        }
    }

    // metodo para generar comida

    private void spawnFood() {
        foodX = random.nextInt(COLS) * CELL_SIZE;
        foodY = random.nextInt(ROWS) * CELL_SIZE;
    }

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);// importante para recivir eventos del teclado

        // iniciar pocicion de la serpiente
        int startX = (COLS / 2) * CELL_SIZE;
        int startY = (ROWS / 2) * CELL_SIZE;

        for (int i = 0; i < snakeLength; i++) {
            snakeX[i] = startX - (i * CELL_SIZE);
            snakeY[i] = startY;
        }

        // llamar metodo para aparecer la comida
        spawnFood();

        // captura tecla
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                // evitar que la serpiente se vuelva sobre si misma
                if (key == KeyEvent.VK_UP && direction != 'D')
                    direction = 'U';
                else if (key == KeyEvent.VK_DOWN && direction != 'U')
                    direction = 'D';
                else if (key == KeyEvent.VK_LEFT && direction != 'R')
                    direction = 'L';
                else if (key == KeyEvent.VK_RIGHT && direction != 'L')
                    direction = 'R';
                // REINICIAR
                if (key == KeyEvent.VK_R) {
                    startGame();
                }
            }
            private void startGame(){
                score = 0;
                running = true;
                snakeLength = 5;
                direction = 'R';
                
                int startX = (COLS / 2) * CELL_SIZE;
                int startY = (COLS / 2) * CELL_SIZE;

                for (int i = 0; i > snakeLength; i++){
                    snakeX[i] =startX - (i * CELL_SIZE);
                    snakeY[i] =startY;

                }
                spawnFood();
                repaint();
            }
        });

        // configurar timer para movimiento (cada 200ms)
        timer = new Timer(200, this);
        timer.start();

        requestFocus(); // asegura que el panel tenga el foco
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            moveSnake();
            checkFood();
            checkCollisions();
        }
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar cuadricula
        g.setColor(new Color(10, 50, 20)); // color verde para la cuadricula

        // lineas verticales
        for (int x = 0; x < WIDTH; x += CELL_SIZE) {
            g.drawLine(x, 0, x, HEIGHT);
        }

        // lineas horizontales
        for (int y = 0; y < HEIGHT; y += CELL_SIZE) {
            g.drawLine(0, y, WIDTH, y);
        }

        // Dibujar serpiente
        for (int i = 0; i < snakeLength; i++) {
            if (i == 0) {
                g.setColor(Color.GREEN); // cabeza mas brillante
            } else {
                g.setColor(new Color(0, 160, 0)); // cuerpo mas oscuro
            }
            g.fillRect(snakeX[i], snakeY[i], CELL_SIZE, CELL_SIZE);
        }

        // dibujar comida
        g.setColor(Color.RED);
        g.fillOval(foodX + 3, foodY + 3, CELL_SIZE - 6, CELL_SIZE - 6);

        // MOSTRAR PUNTUCION
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Score:  " + score, 15, 25);

        // GAME OVER
        if (!running) {
            g.setFont(new Font("Arial", Font.BOLD, 42));
            String msg = "GAME OVER";
            int msgWidth = g.getFontMetrics().stringWidth(msg);
            g.drawString(msg, (WIDTH - msgWidth) / 2, HEIGHT / 2);
        }

    }

}