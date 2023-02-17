# Esse projeto foi criado com o intuito de demonstrar habilidades no uso da tecnologia Java e alguns plugins com foco em Back End.

# Temos dois end points no projeto:

* /v1/usuario: End point com o objetivo de efetuar um cadastro de usuário.
  * Contrato: {
                "nome": "nome",
                "email": "email",
                "cep": "cep"
              }

* /v1/consulta-endereco: End point com o objetivo de validar o cep e retornar dados complementares da API https://viacep.com.br/.
  * Contrato: {
                "cep": "cep"
              }
