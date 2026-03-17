package JAVA_CLASES.SENA.CALCULADORA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// =============================================
// PASO 1: La clase principal hereda de JFrame
// JFrame es la ventana principal de la aplicación
// Implementamos ActionListener para manejar los clics
// =============================================
public class Calculadora extends JFrame implements ActionListener {

    // =============================================
    // PASO 2: Declarar los componentes (atributos)
    // =============================================
    private JTextField pantalla;       // Campo de texto donde se muestran los números
    private double numero1, numero2;   // Almacenan los operandos
    private String operador = "";      // Guarda el operador seleccionado (+, -, *, /)
    private boolean nuevaEntrada = false; // Controla si hay que limpiar la pantalla

    // =============================================
    // PASO 3: Constructor — aquí construimos la ventana
    // =============================================
    public Calculadora() {

        // --- Configurar la ventana ---
        setTitle("Calculadora");
        setSize(340, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar app al cerrar ventana
        setLocationRelativeTo(null);                     // Centrar en pantalla
        setResizable(false);

        // --- Panel principal con fondo oscuro ---
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(28, 28, 28));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // =============================================
        // PASO 4: Crear la pantalla (JTextField)
        // =============================================
        pantalla = new JTextField("0");
        pantalla.setEditable(false);              // El usuario no puede escribir directamente
        pantalla.setHorizontalAlignment(JTextField.RIGHT); // Texto alineado a la derecha
        pantalla.setFont(new Font("Arial", Font.PLAIN, 40));
        pantalla.setBackground(new Color(28, 28, 28));
        pantalla.setForeground(Color.WHITE);
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pantalla.setPreferredSize(new Dimension(300, 80));

        panelPrincipal.add(pantalla, BorderLayout.NORTH);

        // =============================================
        // PASO 5: Crear el panel de botones con GridLayout
        // GridLayout organiza los botones en filas y columnas
        // 6 filas, 4 columnas, separación de 10px
        // (agregamos una fila extra para √ y xⁿ)
        // =============================================
        JPanel panelBotones = new JPanel(new GridLayout(6, 4, 10, 10));
        panelBotones.setBackground(new Color(28, 28, 28));

        // =============================================
        // PASO 6: Definir las etiquetas de los botones
        // en el orden que aparecerán en la cuadrícula
        // NUEVO: % = módulo | √ = raíz cuadrada | xⁿ = potencia
        // =============================================
        String[] etiquetas = {
            "√",  "xⁿ", "%",  "C",    // fila nueva con operaciones especiales
            "±",  "",   "",   "÷",
            "7",  "8",  "9",  "×",
            "4",  "5",  "6",  "−",
            "1",  "2",  "3",  "+",
            "0",  "",   ".",  "="
        };

        // =============================================
        // PASO 7: Crear cada botón y agregarlo al panel
        // =============================================
        for (String etiqueta : etiquetas) {

            if (etiqueta.equals("")) {
                // Espacio vacío (donde iría el "0" extendido)
                panelBotones.add(new JLabel(""));
                continue;
            }

            JButton boton = crearBoton(etiqueta);
            panelBotones.add(boton);
        }

        // Botón 0 ocupa doble ancho — lo añadimos manualmente al layout
        // Para simplicidad con GridLayout, el "0" ya está en la cuadrícula

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        add(panelPrincipal);
        setVisible(true); // Mostrar la ventana
    }

