package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import support.ApiHelper;
import support.World;


import static io.restassured.RestAssured.given;

public class GitHubSteps {
    RequestSpecification request;
    Response response;
    String base_path;

    @Steps
    World world;

    @Steps
    ApiHelper apiHelper;

    @Given("User set the base API url {string}")
    public void userSetTheBaseAPIUrl(String base_url0) {
        apiHelper.setBaseUrl(base_url0);
       // base_path = base_url0;
        //RestAssured.baseURI = base_url0;
    }

    @Then("User authenticate API request with {string}")
    public void userAuthenticateAPIRequestWith(String token) {
        apiHelper.getAuthentication(token);
//       request= given()
//                .auth()
//                .oauth2(Utils.getProperties(token));
    }

    @And("^User sends GET request to get all repos$")
    public void userSendsGETRequestToGetAllRepos() {
        apiHelper.get_request();
        //String path = "/user/repos";
//        String path = base_path+"/user/repos";
//        response = request
//                .get(path)
//                .then()
//                .extract()
//                .response();


    }

    @Then("User validates the response code {string}")
    public void userValidatesTheResponseCode(String statusCode) {
        //response.then().log().body();
        Assert.assertEquals(Integer.parseInt(statusCode), apiHelper.getResponseCode());
    }

    @And("User set the query parameter {string} and value {string}")
    public void userSetTheQueryParameterAndValue(String param, String val) {
        apiHelper.setQueryParameters(param,val);
        //request.queryParams(param,val);
    }

    @And("User set the PATH parameter {string} and value {string}")
    public void userSetThePATHParameterAndValue(String param, String val) {
        apiHelper.setPathParameters(param,val);
       // request.pathParam(param,val);
    }

    @And("User sends GET request with PATH parameter {string}")
    public void userSendsGETRequestWithPATHParameter(String path_param) {
        apiHelper.get_with_Path_params(path_param);
//        String new_url=base_path+"/users/"+path_param+"/repos";
//        System.out.println(new_url);
//         request
//                 .when()
//                .get(new_url)
//                .then()
//                .extract()
//                .response();
    }
}
