package tests.google_places.positive;


import api.api_manager.ApiManager;
import api.models.google_places.GooglePLacesModel;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTests;

import static api.сonstants.Constants.API_TOKEN;

public class SearchTestPositive extends BaseTests {
    @Test(description = "search some object", dataProvider = "searchText")
    public void searchPlaceWithText(String key, String input, String inputtype) {

        GooglePLacesModel.RequestModel requestModel = GooglePLacesModel.RequestModel.builder()
                .key(key)
                .input(input)
                .inputtype(inputtype)
                .build();

       ApiManager.getGooglePlacesModel().search(requestModel, Method.GET, 200);

    }

    @DataProvider
    public Object[][] searchText(){
        return new Object[][]{
    {API_TOKEN,"New-York","textquery"}
        };
    }
}
