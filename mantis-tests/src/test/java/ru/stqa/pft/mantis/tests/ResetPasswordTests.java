package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        String user = "234";
        String password = "123";
        String passwordJames = "123";
        //String user = String.format("user%s", now);
        String password = String.format("%s", now);
        String email = String.format("%s@localhost", user);
//        if (app.james().doesUserExist(user)) {
//            app.james().deleteUser(user);//удаление существующего пользователя на внешнем почтовом сервере james для очистки его почты
//        }
        //String email = String.format("user%s@localhost", now);
        //app.james().createUser(user, password);//создание пользователя на внешнем почтовом сервере james
        app.james().drainEmail(user, passwordJames);//очитска почты пользователя на внешнем почтовом сервере james
        //app.registration().start(user, email);
        app.resetpassword().start(user);
        //List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        List<MailMessage> mailMessages = app.james().waitForMail(user, passwordJames, 30000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.resetpassword().resetPasswordFinish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    //@AfterMethod(alwaysRun = true) //переделка согласно l8_m7 05:00
    public void stopMailServer() {
        app.mail().stop();
    }
}
