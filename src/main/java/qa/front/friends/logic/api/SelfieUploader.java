package qa.front.friends.logic.api;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import static java.lang.Thread.sleep;

public interface SelfieUploader extends Specification {

    default String getApplicationID(String fwdBasket) {
        return RestAssured
                .given()
                .spec(getRequestSpecification("https://agent-front-ag-test.forward.lc/"))
                .basePath("leasing-basket/v1/basket-online/" + fwdBasket)
                .get()
                .then()
                .spec(getResponseSpecification()).extract().body()
                .jsonPath()
                .getString("resultData.basketInfo.referenceId")
                ;
    }

    default void selfieUploadApi(String fwdBasket, String authToken) {
        String applicationID = getApplicationID(fwdBasket);
        RestAssured
                .given()
                .spec(getRequestSpecification("https://agent-front-ag-test.forward.lc/"))
                .header("authorization", "Bearer " + authToken)
                .header("device-type", "WEB")
                .basePath("application/v2/leasing-application/upload/" + applicationID + "/photo")
                .body(new HashMap<String, Object>() {{
                    put("imageType", "SELFIE");
                    try {
                        put("imageData", new String(Base64.getEncoder().encode(FileUtils.readFileToByteArray(new File("src/main/resources/self.jpg")))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }})
                .post()
                .then()
                .spec(getResponseSpecification())
        ;
        for (int i = 0; i < Configuration.timeout / 1000 + 10; i++) {
            String status = RestAssured
                    .given()
                    .spec(getRequestSpecification("https://agent-front-ag-test.forward.lc/"))
                    .header("device-type", "WEB")
                    .basePath("application/v1/leasing-application/" + applicationID + "/check-passport-selfie")
                    .get()
                    .then()
//                    .log().all()
                    .statusCode(200)
                    .extract().body().jsonPath().getString("resultData.status");
            if (status.equals("CHECKED_SUCCESS")) return;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException();
    }

    default void passportUploadApi(String fwdBasket, String authToken) {
        String applicationID = getApplicationID(fwdBasket);
        RestAssured
                .given()
                .spec(getRequestSpecification("https://agent-front-ag-test.forward.lc/"))
                .header("authorization", "Bearer " + authToken)
                .header("device-type", "WEB")
                .basePath("application/v2/leasing-application/upload/" + applicationID + "/photo")
                .body(new HashMap<String, Object>() {{
                    put("imageType", "PASSPORT_RECOGNIZE");
                    try {
                        put("imageData", new String(Base64.getEncoder().encode(FileUtils.readFileToByteArray(new File("src/main/resources/passportScan.jpeg")))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }})
                .post()
                .then()
                .statusCode(200)
                .spec(getResponseSpecification())
                ;

    }

}

