<%-- 
    Document   : index
    Created on : 10-30-2014, 07:10:31 AM
    Author     : Solis
--%>

<%@page import="java.lang.System"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/css/default.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="resources/css/componentes.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="resources/css/navstyle.css" media="screen" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/mainFunctions.js"></script>
        <noscript>  Su navegador no soporta Javascript </noscript>  
	<!--[if lt IE 9]> 
            <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script> 
        < ![endif]-->
        <!--[if IE]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <meta name="keywords" content="fsn">
        
        <title>Federación Salvadoreña de Natación</title>
        <script>
            function resizeIframe(idIframe){
                var miIframe=document.getElementById(idIframe);
                var alturaPagina=miIframe.contentWindow.document.body.scrollHeight+50;
                    miIframe.style.height=alturaPagina+"px"; 
                }
        </script>
        
    </head>
    <body>
        <div id="wrapper">
            <header>
                <div id="logo"></div>
                    <h1>Control de Activos Fijos</h1>
                    <nav>
                        <!--cambia la direccion del iframe -->
                        <script type="text/javascript">
                            
                            function cambia(x) {
                              var direc = [
                                  "Paginas/Interfaces/usuario/Create.xhtml",
                                  "Paginas/Interfaces/actividad/Edit.xhtml",
                                  "Paginas/Interfaces/rol/List.xhtml",
                                  "Paginas/Interfaces/usuario/View.xhtml"];
                              var url = direc[x];
                               document.getElementById("miFrame").src= url;
                            }
                        </script>
                        <div id="cssmenu">
                            <%! String menuGeneral[] = { "Consulta", "Gestion", "Reportes","Usuario"};
                                String menuConsulta[] = {"Activos", "Prestamos","Usuarios","Departamentos"}; 
                                String menuGestion[] = {"Activo", "Prestamo", "Ubicacion", "Departamento"};
                                String menuReporte[] = {"Activos", "Prestamos"};
                                String direccionConsulta[] = { };
                                
                         
                            
                             %>
                                
                             <% out.println("<ul>");
                                out.println("<li onclick=cambia(1); return false;\"><a href='#' class='icon-home'  title ='inicio'  ><span>Inicio</span></a></li> "); 
                                //IMPRIMIMOS EL VECTOR CON LAS OPCIONES
                                for(int i=0 ; i< menuGeneral.length; i++){
                                    out.println("<LI class=\"has-sub\"><a href=><span>"+menuGeneral[i]+"</span></a>");
                                    out.println("<ul>");
                                    int cont=0;
                                    switch(i){ 
                                        case 0:
                                             for(int j=0; j<menuConsulta.length ; j++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last' onclick=cambia("+cont+"); return false;\"><a href=><span>"+menuConsulta[j]+"</span></a></LI>");
                                                cont++;
                                             }; 
                                            out.println("</ul></LI>");
                                            break;
                                        case 1:
                                             for(int k=0; k<menuGestion.length ; k++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last'><a href=><span>"+menuGestion[k]+"</span></a></LI>");
                                            }; 
                                            out.println("</ul></LI>");
                                            break;
                                        case 2:
                                             for(int l=0; l<menuReporte.length ; l++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last'><a href=><span>"+menuReporte[l]+"</span></a></LI>");
                                            }; 
                                            out.println("</ul></LI>");
                                    }
                                        
                                }
                                out.println("</ul>");
                                 /*   for(int j=0; j<menuConsulta.length ; i++) {
                                 //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                    out.println("<LI class='last'><a href=><span>"+nommenu[i]+"</span></a></LI>");
                                }; 
                                out.println("</ul></LI>");
                                }
                                /*for(i=0; i<nommenu.length ; i++) {
                                 //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                    out.println("<LI><a href="+menu1[i]+"><span>"+nommenu[i]+"</span></a></LI>");
                                }; 
                                out.println("</ul>");*/
                             %>
                        </div>
                    </nav>
            </header>
            <section>
                
    		<article style="width: 98%!important;">
                    <div id="divname" >
                        Contenido
                        <hr />
                    </div>
			
                       <iframe id="miFrame" src="Paginas/Interfaces/usuario/List.xhtml"  seamless="seamless"  frameborder="0" scrolling="no" onLoad="resizeIframe(this.id);"></iframe>
    		</article>
            </section>
            <footer>
		<a href="mailto:jazonder@gmail.com"> Enviar correo</a>
		<p>Ayuda</p>
            </footer>
	</div>
    </body>
</html>
