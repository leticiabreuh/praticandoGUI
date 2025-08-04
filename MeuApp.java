import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeuApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seus Cachos");
        frame.setSize(600, 400); // aumentei tamanho para caber mais imagens
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(139, 69, 19));

        JLabel labelTitulo = new JLabel("Qual se parece mais com o seu cabelo?");
        labelTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Painel que vai conter as imagens, com FlowLayout para colocar lado a lado
        JPanel painelImagens = new JPanel();
        painelImagens.setBackground(new Color(139, 69, 19));
        painelImagens.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // espaço entre imagens

        // Adiciona imagens
        painelImagens.add(criarImagemClicavel("img/tipo1A.jpg", "Tipo 1A"));
        painelImagens.add(criarImagemClicavel("img/tipo1B.jpg", "Tipo 1B"));
        painelImagens.add(criarImagemClicavel("img/tipo1C.jpg", "Tipo 1C"));
         painelImagens.add(criarImagemClicavel("img/tipo2A.jpg", "Tipo 2A"));
         painelImagens.add(criarImagemClicavel("img/tipo2B.jpg", "Tipo 2B"));
        painelImagens.add(criarImagemClicavel("img/tipo2C.jpg", "Tipo 2C"));
         painelImagens.add(criarImagemClicavel("img/tipo3A.jpg", "Tipo 3A"));
         painelImagens.add(criarImagemClicavel("img/tipo3B.jpg", "Tipo 3B"));
        painelImagens.add(criarImagemClicavel("img/tipo3C.jpg", "Tipo 3C"));

        // Junta tudo
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(painelImagens, BorderLayout.CENTER);

        frame.add(panelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método que cria uma imagem redimensionada e clicável
    public static JLabel criarImagemClicavel(String caminhoImagem, String mensagem) {
        ImageIcon original = new ImageIcon(caminhoImagem);
        Image redimensionada = original.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon imagemFinal = new ImageIcon(redimensionada);

        JLabel label = new JLabel(imagemFinal);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // ícone de mão
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Seu cabelo e " + mensagem);
            }
        });
        return label;
    }
}
