import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JiraObjTests {

    LoginPage loginPage;
    ViewTicketPage viewTicketPage;
    AddTicketPage addTicketPage;
    AddCancelTicketPage addCancelTicketPage;
    AddCommentPage addCommentPage;


    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName) {
        Configuration.browser = browserName;
        open("https://jira.hillel.it/secure/Dashboard.jspa");
    }

//    @DataProvider(name = "Logins")
//    public Object[][] createData(){
//        return new Object[][]{
//                {"webinar5", "wrongPassword", "Sorry, your username and password are incorrect - please try again."},
//                {"wrongUserName", "webinar5", "Sorry, your username and password are incorrect - please try again."},
//        };
//    }

//    @Test(dataProvider = "Logins")
//    public void unsuccessfulLogin(String name, String password, String expectedResult) throws InterruptedException {
//        loginPage = new LoginPage();
//        loginPage.enterName(name);
//        loginPage.enterPassword(password);
//        loginPage.clickBtnLogin();
//        //loginPage.waitErrorMessage();
//        assertTrue(loginPage.errorMessageIsPresent(expectedResult));
//    }

    //@Test
    public void successfulLogin() {
        loginPage = new LoginPage();
        loginPage.enterName("**");
        loginPage.enterPassword("**");
        loginPage.clickBtnLogin();
        assertTrue(loginPage.isFlagLogin());
    }

    //@Test
    public void viewTicket(){
        successfulLogin();
        viewTicketPage = new ViewTicketPage();
        viewTicketPage.clickOnTicket();
        assertTrue(viewTicketPage.isViewTicket());
    }

    //@Test
    public void addTicket(){
        successfulLogin();
        addTicketPage = new AddTicketPage();
        addTicketPage.clickOnCreate();
        addTicketPage.enterProject("Webinar (WEBINAR)");
        addTicketPage.enterIssue("Task");
        addTicketPage.enterDescription("Jira Test Issue");
        addTicketPage.clickOnCreateOK();
        assertTrue(addTicketPage.isFlagPresent());
        assertTrue(addTicketPage.isTicketNameCorrect("WEBINAR"));
    }

    @Test
    public void cancelCreateIssue(){
        successfulLogin();
        addCancelTicketPage = new AddCancelTicketPage();
        addCancelTicketPage.clickOnCreate();
        addCancelTicketPage.enterProject("Webinar (WEBINAR)");
        addCancelTicketPage.enterIssue("Task");
        addCancelTicketPage.enterSummary("Jira Test Issue");
        addCancelTicketPage.clickCancel();
        addCancelTicketPage.acceptAlert();
        assertFalse(addCancelTicketPage.isFlagPresent());

    }

    //@Test
    public void addComment(){
        viewTicket();
        addCommentPage = new AddCommentPage();
        addCommentPage.clickBtnComment();
        addCommentPage.enterComment("Comment");
        addCommentPage.clickBtnCommentOk();
        assertTrue(addCommentPage.isCommentPresent());

        //deleting comment
        addCommentPage.clickBtnDelete();
        addCommentPage.clickDeleteSubmit();
        assertTrue(addCommentPage.isCommentDeleted());
    }

    //@Test
    public void failedTest(){
        viewTicketPage = new ViewTicketPage();
        assertTrue(viewTicketPage.isViewTicket());
    }

    //@AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
