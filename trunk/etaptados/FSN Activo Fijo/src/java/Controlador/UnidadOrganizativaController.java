package Controlador;

import BEAN.UnidadOrganizativaFacade;
import Controlador.util.JsfUtil;
import Controlador.util.JsfUtil.PersistAction;
import Modelo.UnidadOrganizativa;
import java.io.Serializable;
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

@Named("unidadOrganizativaController")
@SessionScoped
public class UnidadOrganizativaController implements Serializable {

    @EJB
    private BEAN.UnidadOrganizativaFacade ejbFacade;
    private List<UnidadOrganizativa> items = null;
    private UnidadOrganizativa selected;

    public UnidadOrganizativaController() {
    }

    public UnidadOrganizativa getSelected() {
        return selected;
    }

    public void setSelected(UnidadOrganizativa selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UnidadOrganizativaFacade getFacade() {
        return ejbFacade;
    }

    public UnidadOrganizativa prepareCreate() {
        selected = new UnidadOrganizativa();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setEstadounidad('1');
        String nmbunidad = selected.getNmbunidad().toUpperCase();
        Integer uniIdunidad = selected.getUniIdunidad().getIdunidad();
        boolean evaluacion = ejbFacade.findDuplicados(nmbunidad, uniIdunidad);
        if (evaluacion) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaCreatedError")));
        } else {
            selected.setEstadounidad('1');
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }    
    /*public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }*/
    public void update() {
        String nmbunidad = selected.getNmbunidad().toUpperCase();
        Integer uniIdunidad = selected.getUniIdunidad().getIdunidad();
        Integer idunidad = selected.getIdunidad();       
        boolean evaluacion = ejbFacade.findDuplicados(nmbunidad, uniIdunidad,idunidad);
        if (evaluacion) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaUpdatedError")));
            items = null;
        } else {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaUpdated"));
        }
    }
   /* public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaUpdated"));
    }*/

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    //Creada por el mensaje de eliminado
    public void borrar() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaDeleted"));
        selected.setEstadounidad('0');
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
        public void actualizada() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public List<UnidadOrganizativa> getItems() {
        if (items == null) {
            //items = getFacade().findAllbyone("estadounidad");
            items = getFacade().findAllbyone("UnidadOrganizativa.findAll","estadounidad");

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

    public UnidadOrganizativa getUnidadOrganizativa(java.lang.Integer id) {
        
        return getFacade().find(id);
    }

    public List<UnidadOrganizativa> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<UnidadOrganizativa> getItemsAvailableSelectOne() {
        //Se modifico findAll() findAllbyone("estadounidad")
        return getFacade().findAllbyone("estadounidad");
    }

    @FacesConverter(forClass = UnidadOrganizativa.class)
    public static class UnidadOrganizativaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UnidadOrganizativaController controller = (UnidadOrganizativaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "unidadOrganizativaController");
            return controller.getUnidadOrganizativa(getKey(value));
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
            if (object instanceof UnidadOrganizativa) {
                UnidadOrganizativa o = (UnidadOrganizativa) object;
                return getStringKey(o.getIdunidad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UnidadOrganizativa.class.getName()});
                return null;
            }
        }

    }

}
