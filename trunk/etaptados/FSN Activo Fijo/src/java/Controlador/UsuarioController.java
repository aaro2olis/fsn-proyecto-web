package Controlador;

import BEAN.UsuarioFacade;
import Controlador.util.JsfUtil;
import Controlador.util.JsfUtil.PersistAction;
import Modelo.Rol;
import Modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private BEAN.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private Usuario current;
    private String message;
    private String idusuario;
    private String password;

    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

   

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario(); 
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        FacesContext context = FacesContext.getCurrentInstance();

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }

    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
        /*persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));*/
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAllbyone("estadousuario");
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuario getUsuario(java.lang.String id) {
        System.out.println("usuario" + getFacade().find(id));
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getIdusuario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

    public void reset() {
        RequestContext.getCurrentInstance().reset("form:UsuarioCreateForm");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
    
    public void validateLogin() throws IOException {
        Usuario usuario =  ejbFacade.buscaUsuario(idusuario, password); 
        Rol rol = usuario.getIdrol();
        System.out.println("id rol " +rol);
       System.out.println("id rol " +rol.getIdrol());
       String nom = (rol).toString().replace(" ", "_");
        if (!rol.equals(" ")) {
           //1 admin, 2 presi, 3 asist, 4 conta, 5 audi
            switch(rol.getIdrol()){
                case 1: //administrador
                    FacesContext.getCurrentInstance().getExternalContext().redirect("indexppal.jsp?user="+nom+"?idrol"+rol.getIdrol());
                    break;
                case 2: //presidente
                    FacesContext.getCurrentInstance().getExternalContext().redirect("indexpde.jsp?user="+nom+"?idrol"+rol.getIdrol()); 
                    break;
                case 3: // asistente
                    FacesContext.getCurrentInstance().getExternalContext().redirect("indexasis.jsp?user="+(rol).toString().trim()+"?idrol"+rol.getIdrol());
                    break;
                case 4:// contador
                    FacesContext.getCurrentInstance().getExternalContext().redirect("indexcont.jsp?user="+(rol).toString().trim()+"?idrol"+rol.getIdrol());        
                    break;
                case 5: //auditor
                    FacesContext.getCurrentInstance().getExternalContext().redirect("indexaudi.jsp?user="+(rol).toString().trim()+"?idrol"+rol.getIdrol());        
                    break;
            }              
        } 
//        if(existeUser.equals(false)){
//           FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
//           
//        }

    }


    public void logout()throws ServletException, IOException{
        this.idusuario = null;
        this.password = null;
         
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        request.logout();
       // FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsp");
    }
     
     
}
