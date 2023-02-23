package test.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestElements {
    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    public void selectRadioButton(SelenideElement radio){
        radio.doubleClick();
    }

    @Test
    void textBoxTest(){
    open("/text-box");
    $x("//input[@id='userName']").sendKeys("Test");
    $x("//input[@id='userEmail']").sendKeys("test@email.com");
    $x("//textarea[@id='currentAddress']").sendKeys("Test city, Test str. 8");
    $x("//textarea[@id='permanentAddress']").sendKeys("Test town, Test str. 6");
    $x("//button[@id='submit']").scrollIntoView(true).click();
    $x("//p[@id='name']").shouldHave(text("Test"));
    $x("//p[@id='email']").shouldHave(text("test@email.com"));
    $x("//p[@id='currentAddress']").shouldHave(text("Test city, Test str. 8"));
    $x("//p[@id='permanentAddress']").shouldHave(text("Test town, Test str. 6"));
        }
    @Test
    void checkBoxTest() {
        open("/checkbox");
        $x("//span[@class='rct-checkbox']").click();
        $x("//div[@id='result']").shouldHave(text("home desktop notes commands documents workspace react angular" +
                " veu office public private classified general downloads wordFile excelFile"));
    }
    @Test
    void radioButtonTest(){
        SelenideElement rbYes = $x("//div//input[@id='yesRadio']");
        SelenideElement rbImpressive = $x("//div//input[@id='impressiveRadio']");
        SelenideElement rbNo = $x("//div//input[@id='noRadio']");
        open("/radio-button");
        selectRadioButton(rbYes);
        rbYes.shouldBe(selected);
        selectRadioButton(rbImpressive);
        rbImpressive.shouldBe(selected);
        selectRadioButton(rbNo);
        rbNo.shouldNotBe(selected);
    }
    @Test
    void webTablesTest(){
        open("/webtables");
        $x("//span[@id='delete-record-1']").click();
        $x("//span[@id='delete-record-2']").click();
        $x("//span[@id='edit-record-3']").click();
        $x("//input[@id='firstName']").setValue("Test");
        $x("//input[@id='lastName']").setValue("Test");
        $x("//input[@id='userEmail']").setValue("Test@test.com");
        $x("//input[@id='age']").setValue("26");
        $x("//input[@id='salary']").setValue("65000");
        $x("//input[@id='department']").setValue("Test");
        $x("//button[@id='submit']").click();
        $x("//button[@id='addNewRecordButton']").click();
        $x("//input[@id='firstName']").setValue("Test2");
        $x("//input[@id='lastName']").setValue("Test2");
        $x("//input[@id='userEmail']").setValue("Test@test2.com");
        $x("//input[@id='age']").setValue("60");
        $x("//input[@id='salary']").setValue("90000");
        $x("//input[@id='department']").setValue("Test");
        $x("//button[@id='submit']").click();
        $x("//div[@class='ReactTable -striped -highlight']").shouldHave(text("Test2"));
        $x("//input[@id='searchBox']").sendKeys("Test2");
        $x("//div[@class='ReactTable -striped -highlight']").shouldHave(text("Test@test2.com"));
    }
    @Test
    void buttonsTest(){
        open("/buttons");
        $x("//button[@id='doubleClickBtn']").doubleClick();
        $x("//p[@id='doubleClickMessage']").shouldHave(text("You have done a double click"));
        $x("//button[@id='rightClickBtn']").contextClick();
        $x("//p[@id='rightClickMessage']").shouldHave(text("You have done a right click"));
        $x("//button[text()='Click Me']").click();
        $x("//p[@id='dynamicClickMessage']").shouldHave(text("You have done a dynamic click"));
    }
}
