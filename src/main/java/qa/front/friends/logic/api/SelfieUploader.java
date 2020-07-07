package qa.front.friends.logic.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.html5.RemoteWebStorage;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import static java.lang.Thread.sleep;

public interface SelfieUploader extends Specification {


    default String getCookieValue (String cookieItem) {
        RemoteExecuteMethod remoteExecuteMethod = new RemoteExecuteMethod((RemoteWebDriver) WebDriverRunner.getWebDriver());
        return new RemoteWebStorage(remoteExecuteMethod).getLocalStorage().getItem(cookieItem);
    }

    default String getApplicationID() {
        return RestAssured
                .given()
                .config(requestConfig())
                .spec(getRequestSpecification())
                .basePath("leasing-basket/v1/basket-online/" + getCookieValue("fwd_basketId"))
                .get()
                .then()
                .spec(getResponseSpecification()).extract().body()
                .jsonPath()
                .getString("resultData.basketInfo.referenceId")
                ;
    }

    default String getAgentId() {

        return RestAssured
                .given()
                .config(requestConfig())
                .spec(getRequestSpecification())
                .basePath("leasing-basket/v1/basket-online/" + getCookieValue("fwd_basketId"))
                .get()
                .then()
                .spec(getResponseSpecification()).extract().body()
                .jsonPath()
                .getString("resultData.basketInfo.agentId")
                ;
    }

    default void selfieUploadApi() {
        String applicationID = getApplicationID();
        RestAssured
                .given()
                .config(requestConfig())
                .spec(getRequestSpecification())
                .header("authorization", "Bearer " + getCookieValue("auth-token"))
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
                    .config(requestConfig())
                    .spec(getRequestSpecification())
                    .header("device-type", "WEB")
                    .basePath("application/v1/leasing-application/" + applicationID + "/check-passport-selfie")
                    .get()
                    .then()
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

    default void passportUploadApi() {
        String applicationID = getApplicationID();
        RestAssured
                .given()
                .config(requestConfig())
                .spec(getRequestSpecification())
                .header("authorization", "Bearer " + getCookieValue("auth-token"))
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

