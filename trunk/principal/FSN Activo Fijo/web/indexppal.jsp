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
                            var uri = window.location.href;
                            var parametros = uri.split("?");
                            var idrol= parametros[1];
                            //alert(idrol);
                          
                            function cambia(x) {  
                               // alert(x);
                              var direc = [
                                  //Consultas
                                  "Paginas/Interfaces/activo/List2.xhtml",
                                  "Paginas/Interfaces/cargo/List2.xhtml",
                                  "Paginas/Interfaces/categoria/List2.xhtml",
                                  //"Paginas/Interfaces/desafectacion/List2.xhtml",
                                  "Paginas/Interfaces/detallecategoria/List2.xhtml",
                                  "Paginas/Interfaces/empleado/List2.xhtml",
                                  //"Paginas/Interfaces/especificacionactivo/List2.xhtml",
                                  //"Paginas/Interfaces/inventario/List2.xhtml",
                                  "Paginas/Interfaces/mantenimiento/List2.xhtml",
                                  "Paginas/Interfaces/persona/List2.xhtml",
                                  "Paginas/Interfaces/rol/List2.xhtml",
                                  "Paginas/Interfaces/rolpersona/List2.xhtml",
                                  "Paginas/Interfaces/tipoactivo/List2.xhtml",
                                  //"Paginas/Interfaces/tipodesafectacion/List2.xhtml",
                                  "Paginas/Interfaces/tipoestado/List2.xhtml",
                                  "Paginas/Interfaces/tipomodalidad/List2.xhtml",
                                  "Paginas/Interfaces/tipopersona/List2.xhtml",
                                  "Paginas/Interfaces/ubicacionfisica/List2.xhtml",
                                  "Paginas/Interfaces/unidadOrganizativa/List2.xhtml",
                                  "Paginas/Interfaces/usuario/List2.xhtml",
                                  
                                  //gestion
                                  "Paginas/Interfaces/activo/List.xhtml",
                                  "Paginas/Interfaces/cargo/List.xhtml",
                                  "Paginas/Interfaces/categoria/List.xhtml",
                                  //"Paginas/Interfaces/desafectacion/List.xhtml",
                                  "Paginas/Interfaces/detallecategoria/List.xhtml",
                                  "Paginas/Interfaces/empleado/List.xhtml",
                                  "Paginas/Interfaces/especificacionactivo/List.xhtml",
                                  "Paginas/Interfaces/inventario/List.xhtml",
                                  "Paginas/Interfaces/mantenimiento/List.xhtml",
                                  "Paginas/Interfaces/persona/List.xhtml",
                                  "Paginas/Interfaces/rol/List.xhtml",
                                  "Paginas/Interfaces/rolpersona/List.xhtml",
                                  "Paginas/Interfaces/tipoactivo/List.xhtml",
                                  //"Paginas/Interfaces/tipodesafectacion/List.xhtml",
                                  "Paginas/Interfaces/tipoestado/List.xhtml",
                                  "Paginas/Interfaces/tipomodalidad/List.xhtml",
                                  "Paginas/Interfaces/tipopersona/List.xhtml",
                                  "Paginas/Interfaces/ubicacionfisica/List.xhtml",
                                  "Paginas/Interfaces/unidadOrganizativa/List.xhtml",
                                  "Paginas/Interfaces/usuario/List.xhtml"
                              ];
                                  document.getElementById("miFrame").src= direc[x];
                            }
                        </script>
                        <div id="cssmenu">
                            <%! String menuGeneral[] = { "Consulta", "Gestion", "Reportes","Cerrar Sesion"};
                                String menuConsulta[] = {"Activo","Cargo","Categoria", "Detalle de categoria",
                                                        "Empleado", "Especificacion Activo", "Persona", "Rol de usuario","Rol persona", "Tipo Activo",
                                                         "Tipo Estado", "Tipo Modalidad", "Tipo Persona", "Ubicacion fisica",
                                                        "Unidad Organizativa", "Usuarios"}; 
                                String menuGestion[] = {"Activo","Cargo","Categoria", "Detalle de categoria",
                                                        "Empleado", "Especificacion Activo", "Persona", "Rol de usuario","Rol persona", "Tipo Activo",
                                                         "Tipo Estado", "Tipo Modalidad", "Tipo Persona", "Ubicacion fisica",
                                                        "Unidad Organizativa", "Usuarios"};
                                String menuReporte[] = {"Activos", "Prestamos"};
                                
                            %>
                                
                            <% int varol = Integer.parseInt(request.getParameter("varidrol"));
                                
                                out.println("<ul>");
                                out.println("<li onclick=cambia("+varol+"); return false;\"><a href='#' class='icon-home'  title ='inicio'  ><span>Inicio</span></a></li> "); 
                                
                                //IMPRIMIMOS EL VECTOR CON LAS OPCIONES
                                for(int i=0 ; i< menuGeneral.length; i++){
                                    out.println("<LI class=\"has-sub\"><a href='#'><span>"+menuGeneral[i]+"</span></a>");
                                    out.println("<ul>");
                                    int cont=0;
                                    switch(i){ 
                                        case 0:
                                             for(int j=0; j<menuConsulta.length ; j++) {  
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last' onclick=cambia("+cont+"); return false;\"><a href='#'><span>"+menuConsulta[j]+"</span></a></LI>");
                                                cont++;
                                             }; 
                                            out.println("</ul></LI>");
                                            break;
                                        case 1:
                                             cont=menuConsulta.length;
                                             for(int k=0; k<menuGestion.length ; k++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last' onclick=cambia("+cont+"); return false;\"><a href='#'><span>"+menuGestion[k]+"</span></a></LI>");
                                                cont++;
                                            }; 
                                            out.println("</ul></LI>");
                                            break;
                                        case 2:
                                             for(int l=0; l<menuReporte.length ; l++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                out.println("<LI class='last'><a href='#'><span>"+menuReporte[l]+"</span></a></LI>");
                                            }; 
                                            out.println("</ul></LI>");
                                    }
                                        
                                }
                                out.println("</ul>");
                                
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
