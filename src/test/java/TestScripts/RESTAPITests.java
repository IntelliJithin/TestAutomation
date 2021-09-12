package TestScripts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RESTAPITests {

    @Test
    public void getListUsers() {

        RestAssured.baseURI = "https://reqres.in";

        String Resp = given().
                when().
                get("/api/users?page=2").
                then().
                assertThat().statusCode(200).and().
                body("page", equalTo(2)).and().
                body("data[0].first_name", equalTo("Michael")).and().
                extract().
                response().asString();

        //System.out.println("Response is\t" + Resp);

    }

    @Test
    public void createUser() {

        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        JSONObject requestPara = new JSONObject();
        requestPara.put("name", "Morpheus");
        requestPara.put("job", "Leader");

        request.header("Content-Type", "application/json");
        request.body(requestPara.toJSONString());
        Response response = request.post("/users");
        //System.out.println(response.asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);

    }

    @Test
    public void updateUser() {

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification request = RestAssured.given();


    }
}