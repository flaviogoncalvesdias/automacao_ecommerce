# automacao_ecommerce
Repositório criado para automação de um e-commerce. Utilizando Java, Cucumber E Selenium. 

Pré-Requisitos para execução do projeto: 

1- Instalada e configurada JDK8; 
2- Instalado e configurado Maven versão 3.x ou superior;
3- Instalado e configurado Git;
4- Chromedriver compatível com o Sistema operacional e versão do chrome.  Para mais informações sobre as versões acesse: https://chromedriver.chromium.org/downloads


Configurações iniciais: 

1-  Baixar o projeto no repositório git, com o comando: git clone <nome_do_repositório>

2- Copiar o chromedriver(testado apenas com o chromedriver), para a Pasta raiz do Projeto; 
Por exemplo: salvou o projeto no diretório: "C:/Users/<Nome do Usuario>/Documentos/<projeto-automacao-ecommerce>", Copiar o ChromeDriver correspondente para o sistema operacional/versãoChome(Chrome versao 81. Chromedriver versão 81).
Com isso, a automação irá reconhecer o chomedriver, e utilizará, para as operações com o browser. 

Para executar o projeto via linha de comando com MAVEN: 

1- Baixe o projeto do github;

2- No diretório raiz do projeto(Que foi baixado do github)   "C:/Users/Documents/automacao_ecommerce"; 

3- Execute o comando:   mvn clean install

4- Depois execute o comando:  mvn -Dtest=RunnerWeb test



Para executar o projeto via IDE Eclipse: 

1- Importe o projeto como um maven project; 
2- De o comando Alt+F5, para atualizar as bibliotecas maven;
3-No Diretório: automacao_ecommerce/src/test/resources/features/
2- Abra o arquivo: teste_ecommerce_bdd.feature
3- Clique em RUN, que automaticamente a ide irá executar 



Outras informações: 

1- O projeto irá utilizar as bibliotecas maven configuradas no ".pom" do projeto: 
	4.1 Cucumber, Log4j, selenium-java, junit e json-simple

2- O Projeto está armazenando algumas informações pertinentes aos testes, no arquivo dadosTestes.json. 




