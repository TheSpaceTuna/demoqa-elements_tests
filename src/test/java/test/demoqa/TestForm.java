package test.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {
    @BeforeAll
    static void setUp(){
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void authorisationFormTest(){
    open("/text-box");
    $x("//input[@id='userName']").sendKeys("Test");
    $x("//input[@id='userEmail']").sendKeys("test@email.com");
    $x("//textarea[@id='currentAddress']").sendKeys("Test city, Test str. 8");
    $x("//textarea[@id='permanentAddress']").sendKeys("Test town, Test str. 6");
    $x("//button[@id='submit']").click();
    $x("//p[@id='name']").shouldHave(text("Test"));
    $x("//p[@id='email']").shouldHave(text("test@email.com"));
    $x("//p[@id='currentAddress']").shouldHave(text("Test city, Test str. 8"));
    $x("//p[@id='permanentAddress']").shouldHave(text("Test town, Test str. 6"));
        }
}
