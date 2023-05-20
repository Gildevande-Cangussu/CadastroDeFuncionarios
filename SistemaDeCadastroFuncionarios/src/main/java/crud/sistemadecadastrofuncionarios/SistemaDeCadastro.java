/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.sistemadecadastrofuncionarios;

/**
 *
 * @author gilde
 * */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SistemaDeCadastro extends JFrame {
    private JTextField textFieldCPF;
    private Funcionarios funcionarios;

    public SistemaDeCadastro() {
        funcionarios = new Funcionarios();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro de Funcionários");
        setSize(400, 300);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Sistema de Cadastro de Funcionários");
        labelTitulo.setBounds(100, 30, 200, 20);
        add(labelTitulo);

        JButton buttonCadastrar = new JButton("Cadastrar Funcionário");
        buttonCadastrar.setBounds(50, 70, 200, 20);
        add(buttonCadastrar);

        JButton buttonRemover = new JButton("Remover Funcionário");
        buttonRemover.setBounds(50, 100, 200, 20);
        add(buttonRemover);

        JButton buttonBuscar = new JButton("Buscar Funcionário");
        buttonBuscar.setBounds(50, 130, 200, 20);
        add(buttonBuscar);

        JButton buttonListar = new JButton("Listar Funcionários");
        buttonListar.setBounds(50, 160, 200, 20);
        add(buttonListar);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(250, 70, 100, 20);
        add(labelCPF);

        textFieldCPF = new JTextField();
        textFieldCPF.setBounds(300, 70, 200, 20);
        add(textFieldCPF);

        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });

        buttonRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerFuncionario();
            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarFuncionario();
            }
        });

        buttonListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarFuncionarios();
            }
        });
    }

    private void cadastrarFuncionario() {
        String cpf = textFieldCPF.getText();
        Funcionario funcionarioExistente = funcionarios.buscar(cpf);

        if (funcionarioExistente != null) {
            JOptionPane.showMessageDialog(null, "Funcionário já cadastrado!");
        } else {
            String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário:"));
            String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");

            Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
            funcionarios.adicionar(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        }

        limparCampos();
    }

    private void removerFuncionario() {
        String cpf = textFieldCPF.getText();
        Funcionario funcionario = funcionarios.buscar(cpf);

        if (funcionario != null) {
            funcionarios.remover(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
        }

        limparCampos();
    }

    private void buscarFuncionario() {
        String cpf = textFieldCPF.getText();
        Funcionario funcionario = funcionarios.buscar(cpf);

        if (funcionario != null) {
            JOptionPane.showMessageDialog(null, "Funcionário encontrado:\n" + funcionario.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
        }

        limparCampos();
    }

    private void listarFuncionarios() {
        List<Funcionario> listaFuncionarios = funcionarios.listar();

        if (!listaFuncionarios.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Funcionario funcionario : listaFuncionarios) {
                sb.append(funcionario.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Lista de Funcionários:\n" + sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado!");
        }

        limparCampos();
    }

    private void limparCampos() {
        textFieldCPF.setText("");
    }

    public static void main(String[] args) {
        SistemaDeCadastro sistema = new SistemaDeCadastro();
        sistema.setVisible(true);
    }
}
