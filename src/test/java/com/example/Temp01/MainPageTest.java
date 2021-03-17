package com.example.Temp01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {



    @Test
    void TestWithSearchAllForms() {
        Configuration.startMaximized = true;

        open("https://demoqa.com/automation-practice-form");


        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Rom");
        $("#userEmail").setValue("aa@aa.cz");
        $(".custom-control-label").click();
        $("#userNumber").setValue("7929636225");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1982");
        $("[aria-label='Choose Tuesday, August 17th, 1982']").click();
        $("#subjectsInput").setValue("Tests");
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("tst.jpg");
        //$("#state").doubleClick();
        $("#currentAddress").setValue("Ostankinskaya street, Moscow, Russia");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("delhi").pressEnter();;
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Alex"),
                text("Rom"),
                text("aa@aa.cz"),
                text("Male"),
                text("7929636225"),
                text("17 August,1982"),
                text("Tests"),
                text("Music"),
                text("tst.jpg"),
                text("Ostankinskaya street, Moscow, Russia"),
                text("NCR"),
                text("Delhi"));
    }
}
