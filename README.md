# sgemp-refactor

> **Projeto de estudo. O código aqui é legado e está sendo refatorado de propósito.**
> Não é um produto, não foi pensado para uso real e **não deve ser usado em produção**.

Este repositório é a cópia de trabalho do **SGEMP**, um ERP desktop (Swing + JDBC + MySQL/MariaDB) que escrevi em 2019, sem testes e sem preocupação com arquitetura. Ele nunca foi para produção. Hoje serve de laboratório: estou usando o código real, com os problemas reais dele, para aprender os princípios **SOLID** em Java, refatorando um passo de cada vez.

## A ideia

Escrevi este sistema em 2019, ainda aprendendo, e cometi vários erros de design: tudo misturado na tela, SQL colado em texto, conexão criada em qualquer lugar, nenhum teste. Em vez de jogar fora e recomeçar, vou **ir refatorando aos poucos e corrigindo os erros que cometi no passado**, mostrando cada correção. O código ruim fica à mostra de propósito: é dele que vem o aprendizado.

## O que é isto

- O código original foi mantido como estava, com poucas correções para rodar no Linux e com o Java atual.
- Cada princípio SOLID vira uma branch/commit identificável "antes e depois", para dar para ver a diferença.
- Antes de refatorar um trecho, escrevo um **teste de caracterização** que registra o que o código faz hoje. Só então mexo.
- Regra do estudo: só abstrair quando a dor aparece, para não cair em over-engineering.

## Estado atual

Estou no **Módulo 0** (preparar o ambiente e criar a rede de testes). Ainda **não** apliquei nenhum princípio SOLID.

| Módulo | Tema | Situação |
| --- | --- | --- |
| 0 | Ambiente e testes de caracterização | em andamento |
| 1 | SRP: responsabilidade única | a fazer |
| 2 | OCP: aberto/fechado | a fazer |
| 3 | LSP: substituição de Liskov | a fazer |
| 4 | ISP: segregação de interfaces | a fazer |
| 5 | DIP: inversão de dependência | a fazer |

A ordem é por fluxo vertical, começando pela **Venda** (`FrmVenda`), que mistura tela, SQL concatenado, numeração e cálculo.

## Problemas conhecidos (de propósito)

Estes são os problemas que quero resolver durante o estudo, então **não são bugs a reportar**:

- Telas gigantes que misturam interface, SQL e regra de negócio.
- SQL montado por concatenação de texto (risco de SQL injection).
- `new Conexao()` espalhado pelas telas e controles; `JOptionPane` dentro de classes de controle.
- Senha de usuário com MD5 sem salt.
- Nomes de tabela em maiúscula nas consultas: funcionam no Windows, mas quebram em MySQL/MariaDB no Linux.
- Nenhum teste automatizado.
- `Conexao` ainda tem `login`, `senha` e `porta` fixos no código (valores do banco local de estudo). O `config.xml` hoje só fornece `host` e `banco`. Passar o resto para o `config.xml` é a próxima correção.

## Como rodar (ambiente de estudo)

Requisitos: JDK (testado com 25) e um MySQL/MariaDB local. O build original é Ant (NetBeans).

1. **Banco:** o esquema e os dados **não estão neste repositório**. Você precisa de um banco `sgemp` com as tabelas esperadas pelo código.
2. **Configuração:** crie um `config.xml` **fora do repositório**, por exemplo `~/sgemp-config/config.xml`:

   ```xml
   <Servidor>
     <banco>sgemp</banco>
     <host>127.0.0.1</host>
     <porta>3306</porta>
     <login>root</login>
     <senha>SUA_SENHA</senha>
   </Servidor>
   ```

   Por enquanto só `host` e `banco` são lidos do arquivo; `login`, `senha` e `porta` estão fixos em `Conexao.java` e precisam bater com o seu banco local (veja "Problemas conhecidos"). Por padrão o código procura `~/sgemp-config/config.xml`. Para outro caminho, use `-Dsgemp.config=/caminho/config.xml`.
3. **VM options:** o XStream 1.4.7 usado aqui é de 2014 e precisa destas flags no Java 17+:

   ```
   --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.desktop/java.awt.font=ALL-UNNAMED
   ```
4. Classe principal: `visao.FrmLogin`.

## Estrutura

- `src/visao/`: telas Swing (28 classes)
- `src/controle/`: acesso a dados, regras e utilitários
- `src/modelo/`: classes de dados
- `lib/`: dependências em `.jar`
- `iReport/`: modelos de relatório

## Segurança

Este repositório é público. Os backups de banco, os binários compilados (`build/`, `dist/`) e arquivos locais da IDE **não são versionados**, e a senha de banco que existia no código original foi retirada. Não coloque credenciais reais em nenhum arquivo versionado.

## Registro do estudo

Cada etapa do estudo fica registrada nos commits e nas branches `estudo/*`.