    // =============================================
    // PASO 8: Método auxiliar para crear botones
    // con estilos según su tipo
    // =============================================
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.PLAIN, 22));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addActionListener(this); // Registrar el listener de clic

        // Colorear según tipo
        if (texto.equals("=")) {
            boton.setBackground(new Color(255, 159, 10));
            boton.setForeground(Color.WHITE);
        } else if (texto.equals("÷") || texto.equals("×") ||
                   texto.equals("−") || texto.equals("+") ||
                   texto.equals("%")) {
            // Operadores binarios (necesitan dos números) → naranja
            boton.setBackground(new Color(255, 159, 10));
            boton.setForeground(Color.WHITE);
        } else if (texto.equals("√") || texto.equals("xⁿ")) {
            // Operaciones especiales → verde azulado
            boton.setBackground(new Color(30, 150, 120));
            boton.setForeground(Color.WHITE);
        } else if (texto.equals("C") || texto.equals("±")) {
            boton.setBackground(new Color(80, 80, 80));
            boton.setForeground(Color.WHITE);
        } else {
            boton.setBackground(new Color(50, 50, 50));
            boton.setForeground(Color.WHITE);
        }

        return boton;
    }

    // =============================================3+
    
    // PASO 9: Método actionPerformed
    // Se ejecuta automáticamente cuando se hace clic en un botón
    // =============================================
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Obtener el texto del botón presionado

        // --- Limpiar todo (C) ---
        if (comando.equals("C")) {
            pantalla.setText("0");
            numero1 = 0;
            numero2 = 0;
            operador = "";
            nuevaEntrada = false;
            return;
        }

        // --- Cambiar signo (±) ---
        if (comando.equals("±")) {
            double valor = Double.parseDouble(pantalla.getText());
            pantalla.setText(formatear(valor * -1));
            return;
        }

        // --- Raíz cuadrada (√): operación inmediata sobre el número actual ---
        if (comando.equals("√")) {
            double valor = Double.parseDouble(pantalla.getText());
            if (valor < 0) {
                pantalla.setText("Error"); // No existe raíz de negativos en reales
            } else {
                pantalla.setText(formatear(Math.sqrt(valor)));
            }
            nuevaEntrada = true;
            return;
        }

        // --- Potenciación (xⁿ): guarda n1 y espera n2 (el exponente) ---
        if (comando.equals("xⁿ")) {
            numero1 = Double.parseDouble(pantalla.getText());
            operador = "xⁿ";
            nuevaEntrada = true;
            return;
        }

        // --- Módulo (%): residuo de la división entera, ej: 10 % 3 = 1 ---
        if (comando.equals("%")) {
            numero1 = Double.parseDouble(pantalla.getText());
            operador = "%";
            nuevaEntrada = true;
            return;
        }

        // --- Operadores binarios estándar: guardan n1 y esperan n2 ---
        if (comando.equals("÷") || comando.equals("×") ||
            comando.equals("−") || comando.equals("+")) {
            numero1 = Double.parseDouble(pantalla.getText());
            operador = comando;
            nuevaEntrada = true;
            return;
        }

        // --- Igual (=): realizar el cálculo ---
        if (comando.equals("=")) {
            numero2 = Double.parseDouble(pantalla.getText());
            double resultado = calcular(numero1, numero2, operador);
            pantalla.setText(formatear(resultado));
            operador = "";
            nuevaEntrada = true;
            return;
        }

        // --- Punto decimal ---
        if (comando.equals(".")) {
            if (nuevaEntrada) {
                pantalla.setText("0.");
                nuevaEntrada = false;
            } else if (!pantalla.getText().contains(".")) {
                pantalla.setText(pantalla.getText() + ".");
            }
            return;
        }

        // --- Números (0-9) ---
        if (nuevaEntrada) {
            pantalla.setText(comando); // Reemplazar pantalla
            nuevaEntrada = false;
        } else {
            String actual = pantalla.getText();
            pantalla.setText(actual.equals("0") ? comando : actual + comando);
        }
    }

    // =============================================
    // PASO 10: Método para calcular el resultado
    // =============================================
    private double calcular(double n1, double n2, String op) {
        switch (op) {
            case "+":  return n1 + n2;
            case "−":  return n1 - n2;
            case "×":  return n1 * n2;
            case "÷":  return n2 != 0 ? n1 / n2 : 0;   // Evitar división por cero
            case "%":  return n2 != 0 ? n1 % n2 : 0;   // MÓDULO: residuo de la división
            case "xⁿ": return Math.pow(n1, n2);         // POTENCIA: n1 elevado a n2
            default:   return n2;
        }
    }

    // =============================================
    // PASO 11: Método para mostrar números sin ".0"
    // si el resultado es entero (ej: 6.0 → "6")
    // =============================================
    private String formatear(double numero) {
        if (numero == (long) numero) {
            return String.valueOf((long) numero);
        }
        return String.valueOf(numero);
    }

    // =============================================
    // PASO 12: Método main — punto de entrada del programa
    // =============================================
    public static void main(String[] args) {
        // Ejecutar la ventana en el hilo de eventos de Swing (buena práctica)
        SwingUtilities.invokeLater(() -> new Calculadora());
    }
}