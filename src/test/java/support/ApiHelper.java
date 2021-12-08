package support;

import env.ApplicationProperties;
import env.Environment;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utilities.Utils;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private RequestSpecification request;
    private Response response;
    private String base_path;

    ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();

    @Step("Set the Base URL")
    public void setBaseUrl(String base_url){
        base_path=base_url;
        //base_path=appProps.getPropertyValue(base_url);
    }

    @Step("User authentication done using Token")
    public void getAuthentication(String token){
        request= SerenityRest
                .given()
                .auth()
                .oauth2(Utils.getProperties(token));

    }

    @Step("User send get request to the path")
    public void get_request(){
        String path = base_path+"/user/repos";
        response =
                SerenityRest.when()
                //.request
                .get(path)
                .then()
                .extract()
                .response();

      //  System.out.println("This is response===============>>>>>>"+response.getBody().prettyPrint());

    }

    @Step("Validate the response code")
    public int getResponseCode(){
        response.then().log().body();
         return response.getStatusCode();

    }

    @Step("Set the query parameters")
    public void setQueryParameters(String param, String val){
   //SerenityRest.given().queryParams(param,val);
       request.queryParams(param,val);

    }

    @Step("Set path parameters")
    public void setPathParameters(String param, String val){
      SerenityRest.given().pathParam(param,val);
        //request.pathParam(param,val);
    }
    @Step("Send GET request with path parameters")
    public void get_with_Path_params(String path_param){
        String new_url=base_path+"/users/"+path_param+"/repos";
        System.out.println(new_url);
        //request
                SerenityRest.given()
        //request
                .when()
                .get(new_url)
                .then()
                .extract()
                .response();

    }
}
