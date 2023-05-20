/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.sistemadecadastrofuncionarios;

/**
 *
 * @author gilde
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Funcionarios extends JFrame {

    private List<Funcionario> funcionarios;

    public Funcionarios() {
        funcionarios = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro de Funcionários");
        setSize(400, 300);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Sistema de Cadastro de Funcionários");
        labelTitulo.setBounds(100, 30, 200, 20);
        add(labelTitulo);

        JLabel labelAdicionar = new JLabel("Opção 1: Adicionar Funcionário");
        labelAdicionar.setBounds(50, 70, 300, 20);
        add(labelAdicionar);

        JLabel labelRemover = new JLabel("Opção 2: Remover Funcionário");
        labelRemover.setBounds(50, 100, 300, 20);
        add(labelRemover);

        JLabel labelBuscar = new JLabel("Opção 3: Buscar Funcionário");
        labelBuscar.setBounds(50, 130, 300, 20);
        add(labelBuscar);

        JLabel labelListar = new JLabel("Opção 4: Listar Funcionários");
        labelListar.setBounds(50, 160, 300, 20);
        add(labelListar);
    }

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void remover(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public Funcionario buscar(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }
}
