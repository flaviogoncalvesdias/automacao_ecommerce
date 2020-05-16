# automacao_ecommerce
Repositório criado para automação de um e-commerce. Utilizando Java, Cucumber E Selenium. 

Pré-Requisitos para execução do proejto: 

1- Instalada e configurada JDK8; 
2- Instalado e configurado Maven versão 3.x ou superior.
3- Chromedriver compatível com o Sistema operacional e versão do chrome.  Para mais informações sobre as versões acesse: https://chromedriver.chromium.org/downloads

Configurações iniciais: 

1- Dentro do projeto, no diretório: "src/test/resources". Editar o arquivo "config.properties";
2- Alterar o valor da a chave: "prop.chromedriver.path" para o diretório onde se encontra o chromedriver(o projeto foi testado apenas com o chromedriver); 
Por exemplo: 

prop.chromedriver.path = "/Users/mac/Documents/drive/chromedriver.exe"  

OU 

prop.chromedriver.path = "C:/drive/chromedriver.exe"

