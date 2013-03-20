<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-03.transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head> 
        <title>BOX Games</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX Games | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
    </head>
    <body>
        <div id="contopmenu">            
            <div id="toptotal">
                

                <div id="topmenu">

                    <ul>  
                        <li> <a href="central.html">Central de Atendimento</a></li>
                        <li><a href="pedidos.html">Nossas Lojas</a></li>
                        <li> <a href="cadastro.jsp">Cadastro</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="index.jsp">Home</a></li>
                    </ul>
                </div> 

                <div id="cart">
                    <p class="carticone"></p>
                    <a href="/site/carrinho.aspx" class="cartLink">
                        <span>Carrinho</span>
                        <span class="">0</span>
                        <span class="" style="display: none;">Item</span>
                        <span class="" style="display: block;">Itens</span>
                        <span>R$</span>
                        <span class="">0,00</span></a>             
                </div>

            </div>
        </div>

        <div id="Banner">

            <a href="index.jsp"><img
                    src="images/logo-oficial1.png" alt="logo"
                    style="width: 190px; height: 130px; margin: 0 auto; margin-top: 0px;margin-left:15px; float: left;"/>

            </a> 	

        </div>
        <div id="bgmenu">     


            <div id="menu">
                <ul>
                    <li> <a href="">GENEROS</a>
                        <ul>
                            <li> <a href="#"> Aventura</a></li>
                            <li> <a href="#">Esportes</a></li>
                            <li> <a href="#"> Aventura</a></li>
                            <li> <a href="#">Esportes</a></li>
                            <li> <a href="#">Aventura</a></li>
                            <li> <a href="#">Esportes</a></li>
                        </ul></li>                
                    <li> <a href="ps3.html">PlayStation 3</a></li>
                    <li><a href="xbox.html">XBOX 360</a></li>
                    <li><a href="wii.html">Nintendo Wii</a></li>
                    <li><a href="nin3ds.html">Nintendo 3DS</a></li>
                    <li><a href="pc.html">PC/MAC</a></li>
                    <li><a href="pvita.html">PS Vita</a></li>                    
                </ul>                  
            </div>

            <form action="http://www.boxgames.com/busca" method="post">
                <input id="buscar" type="text" size="20" value="Buscar..." onfocus="this.value='';" onblur="this.value='Buscar...';"/>
                <input id="botaobuscar" type="button" value="Buscar" class="btn-buscar" />
            </form>
 
        </div>

        <div id="conteudo">  
            
           <form action="ModeloController" method="POST">
            <h1>Cadastro Usuario</h1>
            <label>Email</label> <input type="text" name="email"></input>
            <br>            
            <label>Senha</label> <input type="password" name="senha"></input></br>
            <br>
            <input type="submit"value="Confirmar" style="margin-left: 55px;">
            <input type="reset"value="Corrgir" style="margin-left: 10px;">
        </form>

        </div>

        <div id="footer">

            <div id="telefone">

                <img src="images/tel2.png" style="margin-top:5px;margin-left: 5px; width: 36px; height: 36px;" alt="tel"/>               
                <h3>CONTATOS</h3>
                <img src="images/tel-cont.png" style="margin-top:0px;margin-left: 45px; width: 250px; height: 75px;border-radius: 4px 4px 4px 4px; float:left;"
                     alt="telcont"/>  
            </div> 

            <div id="social">
                <h4>ACOMPANHE-NOS</h4>
                <ul>
                    <li class="facebook"><a href="http://www.facebook.com/pages/BOXGAMES" target="_blank"></a></li>
                    <li class="twitter"><a href="http://www.twitter.com" target="_blank"></a></li>
                    <li class="youtube"><a href="http://www.youtube.com/user/BOXGAMES" target="_blank"></a></li>
                </ul>  
            </div>



            <div id="pagamentos">
                <h4>FORMAS DE PAGAMENTO</h4>
                <ul>
                    <li class="visa"></li>
                    <li class="master"></li>
                    <li class="amex"></li>
                    <li class="dinners"></li>
                    <li class="boleto"></li>
                    <li class="paypal"></li>
                </ul>  
            </div>

            <p style="text-align: center; padding-top: 115px;text-shadow:0px 0px 25px #fff;">
                BOX Games © 2013 - Todos os direitos reservados</p>      
            
        </div>
    </body>
</html>
