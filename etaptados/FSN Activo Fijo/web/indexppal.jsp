<%@page import="java.lang.System"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="fsn">
        <link href="resources/css/default.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="resources/css/componentes.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="resources/css/navstyle.css" rel="stylesheet" type="text/css" media="screen" /> 
        <script  src="reources/js/functionsdefault.js" type="text/javascript"></script><!--funciones de toda la pag-->
        <script  src="resources/js/mainFunctions.js" type="text/javascript"></script><!--slider-->
        <script  src="resources/js/script.js" ></script><!--menu desplegable-->
        <script  src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>-->      
        <noscript>  Su navegador no soporta Javascript </noscript>       
        <title>Federación Salvadoreña de Natación</title>        
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
                                  "inicio.html",                                        //0
                                  //Consultas
                                  "Paginas/Interfaces/activo/List2.xhtml",              //1
                                  "Paginas/Interfaces/cargo/List2.xhtml",               //2
                                  "Paginas/Interfaces/categoria/List2.xhtml",           //3
                                  //"Paginas/Interfaces/desafectacion/List2.xhtml",     
                                  "Paginas/Interfaces/detallecategoria/List2.xhtml",    //4
                                  "Paginas/Interfaces/empleado/List2.xhtml",            //5
                                  //"Paginas/Interfaces/especificacionactivo/List2.xhtml",
                                  //"Paginas/Interfaces/inventario/List2.xhtml",
                                  "Paginas/Interfaces/mantenimiento/List2.xhtml",       //6
                                  "Paginas/Interfaces/persona/List2.xhtml",             //7
                                  "Paginas/Interfaces/rol/List2.xhtml",                 //8
                                  "Paginas/Interfaces/rolpersona/List2.xhtml",          //9
                                  "Paginas/Interfaces/tipoactivo/List2.xhtml",          //10
                                  //"Paginas/Interfaces/tipodesafectacion/List2.xhtml",
                                  "Paginas/Interfaces/tipoestado/List2.xhtml",          //11
                                  "Paginas/Interfaces/tipomodalidad/List2.xhtml",       //12
                                  "Paginas/Interfaces/tipopersona/List2.xhtml",         //13
                                  "Paginas/Interfaces/ubicacionfisica/List2.xhtml",     //14
                                  "Paginas/Interfaces/unidadOrganizativa/List2.xhtml",  //15
                                  "Paginas/Interfaces/usuario/List2.xhtml",             //16
                                  
                                  //gestion
                                  "Paginas/Interfaces/activo/List.xhtml",               //17
                                  "Paginas/Interfaces/cargo/List.xhtml",                //18
                                  "Paginas/Interfaces/categoria/List.xhtml",            //19
                                  //"Paginas/Interfaces/desafectacion/List.xhtml",  
                                  "Paginas/Interfaces/detallecategoria/List.xhtml",     //20
                                  "Paginas/Interfaces/empleado/List.xhtml",             //21
                                  "Paginas/Interfaces/especificacionactivo/List.xhtml", //22
                                  //"Paginas/Interfaces/inventario/List.xhtml",           
                                  //"Paginas/Interfaces/mantenimiento/List.xhtml",
                                  "Paginas/Interfaces/persona/List.xhtml",              //23
                                  "Paginas/Interfaces/rol/List.xhtml",                  //24
                                  "Paginas/Interfaces/rolpersona/List.xhtml",           //25
                                  "Paginas/Interfaces/tipoactivo/List.xhtml",           //26
                                  //"Paginas/Interfaces/tipodesafectacion/List.xhtml",
                                  "Paginas/Interfaces/tipoestado/List.xhtml",           //27
                                  "Paginas/Interfaces/tipomodalidad/List.xhtml",        //28
                                  "Paginas/Interfaces/tipopersona/List.xhtml",          //29
                                  "Paginas/Interfaces/ubicacionfisica/List.xhtml",      //30
                                  "Paginas/Interfaces/unidadOrganizativa/List.xhtml",   //31
                                  "Paginas/Interfaces/usuario/List.xhtml",              //32
                                  "resources/docs/usermanual.pdf"                       //33
                              ];
                                  document.getElementById("miFrame").src= direc[x]; 
                            }
                        </script>
                        <div id='cssmenu'>
                            <%! String menuGeneral[] = { "Consulta", "Gestion", "Reportes","Sesión"};
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
                                out.println("<li onclick=\"cambia(0); return false;\" ><a href='#'  class='icon-home'><span>Inicio</span></a></li> "); 
                                
                                //IMPRIMIMOS EL VECTOR CON LAS OPCIONES
                                for(int i=0 ; i< menuGeneral.length; i++){
                                    out.println("<LI class=\'active has-sub\'><a href='#'><span>"+menuGeneral[i]+"</span></a>");
                                    out.println("<ul>");
                                    int cont=1;
                                    switch(i){ 
                                        case 0:
                                             for(int j=0; j<menuConsulta.length ; j++) {  
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                if(j<menuConsulta.length-1){ 
                                                    out.println("<LI  onclick=\"cambia("+cont+"); return false;\"><a href='#'><span>"+menuConsulta[j]+"</span></a></LI>");
                                                }
                                                else {
                                                    out.println("<LI class='last' onclick=\"cambia("+cont+"); return false;\"><a href='#'><span>"+menuConsulta[j]+"</span></a></LI>");
                                                }
                                                cont++;
                                             }; 
                                            out.println("</ul></LI>");
                                            break;
                                        case 1:
                                             cont=menuConsulta.length +1 ;
                                             for(int k=0; k<menuGestion.length ; k++) {
                                                //DESPLEGANDO EN OBJETO LISTA DE HMTL CON BULLETS FOR NORMAL 
                                                if(k<menuGestion.length-1){
                                                 out.println("<LI  onclick=\"cambia("+cont+"); return false;\"><a href='#'><span>"+menuGestion[k]+"</span></a></LI>");
                                                }
                                                else{
                                                  out.println("<LI class='last' onclick=\"cambia("+cont+"); return false;\"><a href='#'><span>"+menuGestion[k]+"</span></a></LI>");  
                                                }
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
                                            break;
                                        case 3:
                                            out.println("<LI class='last' ><a href='login.xhtml'><span>Cerrar sesi&oacute;n</span></a></LI>");
                                            break;    
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
			
                       <iframe id="miFrame" src="inicio.html"  seamless="seamless"  frameborder="0" scrolling="no" onLoad="resizeIframe(this.id);"></iframe>
    		</article>
            </section>
            <footer>
		<br />
		<ul>
                    <LI><a href='#'>
                            <img src="resources/img/help1.png" 
                                 onmouseover="this.src='resources/img/help2.png';" 
                                 onmouseout="this.src='resources/img/help1.png';" 
                                 name="Ayuda" 
                                 onclick=cambia(33); return false />
                        </a></LI>
                    <LI><a href='mailto:jazonder@gmail.com'>
                            <img src="resources/img/email1.png" 
                                 onmouseover="this.src='resources/img/email2.png';" 
                                 onmouseout="this.src='resources/img/email1.png';" 
                                 name="Email"/></a></li>
		</ul>
            </footer>
	</div>
    </body>
</html>
