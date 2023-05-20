/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.sistemadecadastrofuncionarios;

/**
 *
 * @author gilde
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Funcionario extends JFrame {
    private String nome;
    private String cpf;
    private double salario;
    private String cargo;

    public Funcionario(String nome, String cpf, double salario, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Detalhes do Funcionário");
        setSize(300, 200);
        setLayout(null);

        JLabel labelNome = new JLabel("Nome: " + nome);
        labelNome.setBounds(50, 30, 200, 20);
        add(labelNome);

        JLabel labelCPF = new JLabel("CPF: " + cpf);
        labelCPF.setBounds(50, 60, 200, 20);
        add(labelCPF);

        JLabel labelSalario = new JLabel("Salário: " + salario);
        labelSalario.setBounds(50, 90, 200, 20);
        add(labelSalario);

        JLabel labelCargo = new JLabel("Cargo: " + cargo);
        labelCargo.setBounds(50, 120, 200, 20);
        add(labelCargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
