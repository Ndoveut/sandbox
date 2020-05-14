package api.models.google_places;

import api.utils.NetworkCore;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import static api.сonstants.Constants.Endpoint.GOOGLE_PLACE_ENDPOINT_SEARCH;
import static api.сonstants.Constants.Path.GOOGLE_PLACE_PATH;
import static api.сonstants.Constants.ServerName.GOOGLE_PLACE_SERVER;

public class GooglePLacesModel extends NetworkCore {


    @Getter
    @Setter
    @Builder
    public static class RequestModel {

        private String key;
        private String input;
        private String inputtype;
        private RequestSpecBuilder requestSpecBuilder;
    }

    public GooglePLacesModel search(RequestModel model, Method method, int code) {
        HashMap requestParams = new HashMap();
        requestParams.put("key", model.getKey());
        requestParams.put("input", model.getInput());
        requestParams.put("inputType", model.getInputtype());

        requestSpecBuilder.setBaseUri(GOOGLE_PLACE_SERVER + GOOGLE_PLACE_PATH + GOOGLE_PLACE_ENDPOINT_SEARCH)
                .addQueryParams(requestParams);
        sendRequestAndGetResponse(method, code);
        return this;

    }

}
