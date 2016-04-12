package model;

 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
  
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
  
@ManagedBean
@ViewScoped
public class MarkersViewBean implements Serializable {
      
    private MapModel advancedModel;
  
    private List<AgentMedical> AgentMedicals;
     private Marker marker;
  
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
         Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       AgentMedicals = session.createQuery("from AgentMedical ").list();
       for(int k=0  ;k<AgentMedicals.size();k++)
       {
       LatLng coord = new LatLng( (AgentMedicals.get(k)).getLon(),(AgentMedicals.get(k)).getLat());
       advancedModel.addOverlay(new Marker(coord, (AgentMedicals.get(k)).getNomvilleagent(),"pharmacie.png","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
       }
       session.getTransaction().commit();
       session.close();  }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
       public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
}