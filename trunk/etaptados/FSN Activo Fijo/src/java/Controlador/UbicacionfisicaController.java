package Controlador;

import BEAN.UbicacionfisicaFacade;
import Controlador.util.JsfUtil;
import Controlador.util.JsfUtil.PersistAction;
import Modelo.Municipio;
import Modelo.Ubicacionfisica;
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
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named("ubicacionfisicaController")
@SessionScoped
public class UbicacionfisicaController implements Serializable {

    @EJB
    private BEAN.UbicacionfisicaFacade ejbFacade;
    private List<Ubicacionfisica> items = null;
    private Ubicacionfisica selected;
    private MunicipioController municipioController;
    private List<Municipio> itemsMunicipios = null;

    public UbicacionfisicaController() {
    }

    public Ubicacionfisica getSelected() {
        return selected;
    }

    public void setSelected(Ubicacionfisica selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UbicacionfisicaFacade getFacade() {
        return ejbFacade;
    }

    public Ubicacionfisica prepareCreate() {
        selected = new Ubicacionfisica();
        initializeEmbeddableKey();
        return selected;
    }

    /*    public void create() {
     persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaCreated"));
     if (!JsfUtil.isValidationFailed()) {
     items = null;    // Invalidate list of items to trigger re-query.
     }
     }*/
    public void create() {
        String nmbubicacion = selected.getNmbubicacion();
        Integer iddpto = selected.getIddpto().getIddpto();
        Integer idmunicipio = selected.getIdmunicipio().getIdmunicipio();
        boolean evaluacion = ejbFacade.findDuplicados(nmbubicacion, iddpto, idmunicipio);
        if (evaluacion) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaCreatedError")));
        } else {
            selected.setEstadoubicacion('1');
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }

    public void update() {
        String nmbubicacion = selected.getNmbubicacion();
        Integer iddpto = selected.getIddpto().getIddpto();
        Integer idmunicipio = selected.getIdmunicipio().getIdmunicipio();
        Integer idubicacion = selected.getIdubicacion();
        boolean evaluacion = ejbFacade.findDuplicados(nmbubicacion, iddpto, idmunicipio, idubicacion);
        if (evaluacion) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaUpdatedError")));
            items = null;
        } else {
            persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaUpdated"));
        }
    }
    /*public void update() {
     persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaUpdated"));
     }*/

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UbicacionfisicaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void borrar() {
        selected.setEstadoubicacion('0');
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UnidadOrganizativaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ubicacionfisica> getItems() {
        if (items == null) {
            items = getFacade().findAllbyone("Ubicacionfisica.findAll", "estadoubicacion");
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

    public Ubicacionfisica getUbicacionfisica(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Ubicacionfisica> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ubicacionfisica> getItemsAvailableSelectOne() {
        //return getFacade().findAll(); BELR
        return getFacade().findAllbyone("estadoubicacion");
    }

    /**
     * @return the itemsMunicipios
     */
    public List<Municipio> getItemsMunicipios() {
        return itemsMunicipios;
    }

    public void idDeptoChangeListener(AjaxBehaviorEvent event) {
        Integer idpto = 0;
        FacesContext context = FacesContext.getCurrentInstance();
        Ubicacionfisica ubicacionFisica = (Ubicacionfisica) ((UIOutput) event.getSource()).getValue();
//Ubicacionfisica ubicacionFisica = context.getApplication().evaluateExpressionGet(context, "#{ubicacionfisicaController}", Ubicacionfisica.class);
        idpto = ubicacionFisica.getIddpto().getIddpto();
        //Integer iddepto=Integer.parseInt(event.getComponent().getAttributes().toString());
        itemsMunicipios = municipioController.getItemsByDepto(idpto);
    }

    @FacesConverter(forClass = Ubicacionfisica.class)
    public static class UbicacionfisicaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UbicacionfisicaController controller = (UbicacionfisicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ubicacionfisicaController");
            return controller.getUbicacionfisica(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
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
            if (object instanceof Ubicacionfisica) {
                Ubicacionfisica o = (Ubicacionfisica) object;
                return getStringKey(o.getIdubicacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ubicacionfisica.class.getName()});
                return null;
            }
        }
    }
}
