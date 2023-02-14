
## História de Usuário: Login no Sistema
Como usuário, eu quero poder fazer login no sistema para ter acesso às minhas informações pessoais.

### Requisitos
- O usuário deve ser capaz de inserir seu nome de usuário e senha
- O sistema deve validar as credenciais do usuário e permitir o acesso à sua conta caso as credenciais sejam válidas
- O usuário deve ser notificado se houver erro na validação das credenciais

### Critérios de Aceitação
- O usuário é redirecionado para a tela inicial após inserir corretamente seu nome de usuário e senha
- A mensagem de erro é exibida se o nome de usuário ou senha estiver incorreto
- O sistema deve permitir que o usuário tente novamente o login após a exibição da mensagem de erro


## História de Professor: Visualizar alunos matriculados
Com professor eu quero visualizar os alunos matriculados na discilinas que ministro.
### Requisitos
- O sistema deve apresentar na tela inicial do professor a função de acesso às listas de alunos matriculados.
- O professor será redirecionado a uma tela de visualização das listas dos alunos que estão matriculados em cada disciplina.
- O professor  pode visualizar o relatório com os nomes dos alunos matriculados em suas respectivas disciplinas.

### Critérios de Aceitação
- A função de exibir lista de alunos deve está disponivel quando o usuário fizer acesso como professor ( secretária tbém? )
- As listas estão disponíveis qdo já tiverem mais de 3 alunos matriculados.
- O professor recebe notificação qdo faz acesso e não há alunos matriculados.
- O professor seleciona a lista que deseja visualizar.


## História de Secretária: Gerar curriculo
Como secretária da universidade eu devo poder gerar curriculo para cada semestre.
### Requisitos
- O sistema deve permitir criar curriculo contendo as matérias para cada semestre.

### Critérios de Aceitação
- O sistema permite entrada de dados sobre as disciplinas para cada semestre.

- O sistema cria os curriculos semestrais para os cursos.


## História de Secretáriar: Criar
....
### Requisitos
....
### Critérios de Aceitação
....


## História de Secretária: Monitorar matrículas
Como secretária da universidade eu devo poder  manter as informações sobre as disciplinas, professores e alunos atualizadas.
### Requisitos
- O sistema deve exibir e permitir alterar informações sobre as discilinas.
- O sistema deve exibir e permitir alterar  informações sobre os professores.
- O sistema deve exibir e permitir alterar  informações sobre os alunos.

### Critérios de Aceitação

- O sistema exibe e altera informações sobre as disciplinas.
- O sistema exibe e altera informações sobre os professores.
- O sistema exibe e altera informações sobre os alunos.


## História de Aluno: Fazer matrícula
Como aluno eu espero poder fazer matricula nas disciplinas obrigatórias e escoher as disciplinas opcionais.
### Requisitos
- O sistema deve permitir ao aluno efetuar a matricula nas disciplinas obrigatórias do curriculo.
- O sistema deve permitir o aluno escolher e se matricular nas matérias opcionais do curriculo.
### Critérios de Aceitação
- O sitema deve validar o período de matrícula.
- O sistema verifica e valida a matrícula nas disciplinas obrigatórias.
- O sistema verifica e valida a quantidade de matrículas nas disciplinas opcionais.


## História de Aluno: Cancela matrícula
Como aluno eu espero poder cancelar as matriculas nas disciplinas obrigatórias e opcionais.
### Requisitos
- O Sitema deve permitir o cancelamento das matrículas obrigatórias e opcionais.

### Critérios de Aceitação
- O sistema valida o periodo de cancelamento de matrícula.
- O sistema permite o cancelamento das matrículas nas disiplinas obrigatórias e opcionais.

