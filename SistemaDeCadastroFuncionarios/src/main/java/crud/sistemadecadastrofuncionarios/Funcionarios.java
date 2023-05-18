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

public class Funcionarios {
    private List<Funcionario> funcionarios;

    public Funcionarios() {
        funcionarios = new ArrayList<>();
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
