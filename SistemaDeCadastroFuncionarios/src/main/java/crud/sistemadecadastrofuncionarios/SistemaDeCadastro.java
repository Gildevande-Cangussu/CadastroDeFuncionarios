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
import java.util.Scanner;

public class SistemaDeCadastro {
    private List<Funcionario> funcionarios;

    public SistemaDeCadastro() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public boolean removerFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }

    public Funcionario buscarFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public static void main(String[] args) {
        SistemaDeCadastro sistema = new SistemaDeCadastro();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("Sistema de Cadastro de Funcionários");
            System.out.println("-----------------------------------");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Buscar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Funcionario");
                    System.out.println("-----------------------------------");

                    System.out.println("Digite o nome do funcionario: ");
                    System.out.print("Digite o nome do funcionario: ");
                    String nome = scanner.nextLine();
                    
                     System.out.println("Digite o CPF do funcionario: ");
                    System.out.print("Digite o CPF do funcionario: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite o salario do funcionario: ");
                    System.out.print("Digite o salario do funcionario: ");
                    double salario = scanner.nextDouble();

                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.println("Digite o cargo do funcionario: ");
                    System.out.print("Digite o cargo do funcionario: ");
                    String cargo = scanner.nextLine();

                    Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
                    sistema.adicionarFuncionario(funcionario);

                    System.out.println("Funciona1rio cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Buscar Funcionário");
                    System.out.println("------------------");

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfBusca = scanner.nextLine();

                    Funcionario funcionarioEncontrado = sistema.buscarFuncionario(cpfBusca);
                    if (funcionarioEncontrado != null) {
                        System.out.println("Funcionário encontrado: " + funcionarioEncontrado.getNome());
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Remover Funcionário");
                    System.out.println("-------------------");

                    System.out.print("Digite o CPF do funcionário a ser removido: ");
                    String cpfRemocao = scanner.nextLine();

                    if (sistema.removerFuncionario(cpfRemocao)) {
                        System.out.println("Funcionário removido com sucesso.");
                    } else {
                        System.out.println("Funcionário não encontrado. Remoção não realizada.");
                    }
                    break;
                case 4:
                    System.out.println("Listar Funcionários");
                    System.out.println("-------------------");

                    List<Funcionario> listaFuncionarios = sistema.listarFuncionarios();
                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Não há funcionários cadastrados.");
                    } else {
                        for (Funcionario func : listaFuncionarios) {
                            System.out.println("Nome: " + func.getNome());
                            System.out.println("CPF: " + func.getCpf());
                            System.out.println("Salário: " + func.getSalario());
                            System.out.println("Cargo: " + func.getCargo());
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número válido.");
            }

            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }
}
