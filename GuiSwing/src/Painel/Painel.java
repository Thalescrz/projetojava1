/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Painel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.net.InetAddress;
import javax.swing.JTextArea;
/**
 *
 * @author Thales
 */
public class Painel extends FuncoesBotoes implements ActionListener  {
    

    int largura = 300;
    int altura = 200;
    
    private static JTextArea textoArea;
    private static JLabel userLabel, passLabel, ipLabel, sucessoLabel, guiaLabel;
    public static JTextField userText,cfgText;
    private static JPasswordField passText;
    private static JButton button, button2, button3, button4, button5, button6;
    private static JPanel panel, panel2;
    private static JFrame frame, frame2;
    
    //Construtor
    public Painel(){}
    public Painel(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    //Metodos publicos
    public void abrirPainel()throws Exception {
        InetAddress myIP = InetAddress.getLocalHost();
        
        Painel botao = new Painel();//utilizado no:   button.addActionListener(botao);  para poder chamar o:    public void actionPerformed(ActionEvent e)
        
        panel = new JPanel();
        
        frame = new JFrame();
        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
       
        frame.add(panel);
        
        panel.setLayout(null);
        
        //Usuário
            //Label
        userLabel = new JLabel("User");
        userLabel.setBounds(25, 20, 80, 25);
        panel.add(userLabel);
            //Campo de Texto
        userText = new JTextField(20);
        userText.setBounds(80,20,165, 25);
        panel.add(userText);
        ////
       
        //Senha
            //Label
        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);
            //Campo de Texto
        passText = new JPasswordField(20);
        passText.setBounds(80,50,165, 25);
        panel.add(passText);
        ////
        
        //Botão
        button = new JButton("Login");
        button.setBounds(120, 80, 85, 25);
        button.addActionListener(botao); // Posso Utilizar no lugar do objeto/parametro o: new Painel() // o resultado é o mesmo pois logo ao inicializar o método abri uma instancia de classe (objeto)
        panel.add(button);
        ////
        
        //IP
        ipLabel = new JLabel(myIP.getHostAddress());
        ipLabel.setBounds(190, 140, 130, 25);
        panel.add(ipLabel);
        ////
        
        //Label Sucesso
        sucessoLabel = new JLabel("");
        sucessoLabel.setBounds(135, 100, 80, 25);
        panel.add(sucessoLabel);
        
        
        frame.setVisible(true);
        
        
        
        //Segunda Tela
        panel2 = new JPanel();
        panel2.setSize(1000, 700);
        
        frame2 = new JFrame();
        frame2.setSize(1000, 700);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(true);
        
        frame2.add(panel2);
        panel.setLayout(null);
        
         //Botão2 2ªTela
        button2 = new JButton("ipconfig");
        button2.setBounds(120, 80, 85, 25);
        button2.addActionListener((ActionEvent e) -> { //outra maneira de executar o botão utilizando LAMBDA 
            executarIpconfig(); //a função está dentro da outra classe FuncoesBotoes
            StringBuilder formattedText = new StringBuilder();
            for (String line : texto.split("\n")) {
                formattedText.append(line).append("\n");
            }
            textoArea.setText(formattedText.toString());
        }); 
        panel2.add(button2);
        
        
       
        //Botão3 2ªTela
        button3 = new JButton("PowerCFG");
        button3.setBounds(120, 160, 85, 25);
        button3.addActionListener((ActionEvent e) -> { //outra maneira de executar o botão utilizando LAMBDA 
            executarPowerCfg(); //a função está dentro da outra classe FuncoesBotoes
            
                                        //textoLabel.setText("<html>" + texto.replace("\n", "<br>") + "</html>"); < no caso se for JLabel / para JTextArea não funciona o html
            StringBuilder formattedText = new StringBuilder();
            for (String line : texto.split("\n")) {
                formattedText.append(line).append("\n");
            }
            textoArea.setText(formattedText.toString());
            extrasCfg();
            
        }); 
        panel2.add(button3);
        
         //Botão4 2ªTela
        button4 = new JButton("cmd");
        button4.setBounds(120, 120, 85, 25);
        button4.addActionListener((ActionEvent e) -> { //outra maneira de executar o botão utilizando LAMBDA 
            executarCmd(); //a função está dentro da outra classe FuncoesBotoes 
        });    
        panel2.add(button4);
        
        //Botão5 2ªTela
        button5 = new JButton("Trocar Plano");
        button5.setBounds(120, 200, 85, 25);
        button5.addActionListener((ActionEvent e) -> { //outra maneira de executar o botão utilizando LAMBDA 
            botaoTrocarPlano(); //a função está dentro da outra classe FuncoesBotoes 
            botaoVerificarCfg();
            StringBuilder formattedText = new StringBuilder();
            for (String line : texto.split("\n")) {
                formattedText.append(line).append("\n");
            }
            textoArea.setText(formattedText.toString());
            panel2.add(button6);
            
        });   
        
        button6 = new JButton("Verificar Plano");
        button6.setBounds(120, 240, 85, 25);
        button6.addActionListener((ActionEvent e) -> { //outra maneira de executar o botão utilizando LAMBDA 
            botaoVerificarCfg(); //a função está dentro da outra classe FuncoesBotoes 
            StringBuilder formattedText = new StringBuilder();
            for (String line : texto.split("\n")) {
                formattedText.append(line).append("\n");
            }
            textoArea.setText(formattedText.toString());
        }); 
        
        
        
        //Campo de Texto para digitar
        cfgText = new JTextField(20);
        cfgText.setBounds(120,280,165, 25); 
        guiaLabel = new JLabel("COLE O GUID DO PLANO DE ENERGIA AQUI");
        guiaLabel.setBounds(120, 295, 165, 25);
        
        
  
        //texto que vai aparecer dentro do programa
        textoArea = new JTextArea("");
        textoArea.setBounds(200, 350, 200, 100);
        textoArea.setEditable(false);
        panel2.add(textoArea);
        ////
        
        
    }

    //Botão Local
    protected void botaoTrocarPlano(){
        String cfgGUID = cfgText.getText();
        
         try {
           
            String comando = "Powercfg /s " + cfgGUID; 

            // Inicar o processo e executar o comando
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Ler a saída do processo
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));    
             StringBuilder output = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line).append("\n");
             }
            // Armazenar a saída em uma variável
            texto = output.toString();
            
            // Aguardar o término do processo
            int exitCode = process.waitFor();
            System.out.println("Comando executado com código de saída: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    
    //metodo extra
    protected void extrasCfg(){
        panel2.add(button5);
        panel2.add(guiaLabel);
        panel2.add(cfgText);  
    }
    
    //Métodos Implementados
    @Override
    public void actionPerformed(ActionEvent e) {
       String user = userText.getText();
       String password = passText.getText();
        
        if(user.equals("adm")&& password.equals("123")){
            sucessoLabel.setText("Sucesso");
            frame2.setVisible(true);
            
        } else {
            System.out.println("Usuário/Senha Incorretos");
        }
    }

}


