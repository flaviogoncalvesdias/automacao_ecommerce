# automacao_ecommerce
Repositório criado para automação de um e-commerce. Utilizando Java, Cucumber E Selenium. 

Pré-Requisitos para execução do proejto: 

1- Instalada e configurada JDK8; 
2- Instalado e configurado Maven versão 3.x ou superior.
3- Chromedriver compatível com o Sistema operacional e versão do chrome.  Para mais informações sobre as versões acesse: https://chromedriver.chromium.org/downloads
4- Será utilizada as bibliotecas maven configuradas no ".pom" do projeto: 
	4.1 Cucumber, Log4j, selenium-java, junit e json-simple

Configurações iniciais: 

1-  Copiar o chromedriver(o projeto foi testado apenas com o chromedriver), para a Pasta raiz do Projeto; 
Por exemplo: copiar o chrome driver para o diretório: "C:/Users/<Nome do Usuario>/Documentos/<projeto-automacao-ecommerce>"
Com isso, a automação irá reconhecer o chomedriver, e utilizará, para as operações com o browser. 


Para executar o projeto via linha de comando com MAVEN: 

1- Baixe o projeto do github;

2- No diretório raiz do projeto(Que foi baixado do github)   "C:/Users/Documents/automacao_ecommerce"; 

3- Execute o comando:   mvn clean install

4- Depois execute o comando:  mvn -Dtest=RunnerTest test



Para executar o projeto via IDE Eclipse: 

1- Importe o projeto como um maven project; 
2- De o comando Alt+F5, para atualizar as bibliotecas maven;
3-No Diretório: automacao_ecommerce/src/test/resources/features/
2- Abra o arquivo: teste_ecommerce_bdd.feature
3- Clique em RUN, que automaticamente a ide irá executar 




