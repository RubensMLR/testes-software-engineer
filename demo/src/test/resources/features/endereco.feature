#language: pt

Funcionalidade: Validando Classe EnderecoController

  Cenario: Passando cep válido
    Quando que eu faço um POST em /v1/consulta-endereco passando o seguinte docstring:
    |cep|29165827|
    Então o controller me retorna o json de acordo com contrato.


  Cenario: Passando cep com espaço
    Quando que eu faço um POST em /v1/consulta-endereco passando o seguinte docstring:
      |cep|29165827 |
    Então o controller deve me retornar um erro.


  Cenario: Passando cep com mais de 8 dígitos
    Quando que eu faço um POST em /v1/consulta-endereco passando o seguinte docstring:
      |cep|291658279|
    Então o controller deve me retornar um erro.


  Cenario: Passando cep com menos de 8 dígitos
    Quando que eu faço um POST em /v1/consulta-endereco passando o seguinte docstring:
      |cep|2916582|
    Então o controller deve me retornar um erro.
