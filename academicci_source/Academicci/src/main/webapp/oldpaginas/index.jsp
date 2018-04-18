<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        
<script LANGUAGE="JavaScript">

function Login(){
var done=0;
var username=document.login.username.value;
username=username.toLowerCase();
var password=document.login.password.value;
password=password.toLowerCase();
if (username==="1413020" && password==="minhasenha") { window.location="paginaInicial.jsp"; done=1; }
if (username==="1410499" && password==="suasenha") { window.location="paginaInicial.jsp"; done=1; }
if (username==="1111111" && password==="teste") { window.location="paginaInicial.jsp"; done=1; }
if (done===0) { alert("Senha ou Usuário inválido."); }
}

</script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ACADEMICI</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="ddaccordion.js"></script>
        <script type="text/javascript" src="jconfirmaction.jquery.js"></script>
        <script language="javascript" type="text/javascript" src="niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />


    <body>
        <div id="main_container">

            <div class="header_login">
                <div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>
            </div>

            <div class="login_form">

                <h3>Tela de Login</h3>

                <form name="login" class="niceform" method="post">
                    <fieldset>
                        <dl>
                            <dt><label for="email">Usuário:</label></dt>
                           <dd><input type="text" name="username" size="40" /></dd>
                        </dl>
                        <dl>
                            <dt><label for="password">Senha:</label></dt>
                            <dd><input type="password" name="password" size="20" /></dd>
                        </dl>

                        <dl style="padding-left: 100px; text-align: center"><br>
                            <dt ><input type="button" value="Entrar" onClick="Login()"></dt>
                            <dt ><input type="button" name="cadastro" id="submit" value="Cadastrar-se" onclick="window.location.href = 'frmcadastro.jsp'" /></dt>
                        </dl>

                    </fieldset>

                </form>
            </div>  

        </div>		
    </body>
</html>