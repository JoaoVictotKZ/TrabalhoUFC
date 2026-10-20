# 🥊 Gerenciador de Torneios UFC

🌐 **Idiomas:** 🇧🇷 Português · [🇺🇸 English](README.en.md) · [🇪🇸 Español](README.es.md)

Aplicação de console em **Java** para cadastrar lutadores, montar torneios no formato **mata-mata** (eliminatória simples) por categoria de peso e simular os combates até a definição de um campeão.

O projeto foi desenvolvido como trabalho acadêmico e tem foco em **Programação Orientada a Objetos**: encapsulamento, validação de dados, tratamento de exceções e organização de responsabilidades em classes.

---

## 📋 Índice

- [Funcionalidades](#-funcionalidades)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como funciona](#-como-funciona)
- [Requisitos](#-requisitos)
- [Como compilar e executar](#-como-compilar-e-executar)
- [Exemplo de uso](#-exemplo-de-uso)
- [Regras e validações](#-regras-e-validações)
- [Possíveis melhorias](#-possíveis-melhorias)
- [Autores](#-autores)

---

## ✨ Funcionalidades

- Menu interativo no terminal para cadastrar torneios por categoria (**Leve**, **Médio** e **Pesado**).
- Criação de **vários torneios** na mesma execução, cada um com sua própria lista de lutadores.
- Cadastro de lutadores com **validação completa** de nome, idade e peso.
- Aceita peso com **vírgula ou ponto** (`70,5` ou `70.5`).
- Classificação **automática** da categoria a partir do peso.
- Chaveamento mata-mata com fases sucessivas até restar um único campeão.
- Registro de **vitórias e derrotas** de cada lutador ao longo do torneio.

---

## 🗂 Estrutura do projeto

Todas as classes pertencem ao pacote `TrabalhoJava`.

```
TrabalhoJava/
├── Lutador.java            # Entidade que representa um lutador
├── Luta.java               # Combate entre dois lutadores
├── EstruturaMataMata.java  # Gerencia as fases e o chaveamento do torneio
├── TestesMainUFC.java      # Rascunho da Classe principal (main) com menu e cadastro, além de outros testes implementados
└── UFC.java                # Classe Principal (main) com o projeto completo 
```

| Classe | Responsabilidade |
|---|---|
| **`Lutador`** | Guarda nome, idade, peso, vitórias e derrotas. Calcula a categoria pelo peso e expõe `registrarVitorias()` / `registrarDerrotas()`. |
| **`Luta`** | Recebe dois lutadores, valida se podem lutar entre si, sorteia o vencedor e atualiza o cartel de ambos. |
| **`EstruturaMataMata`** | Recebe a lista de lutadores e o nome do torneio, valida a chave e conduz as fases até o campeão. |
| **`TestesMainUFC`** | Ponto de entrada do programa, uma classe para testes até a versão final na main com menu, leitura e validação dos dados digitados pelo usuário. |
| **`UFC`** | classe principal aonde vai rodar o sistema pronto com tudo já testado.

---

## ⚙️ Como funciona

1. O usuário escolhe uma categoria no menu e informa **quantos torneios** quer criar nela.
2. Para cada torneio, informa **quantos lutadores** participam (precisa ser potência de dois: 2, 4, 8, 16…).
3. Cadastra cada lutador (nome, idade e peso). Se o peso não corresponder à categoria do torneio, o programa pede o cadastro novamente.
4. Ao escolher **"Iniciar todos os torneios"**, cada torneio é executado em sequência:
   - Os lutadores são emparelhados de dois em dois, na ordem em que foram cadastrados.
   - Cada `Luta` sorteia o vencedor, que avança para a próxima fase.
   - O processo se repete até restar apenas um lutador: o **campeão**.

### Categorias de peso

| Categoria | Faixa de peso |
|---|---|
| Leve | até 70,0 kg |
| Médio | acima de 70,0 kg até 84,0 kg |
| Pesado | acima de 84,0 kg |

### Menu principal

| Opção | Ação |
|---|---|
| `1` | Adicionar torneio(s) da categoria **Leve** |
| `2` | Adicionar torneio(s) da categoria **Médio** |
| `3` | Adicionar torneio(s) da categoria **Pesado** |
| `4` | Iniciar todos os torneios cadastrados e sair do menu |
| `0` | Cancelar e encerrar o programa |

---

## 📦 Requisitos

- **JDK 8** ou superior.
- Um terminal ou uma IDE (Eclipse, IntelliJ IDEA, VS Code, NetBeans…).

Não há dependências externas: o projeto usa somente a biblioteca padrão do Java.

---

## 🚀 Como compilar e executar

### Pelo terminal

Como as classes estão no pacote `TrabalhoJava`, os arquivos `.java` devem ficar dentro de uma pasta com esse nome. Execute os comandos a partir da pasta **pai** dela:

```bash
# Compilar
javac TrabalhoJava/*.java

# Executar
java TrabalhoJava.TestesMainUFC
```

### Pela IDE

1. Crie um projeto Java e adicione os arquivos ao pacote `TrabalhoJava`.
2. Execute a classe `TestesMainUFC` (ela contém o método `main`).

---

## 💡 Exemplo de uso

> Exemplo ilustrativo; o vencedor de cada luta é aleatório, então o resultado muda a cada execução.

```
===========================================
 BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC
===========================================

--- MENU DE CADASTRO ---
1 - Adicionar Torneio(s) categoria LEVE
2 - Adicionar Torneio(s) categoria MÉDIO
3 - Adicionar Torneio(s) categoria PESADO
4 - INICIAR TODOS OS TORNEIOS E SAIR
0 - Cancelar e Sair do Programa
Escolha uma opção: 1

Quantos torneios da categoria LEVE deseja gerar? 1
Quantos Lutadores no torneio LEVE 1? (Digite 2, 4, 8, 16, etc.): 2

-- Cadastrando Lutador 1 de 2 --
Nome do Lutador: Carlos Silva
Idade (18 a 45 anos): 27
Peso (Ex: 70.5 ou 70,5): 68,5
>> Lutador Carlos Silva cadastrado com sucesso!

...

===================================
    INÍCIO DO TORNEIO MATA-MATA
===================================

--- FASE 1 ---
Combate: Carlos Silva VS João Souza
-> Vencedor: Carlos Silva

===================================
 CAMPEÃO DO TORNEIO
Carlos Silva | 27 anos | 68,5 kg | Leve | 1V - 0D
===================================
```

---

## ✅ Regras e validações

| Campo / Situação | Regra |
|---|---|
| **Nome** | Somente letras (com acentos) e espaços; não pode ficar em branco. |
| **Idade** | Número inteiro entre **18 e 45** anos. |
| **Peso** | Número decimal; aceita `,` ou `.` como separador. |
| **Categoria do lutador** | Deve ser igual à categoria do torneio; caso contrário, o cadastro é refeito. |
| **Quantidade de lutadores** | Potência de dois (2, 4, 8, 16…). |
| **Quantidade de torneios** | Inteiro maior ou igual a zero. |
| **Luta** | Um lutador não pode enfrentar a si mesmo, e os dois precisam ser da mesma categoria (`IllegalArgumentException` em caso contrário). |
| **Entradas do menu** | Texto ou números inválidos são tratados com mensagem de erro, sem encerrar o programa. |

---

## 🔭 Possíveis melhorias

- Substituir o sorteio puro (`Random.nextBoolean()`) por um critério que considere o cartel de vitórias/derrotas.
- Adicionar testes automatizados (JUnit) para `Lutador`, `Luta` e `EstruturaMataMata`.
- Permitir embaralhar o chaveamento em vez de seguir a ordem de cadastro.
- Exibir um resumo/ranking final com o cartel de todos os lutadores.
- Salvar e carregar torneios em arquivo.
- Criar uma interface gráfica (Swing/JavaFX).

---

## 👥 Autores

Projeto desenvolvido como trabalho acadêmico.

- Gabriel Victor Silva dos Santos
- João Victor Silva Lima

Docente: Lucas José de Faria

[README.en.md](https://github.com/user-attachments/files/33700331/README.en.md)

# 🥊 UFC Tournament Manager

🌐 **Languages:** [🇧🇷 Português](README.md) · 🇺🇸 English · [🇪🇸 Español](README.es.md)

A **Java** console application for registering fighters, building **single-elimination (knockout)** tournaments by weight class, and simulating the bouts until a champion is crowned.

This project was developed as a university assignment and focuses on **Object-Oriented Programming**: encapsulation, input validation, exception handling, and a clear separation of responsibilities between classes.

---

## 📋 Table of Contents

- [Features](#-features)
- [Project Structure](#-project-structure)
- [How It Works](#-how-it-works)
- [Requirements](#-requirements)
- [Build and Run](#-build-and-run)
- [Usage Example](#-usage-example)
- [Rules and Validations](#-rules-and-validations)
- [Possible Improvements](#-possible-improvements)
- [Authors](#-authors)

---

## ✨ Features

- Interactive terminal menu to set up tournaments by weight class (**Light**, **Middle**, and **Heavy**).
- Create **multiple tournaments** in a single run, each with its own list of fighters.
- Fighter registration with **full validation** of name, age, and weight.
- Weight input accepts **a comma or a dot** (`70,5` or `70.5`).
- **Automatic** weight-class assignment based on weight.
- Knockout bracket with successive rounds until a single champion remains.
- **Win/loss record** tracked for each fighter throughout the tournament.

> **Note:** the code and its console messages are written in Portuguese (class names, menus, and prompts). Weight classes appear in the program as `Leve` (Light), `Médio` (Middle), and `Pesado` (Heavy).

---

## 🗂 Project Structure

All classes belong to the `TrabalhoJava` package.

```
TrabalhoJava/
├── Lutador.java            # Entity representing a fighter
├── Luta.java               # A bout between two fighters
├── EstruturaMataMata.java  # Manages the rounds and bracket of the tournament
├── TestesMainUFC.java      # Draft of the Main class with menu and registration plus other implemented tests
└── UFC.java                # Main Class (all content is a Alpha Project)
```

| Class | Responsibility |
|---|---|
| **`Lutador`** | Stores name, age, weight, wins, and losses. Determines the weight class and exposes `registrarVitorias()` / `registrarDerrotas()` (register win / loss). |
| **`Luta`** | Takes two fighters, checks that they are allowed to fight each other, randomly picks the winner, and updates both records. |
| **`EstruturaMataMata`** | Takes the list of fighters and the tournament name, validates the bracket, and runs the rounds until a champion emerges. |
| **`TestesMainUFC`** | Program entry point, a testing class used until the final version of the main class, with the menu, plus reading and validating user input. |
| **`UFC`** | Main class where the finished system will run, once everything has been tested. |

---

## ⚙️ How It Works

1. The user picks a weight class from the menu and says **how many tournaments** to create for it.
2. For each tournament, the user enters **how many fighters** take part (must be a power of two: 2, 4, 8, 16…).
3. Each fighter is registered (name, age, and weight). If the weight doesn't match the tournament's class, the program asks for the data again.
4. When the user chooses **"Start all tournaments"**, each tournament runs in sequence:
   - Fighters are paired two by two, in registration order.
   - Each `Luta` (bout) randomly selects a winner, who advances to the next round.
   - This repeats until only one fighter is left: the **champion**.

### Weight Classes

| Class (in the program) | Weight range |
|---|---|
| Light (`Leve`) | up to 70.0 kg |
| Middle (`Médio`) | above 70.0 kg up to 84.0 kg |
| Heavy (`Pesado`) | above 84.0 kg |

### Main Menu

| Option | Action |
|---|---|
| `1` | Add tournament(s) in the **Light** class |
| `2` | Add tournament(s) in the **Middle** class |
| `3` | Add tournament(s) in the **Heavy** class |
| `4` | Start all registered tournaments and leave the menu |
| `0` | Cancel and exit the program |

---

## 📦 Requirements

- **JDK 8** or higher.
- A terminal or an IDE (Eclipse, IntelliJ IDEA, VS Code, NetBeans…).

There are no external dependencies: the project only uses the Java standard library.

---

## 🚀 Build and Run

### From the terminal

Since the classes are in the `TrabalhoJava` package, the `.java` files must sit inside a folder with that name. Run the commands from that folder's **parent** directory:

```bash
# Compile
javac TrabalhoJava/*.java

# Run
java TrabalhoJava.TestesMainUFC
```

### From an IDE

1. Create a Java project and add the files to the `TrabalhoJava` package.
2. Run the `TestesMainUFC` class (it contains the `main` method).

---

## 💡 Usage Example

> Illustrative example only. Each bout's winner is random, so results change on every run. Prompts are shown in Portuguese, as in the program.

```
===========================================
 BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC
===========================================

--- MENU DE CADASTRO ---
1 - Adicionar Torneio(s) categoria LEVE
2 - Adicionar Torneio(s) categoria MÉDIO
3 - Adicionar Torneio(s) categoria PESADO
4 - INICIAR TODOS OS TORNEIOS E SAIR
0 - Cancelar e Sair do Programa
Escolha uma opção: 1

Quantos torneios da categoria LEVE deseja gerar? 1
Quantos Lutadores no torneio LEVE 1? (Digite 2, 4, 8, 16, etc.): 2

-- Cadastrando Lutador 1 de 2 --
Nome do Lutador: Carlos Silva
Idade (18 a 45 anos): 27
Peso (Ex: 70.5 ou 70,5): 68,5
>> Lutador Carlos Silva cadastrado com sucesso!

...

===================================
    INÍCIO DO TORNEIO MATA-MATA
===================================

--- FASE 1 ---
Combate: Carlos Silva VS João Souza
-> Vencedor: Carlos Silva

===================================
 CAMPEÃO DO TORNEIO
Carlos Silva | 27 anos | 68,5 kg | Leve | 1V - 0D
===================================
```

---

## ✅ Rules and Validations

| Field / Situation | Rule |
|---|---|
| **Name** | Letters only (accents allowed) and spaces; cannot be blank. |
| **Age** | Integer between **18 and 45**. |
| **Weight** | Decimal number; `,` or `.` accepted as the separator. |
| **Fighter's weight class** | Must match the tournament's class; otherwise the registration is repeated. |
| **Number of fighters** | Power of two (2, 4, 8, 16…). |
| **Number of tournaments** | Integer greater than or equal to zero. |
| **Bout** | A fighter cannot face themselves, and both must be in the same weight class (`IllegalArgumentException` otherwise). |
| **Menu input** | Invalid text or numbers are handled with an error message, without crashing the program. |

---

## 🔭 Possible Improvements

- Replace the pure coin-flip (`Random.nextBoolean()`) with logic that takes the win/loss record into account.
- Add automated tests (JUnit) for `Lutador`, `Luta`, and `EstruturaMataMata`.
- Allow shuffling the bracket instead of following registration order.
- Show a final summary/ranking with every fighter's record.
- Save and load tournaments from a file.
- Build a graphical interface (Swing/JavaFX).

---

## 👥 Authors

Developed as a university assignment.

- Gabriel Victor Silva dos Santos
- João Victor Silva Lima

Instructor: Lucas José de Faria


[README.es.md](https://github.com/user-attachments/files/33700474/README.es.md)# 🥊 Gestor de Torneos UFC

🌐 **Idiomas:** [🇧🇷 Português](README.md) · [🇺🇸 English](README.en.md) · 🇪🇸 Español

Aplicación de consola en **Java** para registrar luchadores, armar torneos de **eliminación directa** (formato mata-mata) por categoría de peso y simular los combates hasta coronar a un campeón.

El proyecto fue desarrollado como trabajo académico y se centra en la **Programación Orientada a Objetos**: encapsulamiento, validación de datos, manejo de excepciones y una clara separación de responsabilidades entre clases.

---

## 📋 Índice

- [Funcionalidades](#-funcionalidades)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Cómo funciona](#-cómo-funciona)
- [Requisitos](#-requisitos)
- [Cómo compilar y ejecutar](#-cómo-compilar-y-ejecutar)
- [Ejemplo de uso](#-ejemplo-de-uso)
- [Reglas y validaciones](#-reglas-y-validaciones)
- [Posibles mejoras](#-posibles-mejoras)
- [Autores](#-autores)

---

## ✨ Funcionalidades

- Menú interactivo en la terminal para crear torneos por categoría (**Ligero**, **Medio** y **Pesado**).
- Creación de **varios torneos** en una misma ejecución, cada uno con su propia lista de luchadores.
- Registro de luchadores con **validación completa** de nombre, edad y peso.
- Acepta el peso con **coma o punto** (`70,5` o `70.5`).
- Clasificación **automática** de la categoría a partir del peso.
- Cuadro de eliminación directa con fases sucesivas hasta que quede un único campeón.
- Registro de **victorias y derrotas** de cada luchador a lo largo del torneo.

> **Nota:** el código y sus mensajes de consola están escritos en portugués (nombres de clases, menús y textos). Las categorías aparecen en el programa como `Leve` (Ligero), `Médio` (Medio) y `Pesado` (Pesado).

---

## 🗂 Estructura del proyecto

Todas las clases pertenecen al paquete `TrabalhoJava`.

```
TrabalhoJava/
├── Lutador.java            # Entidad que representa a un luchador
├── Luta.java               # Combate entre dos luchadores
├── EstruturaMataMata.java  # Gestiona las fases y el cuadro del torneo
├── TestesMainUFC.java      # Borrador de la clase principal (main) con menú y registro, además de otras pruebas implementadas
└── UFC.java                # El alpha del proyecto (todo el contenido vaya testado)
```

| Clase | Responsabilidad |
|---|---|
| **`Lutador`** | Guarda nombre, edad, peso, victorias y derrotas. Calcula la categoría según el peso y expone `registrarVitorias()` / `registrarDerrotas()` (registrar victoria / derrota). |
| **`Luta`** | Recibe dos luchadores, valida que puedan enfrentarse, sortea al ganador y actualiza el récord de ambos. |
| **`EstruturaMataMata`** | Recibe la lista de luchadores y el nombre del torneo, valida el cuadro y conduce las fases hasta el campeón. |
| **`TestesMainUFC`** | Punto de entrada del programa, una clase de pruebas hasta la versión final del main, con el menú, la lectura y la validación de los datos ingresados por el usuario. |
| **`UFC`** | Clase principal donde se ejecutará el sistema terminado, una vez que todo esté probado. |

---

## ⚙️ Cómo funciona

1. El usuario elige una categoría en el menú e indica **cuántos torneos** quiere crear en ella.
2. Para cada torneo, indica **cuántos luchadores** participan (debe ser potencia de dos: 2, 4, 8, 16…).
3. Registra a cada luchador (nombre, edad y peso). Si el peso no corresponde a la categoría del torneo, el programa pide los datos nuevamente.
4. Al elegir **"Iniciar todos los torneos"**, cada torneo se ejecuta en secuencia:
   - Los luchadores se emparejan de dos en dos, en el orden en que fueron registrados.
   - Cada `Luta` (combate) sortea al ganador, que avanza a la siguiente fase.
   - El proceso se repite hasta que queda un solo luchador: el **campeón**.

### Categorías de peso

| Categoría (en el programa) | Rango de peso |
|---|---|
| Ligero (`Leve`) | hasta 70,0 kg |
| Medio (`Médio`) | más de 70,0 kg hasta 84,0 kg |
| Pesado (`Pesado`) | más de 84,0 kg |

### Menú principal

| Opción | Acción |
|---|---|
| `1` | Agregar torneo(s) de la categoría **Ligero** |
| `2` | Agregar torneo(s) de la categoría **Medio** |
| `3` | Agregar torneo(s) de la categoría **Pesado** |
| `4` | Iniciar todos los torneos registrados y salir del menú |
| `0` | Cancelar y cerrar el programa |

---

## 📦 Requisitos

- **JDK 8** o superior.
- Una terminal o un IDE (Eclipse, IntelliJ IDEA, VS Code, NetBeans…).

No hay dependencias externas: el proyecto usa únicamente la biblioteca estándar de Java.

---

## 🚀 Cómo compilar y ejecutar

### Desde la terminal

Como las clases están en el paquete `TrabalhoJava`, los archivos `.java` deben estar dentro de una carpeta con ese nombre. Ejecuta los comandos desde la carpeta **superior** a ella:

```bash
# Compilar
javac TrabalhoJava/*.java

# Ejecutar
java TrabalhoJava.TestesMainUFC
```

### Desde un IDE

1. Crea un proyecto Java y agrega los archivos al paquete `TrabalhoJava`.
2. Ejecuta la clase `TestesMainUFC` (contiene el método `main`).

---

## 💡 Ejemplo de uso

> Ejemplo ilustrativo. El ganador de cada combate es aleatorio, por lo que el resultado cambia en cada ejecución. Los mensajes se muestran en portugués, como en el programa.

```
===========================================
 BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC
===========================================

--- MENU DE CADASTRO ---
1 - Adicionar Torneio(s) categoria LEVE
2 - Adicionar Torneio(s) categoria MÉDIO
3 - Adicionar Torneio(s) categoria PESADO
4 - INICIAR TODOS OS TORNEIOS E SAIR
0 - Cancelar e Sair do Programa
Escolha uma opção: 1

Quantos torneios da categoria LEVE deseja gerar? 1
Quantos Lutadores no torneio LEVE 1? (Digite 2, 4, 8, 16, etc.): 2

-- Cadastrando Lutador 1 de 2 --
Nome do Lutador: Carlos Silva
Idade (18 a 45 anos): 27
Peso (Ex: 70.5 ou 70,5): 68,5
>> Lutador Carlos Silva cadastrado com sucesso!

...

===================================
    INÍCIO DO TORNEIO MATA-MATA
===================================

--- FASE 1 ---
Combate: Carlos Silva VS João Souza
-> Vencedor: Carlos Silva

===================================
 CAMPEÃO DO TORNEIO
Carlos Silva | 27 anos | 68,5 kg | Leve | 1V - 0D
===================================
```

---

## ✅ Reglas y validaciones

| Campo / Situación | Regla |
|---|---|
| **Nombre** | Solo letras (con acentos) y espacios; no puede estar en blanco. |
| **Edad** | Número entero entre **18 y 45** años. |
| **Peso** | Número decimal; acepta `,` o `.` como separador. |
| **Categoría del luchador** | Debe coincidir con la categoría del torneo; de lo contrario, se repite el registro. |
| **Cantidad de luchadores** | Potencia de dos (2, 4, 8, 16…). |
| **Cantidad de torneos** | Entero mayor o igual a cero. |
| **Combate** | Un luchador no puede enfrentarse a sí mismo, y ambos deben ser de la misma categoría (`IllegalArgumentException` en caso contrario). |
| **Entradas del menú** | Texto o números inválidos se manejan con un mensaje de error, sin cerrar el programa. |

---

## 🔭 Posibles mejoras

- Reemplazar el sorteo puro (`Random.nextBoolean()`) por un criterio que considere el récord de victorias/derrotas.
- Agregar pruebas automatizadas (JUnit) para `Lutador`, `Luta` y `EstruturaMataMata`.
- Permitir mezclar el cuadro en lugar de seguir el orden de registro.
- Mostrar un resumen/ranking final con el récord de todos los luchadores.
- Guardar y cargar torneos desde un archivo.
- Crear una interfaz gráfica (Swing/JavaFX).

---

## 👥 Autores

Proyecto desarrollado como trabajo académico.

- Gabriel Victor Silva dos Santos
- João Victor Silva Lima

Docente: Lucas José de Faria

