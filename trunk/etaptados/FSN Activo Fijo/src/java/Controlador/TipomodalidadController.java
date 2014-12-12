package Controlador;

import Modelo.Tipomodalidad;
import Controlador.util.JsfUtil;
import Controlador.util.JsfUtil.PersistAction;
import BEAN.TipomodalidadFacade;

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

@Named("tipomodalidadController")
@SessionScoped
public class TipomodalidadController implements Serializable {

    @EJB
    private BEAN.TipomodalidadFacade ejbFacade;
    private List<Tipomodalidad> items = null;
    private Tipomodalidad selected;

    public TipomodalidadController() {
    }

    public Tipomodalidad getSelected() {
        return selected;
    }

    public void setSelected(Tipomodalidad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipomodalidadFacade getFacade() {
        return ejbFacade;
    }

    public Tipomodalidad prepareCreate() {
        selected = new Tipomodalidad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TipomodalidadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TipomodalidadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TipomodalidadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tipomodalidad> getItems() {
        if (items == null) {
            //items = getFacade().findAll();
           items = getFacade().findAll("Tipomodalidad.findAll");
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

    public Tipomodalidad getTipomodalidad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tipomodalidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tipomodalidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tipomodalidad.class)
    public static class TipomodalidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipomodalidadController controller = (TipomodalidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipomodalidadController");
            return controller.getTipomodalidad(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tipomodalidad) {
                Tipomodalidad o = (Tipomodalidad) object;
                return getStringKey(o.getIdmodalidad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tipomodalidad.class.getName()});
                return null;
            }
        }

    }

}
