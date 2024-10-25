Feature: Registro de Usuário

  Scenario: Permitir registro apenas para usuários acima de 18 anos
    Given que eu tenha os seguintes detalhes do usuário:
      | nome       | idade |
      | João       | 20    |
      | Maria      | 17    |
      | Carlos     | 19    |
    When eu tentar registrar os usuários
    Then apenas os usuários "João, Carlos" devem ser registrados
