package demoqa_email_test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckEmail {

    String firstName = "Denis";
    String lastName = "Pronin";
    String userNumber = "8956456565";
    String currentAddress = "House 123";

    @ValueSource(strings = {
            "Denis_Pronin@yandex.ru",
            "Denis_Pronin@yandex.by",
            "Denis_Pronin@ya.ru",
            "Denis_Pronin@yandex.com",
            "Denis_Pronin@yandex.kz"
    })
    @ParameterizedTest(name = "Проверка e-mail с {0}, ожидаем успешную регистрацию")
    void inputEmail1(String testData) {
//        Предусловия:
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
//        Шаги:
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(testData);
        $(".custom-control-label").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label='Choose Thursday, December 8th, 1994']").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/460.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").pressEnter();
//        Ожидаемый результат:
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(testData), text("Male"), text(userNumber),
                text("08 December,1994"), text("Maths"), text("Sports"), text("460.jpg"),
                text(currentAddress), text("Haryana Karnal"));
    }

    @CsvSource(value = {
            "Denis_Pronin@yandex.ru, yandex.ru",
            "Denis_Pronin@yandex.by, yandex.by",
            "Denis_Pronin@ya.ru, ya.ru",
            "Denis_Pronin@yandex.com, yandex.com",
            "Denis_Pronin@yandex.kz, yandex.kz"
    })
    @ParameterizedTest(name = "Проверка e-mail с {0}, ожидаем результат с {1} и успешную регистрацию")
    void inputEmail2(String testData, String userEmail) {
//        Предусловия:
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
//        Шаги:
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(testData);
        $(".custom-control-label").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label='Choose Thursday, December 8th, 1994']").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/460.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").pressEnter();
//        Ожидаемый результат:
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text("Male"), text(userNumber),
                text("08 December,1994"), text("Maths"), text("Sports"), text("460.jpg"),
                text(currentAddress), text("Haryana Karnal"));
    }

    static Stream<Arguments> methodSourceEmail() {
        return Stream.of(
                Arguments.of("Denis_Pronin@yandex.ru", "yandex.ru"),
                Arguments.of("Denis_Pronin@yandex.by", "yandex.by"),
                Arguments.of("Denis_Pronin@ya.ru", "ya.ru"),
                Arguments.of("Denis_Pronin@yandex.com", "yandex.com"),
                Arguments.of("Denis_Pronin@yandex.kz", "yandex.kz")
        );
    }

    @MethodSource("methodSourceEmail")
    @ParameterizedTest
    void methodSourceEmail(String testData, String userEmail) {
//        Предусловия:
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
//        Шаги:
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(testData);
        $(".custom-control-label").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label='Choose Thursday, December 8th, 1994']").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/460.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").pressEnter();
//        Ожидаемый результат:
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text("Male"), text(userNumber),
                text("08 December,1994"), text("Maths"), text("Sports"), text("460.jpg"),
                text(currentAddress), text("Haryana Karnal"));
    }
}
