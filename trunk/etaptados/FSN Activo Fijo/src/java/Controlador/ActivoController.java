package Controlador;

import Modelo.Activo;
import Controlador.util.JsfUtil;
import Controlador.util.JsfUtil.PersistAction;
import BEAN.ActivoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("activoController")
@SessionScoped
public class ActivoController implements Serializable {

    @EJB
    private BEAN.ActivoFacade ejbFacade;
    private List<Activo> items = null;
    private Activo selected;

    public ActivoController() {
    }

    public Activo getSelected() {
        return selected;
    }

    public void setSelected(Activo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ActivoFacade getFacade() {
        return ejbFacade;
    }
    
    public void depreciar(){
        double cuenta1;
        
    }

    public Activo prepareCreate() {
        selected = new Activo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        Integer cantidad = getFacade().count();
        selected.setIdactivo(selected.CodActivo(selected, cantidad));
        selected.setEstadoActivo('1');
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ActivoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ActivoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ActivoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    //Creada por el mensaje de eliminado
    public void borrar() {
        selected.setEstadoActivo('0');
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ActivoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Activo> getItems() {
        if (items == null) {
            // items = getFacade().findAll();
            items = getFacade().findAllbyone("Activo.findAll", "estadoactivo");
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

    public Activo getActivo(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Activo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Activo> getItemsAvailableSelectOne() {
        // return getFacade().findAll();
        return  getFacade().findAllbyone("Activo.findAll", "estadoactivo");
    }

    @FacesConverter(forClass = Activo.class)
    public static class ActivoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActivoController controller = (ActivoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "activoController");
            return controller.getActivo(getKey(value));
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
            if (object instanceof Activo) {
                Activo o = (Activo) object;
                return getStringKey(o.getIdactivo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Activo.class.getName()});
                return null;
            }
        }

    }
}
