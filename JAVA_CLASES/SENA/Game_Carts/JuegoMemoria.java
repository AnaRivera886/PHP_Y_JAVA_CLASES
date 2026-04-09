package JAVA_CLASES.SENA.Game_Carts;

import javax.swing.*;
import java.awt.*;

public class JuegoMemoria extends JFrame {

    private JButton[] cartas = new JButton[16];
    private ImageIcon[] imagenes = new ImageIcon[8];
    private ImageIcon[] valores = new ImageIcon[16];
    private ImageIcon reverso;
    private JButton primeracarta = null;
    private boolean bloqueado = false;
    private int intentos = 0;
    private int parejasEncontradas = 0;

    private JLabel lblIntentos;
    private JLabel lblParejas;

    public JuegoMemoria() {
        setTitle("Juego de Memoria");
        setSize(450, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelInfo = new JPanel(new FlowLayout());
        lblIntentos = new JLabel("Intentos: 0");
        lblParejas = new JLabel("Parejas: 0/8");
        JButton btnReiniciar = new JButton("Reiniciar");
        panelInfo.add(lblIntentos);
        panelInfo.add(lblParejas);
        panelInfo.add(btnReiniciar);
        add(panelInfo, BorderLayout.NORTH);

        JPanel tablero = new JPanel(new GridLayout(4, 4, 8, 8));
        tablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cargarImagenes(); // ← primero carga las imágenes
        inicializarCartas(tablero); // ← luego arma el tablero
        add(tablero, BorderLayout.CENTER);

        btnReiniciar.addActionListener(e -> reiniciarJuego(tablero));
        setVisible(true);
    }

    // CAMBIA ESTO en cargarImagenes()
    private void cargarImagenes() {
        String base = "JAVA_CLASES/SENA/Game_Carts/imagenes/";

        reverso = escalarImagen(base + "reverso.png");

        for (int i = 0; i < 8; i++) {
            imagenes[i] = escalarImagen(base + "carta" + (i + 1) + ".png");
        }
    

    }

    private ImageIcon escalarImagen(String ruta) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagen = iconoOriginal.getImage();

        // Cambia el tamaño aquí (ej: 80x80)
        Image imagenEscalada = imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        return new ImageIcon(imagenEscalada);
    }

    private void inicializarCartas(JPanel tablero) {
        ImageIcon[] doble = new ImageIcon[16];
        for (int i = 0; i < 8; i++) {
            doble[i] = imagenes[i];
            doble[i + 8] = imagenes[i];
        }
        // Barajar
        for (int i = 15; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            ImageIcon temp = doble[i];
            doble[i] = doble[j];
            doble[j] = temp;
        }
        valores = doble;

        tablero.removeAll();
        for (int i = 0; i < 16; i++) {
            JButton carta = new JButton(reverso);
            carta.setBackground(Color.LIGHT_GRAY);
            carta.putClientProperty("indice", i);
            carta.addActionListener(e -> voltearCarta((JButton) e.getSource()));
            cartas[i] = carta;
            tablero.add(carta);
        }
        tablero.revalidate();
        tablero.repaint();
    }

    private void voltearCarta(JButton carta) {
        int indice = (int) carta.getClientProperty("indice");

        // Ignorar si bloqueado o ya está volteada/encontrada
        if (bloqueado || carta.getIcon() != reverso)
            return;

        carta.setIcon(valores[indice]); // mostrar la imagen
        carta.setBackground(Color.WHITE);

        if (primeracarta == null) {
            primeracarta = carta;
        } else {
            intentos++;
            lblIntentos.setText("Intentos: " + intentos);
            bloqueado = true;

            int indicePrimera = (int) primeracarta.getClientProperty("indice");

            if (valores[indice] == valores[indicePrimera]) {
                primeracarta.setBackground(new Color(144, 238, 144));
                carta.setBackground(new Color(144, 238, 144));
                parejasEncontradas++;
                lblParejas.setText("Parejas: " + parejasEncontradas + "/8");
                primeracarta = null;
                bloqueado = false;

                if (parejasEncontradas == 8) {
                    JOptionPane.showMessageDialog(this,
                            "¡Ganaste en " + intentos + " intentos!",
                            "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JButton segundacarta = carta;
                JButton primera = primeracarta;
                primeracarta = null;

                Timer timer = new Timer(900, ev -> {
                    primera.setIcon(reverso); // ← ícono, no texto
                    primera.setBackground(Color.LIGHT_GRAY);
                    segundacarta.setIcon(reverso); // ← ícono, no texto
                    segundacarta.setBackground(Color.LIGHT_GRAY);
                    bloqueado = false;
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void reiniciarJuego(JPanel tablero) {
        intentos = 0;
        parejasEncontradas = 0;
        primeracarta = null;
        bloqueado = false;
        lblIntentos.setText("Intentos: 0");
        lblParejas.setText("Parejas: 0/8");
        inicializarCartas(tablero);
    }

    public static void main(String[] args) {
        new JuegoMemoria();
    }
}
