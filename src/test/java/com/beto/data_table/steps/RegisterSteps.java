package com.beto.data_table.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterSteps {

    private List<Map<String, String>> usuarios;
    private List<String> registrados;

    @Given("que eu tenha os seguintes detalhes do usuário:")
    public void queEuTenhaOsSeguintesDetalhesDoUsuario(DataTable dataTable) {
        usuarios = dataTable.asMaps(String.class, String.class);
        registrados = new ArrayList<>();
    }

    @When("eu tentar registrar os usuários")
    public void euTentarRegistrarOsUsuarios() {
        for (Map<String, String> usuario : usuarios) {
            int idade = Integer.parseInt(usuario.get("idade"));
            String nome = usuario.get("nome");
            if (idade >= 18) {
                registrados.add(nome);
            }
        }
    }

    @Then("apenas os usuários {string} devem ser registrados")
    public void apenasOsUsuariosDevemSerRegistrados(String nomesEsperados) {
        String[] nomesArray = nomesEsperados.split(", ");
        List<String> esperados = List.of(nomesArray);

        for (String nome : esperados) {
            if (!registrados.contains(nome)) {
                throw new AssertionError("Usuário " + nome + " deveria estar registrado.");
            }
        }

        for (String nome : registrados) {
            if (!esperados.contains(nome)) {
                throw new AssertionError("Usuário " + nome + " não deveria estar registrado.");
            }
        }
    }
}
