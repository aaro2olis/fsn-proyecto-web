function resizeIframe(idIframe){
                var miIframe=document.getElementById(idIframe);
                var alturaPagina=miIframe.contentWindow.document.body.scrollHeight+50;
                    miIframe.style.height=alturaPagina+"px"; 
                }
               
