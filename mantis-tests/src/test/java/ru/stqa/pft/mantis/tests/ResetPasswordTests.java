package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase{

    //@BeforeMethod //переделка согласно l8_m7 05:00
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testsResetPassword() throws IOException, MessagingException {
//        String user = "user%s";
//        String password = "password";
//        String email = "user%s@localhost";
        app.resetpassword().start();
    }


    //@AfterMethod(alwaysRun = true) //переделка согласно l8_m7 05:00
    public void stopMailServer() {
        app.mail().stop();
    }
}
