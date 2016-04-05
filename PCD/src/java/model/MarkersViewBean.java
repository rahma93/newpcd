package model;
 
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class MarkersViewBean implements Serializable {
    
    private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(34.7478469,10.7661630);
       
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Sfax"));
       
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}