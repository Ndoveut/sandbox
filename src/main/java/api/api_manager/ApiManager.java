package api.api_manager;

import lombok.Getter;
import lombok.Setter;
import api.models.google_places.GooglePLacesModel;


public class ApiManager {

    @Setter
    @Getter
    GooglePLacesModel googlePLacesModel = new GooglePLacesModel();
}
