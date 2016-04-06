package model;
 
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.primefaces.event.map.OverlaySelectEvent;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class MarkersViewBean implements Serializable {
    
    private MapModel simpleModel;
     private List<AgentMedical> AgentMedicals;
     private Marker marker;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       AgentMedicals = session.createQuery("from AgentMedical ").list();
       for(int k=0  ;k<AgentMedicals.size();k++)
       {
       LatLng coord = new LatLng( (AgentMedicals.get(k)).getLon(),(AgentMedicals.get(k)).getLat());
       simpleModel.addOverlay(new Marker(coord, (AgentMedicals.get(k)).getNomvilleagent(),"hopital.png","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
       }
       session.getTransaction().commit();
       session.close();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(34.7478469,10.7661630);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Sfax"));
    }
   
    public MapModel getSimpleModel() {
        return simpleModel;
    }  
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
}