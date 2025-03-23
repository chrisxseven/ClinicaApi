<h1>API para Clínica de Psicologia</h1>
Este projeto é uma API REST desenvolvida em Java utilizando Spring Boot, com banco de dados PostgreSQL e documentação integrada com Swagger. A API tem como objetivo gerenciar informações de uma clínica de psicologia, permitindo operações de CRUD para psicólogos e pacientes.

🔹 Funcionalidades

Psicólogos:

GET /psicologas → Lista todos as psicólogas cadastrados.

GET /psicologa/id/{id} → Lista as psicólogas por id

POST /psicologa/save → Cadastra uma novo psicóloga.

DELETE /psicologa/delete/{id} → Remove uma psicóloga pelo ID.

Pacientes:

GET /pacientes → Lista todos os pacientes cadastrados.

GET /paciente/id/{id} → Lista os pacientes por id

POST /paciente/save → Cadastra um novo paciente.

DELETE /paciente/delete/{id} → Remove um paciente pelo ID.

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

![SharedScreenshot](https://github.com/user-attachments/assets/9a1810ff-8124-4783-8567-1b524eb65d9d)


