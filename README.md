API para Clínica de Psicologia
Este projeto é uma API REST desenvolvida em Java utilizando Spring Boot, com banco de dados PostgreSQL e documentação integrada com Swagger. A API tem como objetivo gerenciar informações de uma clínica de psicologia, permitindo operações de CRUD para psicólogos e pacientes.

🔹 Funcionalidades
Psicólogos:

GET /psicologas → Lista todos as psicólogas cadastrados.
POST /psicologa/save → Cadastra uma novo psicóloga.
DELETE /psicologa/{id} → Remove uma psicóloga pelo ID.

*
Pacientes:
GET /pacientes → Lista todos os pacientes cadastrados.
POST /pacientes → Cadastra um novo paciente.
DELETE /pacientes/{id} → Remove um paciente pelo ID.

🛠 Tecnologias Utilizadas
Java 17
Spring Boot 3
Spring Data JPA
PostgreSQL
Swagger (Springdoc OpenAPI)

📄 Documentação
A API é documentada automaticamente com o Swagger, permitindo testar os endpoints diretamente pelo navegador.

Acesse a documentação no navegador após rodar a aplicação:
🔗 http://localhost:8080/swagger-ui.html

Este projeto pode ser expandido para incluir autenticação, agendamentos de consultas, envio de notificações e outras funcionalidades conforme a necessidade da clínica. 🚀
