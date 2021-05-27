package scenarios;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.CarrinhoComprasPage;
import pages.DetalheProdutoPage;
import pages.HomePage;
import pages.PaginaCheckoutPage;
import pages.ResultadoDaBuscaPage;
import utils.LeitorDadosTeste;
import utils.PropertiesReader;

public class ScriptTesteEcommerce {
    private static final Logger logger = Logger.getLogger(ScriptTesteEcommerce.class);
    public PropertiesReader properties = new PropertiesReader();
    Properties prop;
    public LeitorDadosTeste dadosTeste = new LeitorDadosTeste();
    private WebDriver driver;

    @io.cucumber.java.Before
    public void beforeTest() throws Exception {
        prop = properties.getProp();

        logger.info("-- Inicio da Execução Cenário: ");
        logger.info("URL: " + dadosTeste.getData("url"));
        inicializarChromeDriver();

    }

    @After
    public void afterTest() {
        driver.quit();

    }

    // Cenário: Busca Produto
    @Dado("que o usuário esteja na pagina inicial")
    public void que_o_usuário_esteja_na_pagina_inicial() {
        try {
            abrirUrl(dadosTeste.getData("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Quando("realizar uma busca pelo produto")
    public void realizar_uma_busca_pelo_produto() {
        try {
            pesquisarProdutoHome(dadosTeste.getData("produto1"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Então("validar se produto retornou no resultado da busca: {string}")
    public void validar_se_produto_retornou_no_resultado_da_busca(String produto) {
        try {
            validarProdutoPesquisado(produto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }// Cenário: Busca Produto

    // Cenario: Adiciona Produto no Carrinho
    @Dado("selecionou um produto")
    public void selecionou_um_produto() {
        try {
            pesquisarProdutoHome(dadosTeste.getData("produto1"));
            clicarProdutoPesquisado(dadosTeste.getData("DescricaoProduto1"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Quando("clicar em comprar")
    public void clicar_em_comprar() {
        try {
            clicarComprar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Então("validar se produto foi adicionado ao carrinho de compras")
    public void validar_se_produto_foi_adicionado_ao_carrinho_de_compras() {
        CarrinhoComprasPage carrinhoComprasPage = new CarrinhoComprasPage();
        try {
            assertTrue(carrinhoComprasPage.validarProdutoCarrinhoCompras(driver, dadosTeste.getData("DescricaoProduto1")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Cenario: Adiciona Produto no Carrinho

    // Cenarios Altera a quantidade de um item do carrinho compras
    @Dado("que o usuário esteja no carrinho de compras")
    public void que_o_usuário_esteja_no_carrinho_de_compras() {
        try {
            abrirUrl(dadosTeste.getData("url"));
            pesquisarProdutoHome(dadosTeste.getData("produto1"));
            clicarProdutoPesquisado(dadosTeste.getData("DescricaoProduto1"));
            clicarComprar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Quando("alterar a quantidade de um item")
    public void alterar_a_quantidade_de_um_item() {
        try {
            alterarQuantidadeProduto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Então("validar se a quantidade é igual a : {int}")
    public void validar_se_a_quantidade_é_igual_a(Integer quantidade) {
        try {
            validarQuantidadeProduto(quantidade);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Cenarios Remover item do carrinho

    @Dado("que o usuário esteja no carrinho de compras com dois ou mais produtos diferentes")
    public void que_o_usuário_esteja_no_carrinho_de_compras_com_pelo_menos_produtos_diferentes() {
        try {
            abrirUrl(dadosTeste.getData("url"));
            pesquisarProdutoHome(dadosTeste.getData("produto1"));
            clicarProdutoPesquisado(dadosTeste.getData("DescricaoProduto1"));
            adicionarProduto();
            pesquisarProdutoHome(dadosTeste.getData("produto2"));
            clicarProdutoPesquisado(dadosTeste.getData("DescricaoProduto2"));
            clicarComprar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Quando("remover um item")
    public void remover_um_item() {
        try {
            removeProdutoCarrinho(dadosTeste.getData("DescricaoProduto2"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Então("validar se o item foi removido")
    public void validar_se_o_item_foi_removido() {
        try {
            validarQuantidadeProduto(1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Concluir a compra
    @Quando("Clicar em fazer Checkout")
    public void clicar_em_fazer_Checkout() {
        try {
            clicarEmFazerCheckout();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Quando("Preencher os dados")
    public void preencher_os_dados() {
        try {
            fazerLogin();
            selecionarEnderecoDeEntrega();
            selecionarPagamento();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Então("Validar se botão concluir compra está habilitado")
    public void validar_se_botão_concluir_compra_está_habilitado() {
        try {
            validarBotaoConcluirPedidoTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo clicar em comprar Produto
     *
     * @throws Exception
     */
    private void clicarComprar() throws Exception {
        logger.info("Clicando em comprar");
        DetalheProdutoPage detalheProdutoPage = new DetalheProdutoPage();
        detalheProdutoPage.adicionarAoCarrinho(driver);
        detalheProdutoPage.abrirCarrinhoCompras(driver);
    }

    /**
     * Metodo clicar em adicionar Produto
     *
     * @throws Exception
     */
    private void adicionarProduto() throws Exception {
        logger.info("Clicando em adicionar Produto");
        DetalheProdutoPage detalheProdutoPage = new DetalheProdutoPage();
        detalheProdutoPage.adicionarAoCarrinho(driver);
    }

    /**
     * Metodo clicar Carrinho de Compras
     *
     * @throws Exception
     */
    private void clicarCarrinho() throws Exception {
        logger.info("Clicando em carrinho");
        DetalheProdutoPage detalheProdutoPage = new DetalheProdutoPage();

        detalheProdutoPage.abrirCarrinhoCompras(driver);
    }

    /**
     * Validar Produto Pesquisado
     *
     * @param produtoPesquisado
     * @throws Exception
     */
    public void validarProdutoPesquisado(String produtoPesquisado) throws Exception {
        logger.info("Validar Produto Pesquisado");
        ResultadoDaBuscaPage resultadoBuscaPage = new ResultadoDaBuscaPage();

        assertTrue(resultadoBuscaPage.validarProdutoPesquisado(driver, produtoPesquisado));
    }

    /**
     * Clicar em Produto Pesquisado
     *
     * @param produto
     * @throws Exception
     */
    private void clicarProdutoPesquisado(String produto) throws Exception {
        logger.info("Clicando em Produto pesquisado");
        ResultadoDaBuscaPage resultadoBuscaPage = new ResultadoDaBuscaPage();
        resultadoBuscaPage.clicarProdutoBuscado(driver, produto);

    }

    /**
     * Pesquisar produto HOME
     *
     * @param produto
     * @throws Exception
     */
    public void pesquisarProdutoHome(String produto) throws Exception {
        logger.info("Pesquisar Produto");
        HomePage home = new HomePage();
        home.pesquisarProduto(driver, produto);

    }

    /**
     * Método para abrir uma URL enviada
     *
     * @param url
     */
    private void abrirUrl(String url) {
        driver.get(url);
    }

    /**
     * Inicializa ChromeDriver
     *
     * @throws IOException
     */
    private void inicializarChromeDriver() throws IOException {
        logger.info("Inicializando ChromeDrivers");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");


        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    /**
     * Retorna o path do json de dados de Testes
     *
     * @param
     * @return
     * @throws IOException
     */
    public String getDadosPath(Properties props) throws IOException {
        return props.getProperty("prop.dados");
    }

    /**
     * Método para alterar a quantidade do produto
     *
     * @throws Exception
     */
    private void alterarQuantidadeProduto() throws Exception {
        logger.info("Alterando Quanditade Produto");
        CarrinhoComprasPage carrinhoComprasPage = new CarrinhoComprasPage();

        carrinhoComprasPage.expandirListaQuantidadeCarrinhoCompras(driver);

        carrinhoComprasPage.selecionaQuantidadeCarrinhoCompras(driver);
    }

    /**
     * Método para remover produto do Carrinho de compras
     *
     * @throws Exception
     */
    private void removeProdutoCarrinho(String produto) throws Exception {
        logger.info("Remove Produto Carrinho");
        CarrinhoComprasPage carrinhoComprasPage = new CarrinhoComprasPage();

        carrinhoComprasPage.removeProdutoCarrinhoCompras(driver, produto);
    }

    /**
     * Método para validar a Quantidade do produto
     *
     * @param quantidade
     * @throws Exception
     */
    private void validarQuantidadeProduto(Integer quantidade) throws Exception {
        logger.info("Valida quantidade do Produto");
        CarrinhoComprasPage carrinhoComprasPage = new CarrinhoComprasPage();
        assertTrue("Erro ao validar quantidade!", carrinhoComprasPage.validarQuantidadeProdutoCarrinhoCompras(driver, quantidade));
    }

    /**
     * Metodo para clicar no botão fazer Checkout
     *
     * @throws Exception
     */
    private void clicarEmFazerCheckout() throws Exception {
        logger.info("Fazer checkout");
        CarrinhoComprasPage carrinhoComprasPage = new CarrinhoComprasPage();
        carrinhoComprasPage.fazerCheckoutCarrinhoCompras(driver);

    }

    /**
     * Clicar em concluir Tela Checkout
     *
     * @throws Exception
     */
    private void validarBotaoConcluirPedidoTela() throws Exception {
        logger.info("Validar botão concluir pedido");
        PaginaCheckoutPage paginaCheckoutPage = new PaginaCheckoutPage();
        assertTrue(paginaCheckoutPage.validarBotaoConfirmarPedido(driver));

    }

    /**
     * Selecionar Pagamento
     *
     * @throws Exception
     */
    private void selecionarPagamento() throws Exception {
        logger.info("Selecionando forma de Pagamento");
        PaginaCheckoutPage paginaCheckoutPage = new PaginaCheckoutPage();

        paginaCheckoutPage.clicarBoleto(driver);
        paginaCheckoutPage.clicarBoleto(driver);
        paginaCheckoutPage.clicarContinuarPagamento(driver);
    }

    /**
     * Selecionar endereco de entrega
     *
     * @throws Exception
     */
    private void selecionarEnderecoDeEntrega() throws Exception {
        logger.info("Selecionar endereço de entrega");
        PaginaCheckoutPage paginaCheckoutPage = new PaginaCheckoutPage();

        paginaCheckoutPage.clicarEnviarEsteEndereco(driver);
        paginaCheckoutPage.clicarContinuarEndereco(driver);
    }

    /**
     * Metodo para fazer Login
     *
     * @throws Exception
     */
    private void fazerLogin() throws Exception {
        logger.info("Fazer Login");
        PaginaCheckoutPage paginaCheckoutPage = new PaginaCheckoutPage();

        paginaCheckoutPage.preencherEmail(driver, dadosTeste.getData("email"));
        paginaCheckoutPage.preencherSenha(driver, dadosTeste.getData("senha"));
    }

    @Entao("Imprime na tela:")
    public void imprime_na_tela(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> mapDados = dataTable.asMaps(String.class, String.class);
        System.out.println(mapDados.get(0).get("Primeiro nome") + "\n");
        System.out.println(mapDados.get(0).get("Ultimo nome") + "\n");
        System.out.println(mapDados.get(0).get("Telefone") + "\n");
        System.out.println(mapDados.get(0).get("Password") + "\n");
        System.out.println(mapDados.get(0).get("Nascimento") + "\n");
        System.out.println(mapDados.get(0).get("Mes") + "\n");
        System.out.println(mapDados.get(0).get("Ano") + "\n");


    }


    @Entao("Imprime os animais na tela:")
    public void the_following_animals(List<String> animals) {

        for (String string : animals) {
            System.out.println(string);
        }
    }

    public void executeAllure() {

        String comand = "allure serve ./target/surefire-reports";
        try {
            Process exec = Runtime.getRuntime().exec("/System/Applications/Utilities/Terminal.app -n" + comand);

            InputStream in = exec.getInputStream();
            Scanner scan = new Scanner(in);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
