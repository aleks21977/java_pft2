package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase{

    //@BeforeMethod //переделка согласно l8_m7 05:00
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testsRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String user = "234";
        //String user = String.format("user%s", now);
        String password = "123";
        String email = String.format("%s@localhost", user);
        if (app.james().doesUserExist(user)) {
            app.james().deleteUser(user);//удаление существующего пользователя на внешнем почтовом сервере james для очистки его почты
        }
        //String email = String.format("user%s@localhost", now);
        app.james().createUser(user, password);
        app.james().drainEmail(user, password);//очитска почты пользователя на внешнем почтовом сервере james
        app.registration().start(user, email);
        //List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000); //переделка согласно l8_m7 05:00
        List<MailMessage> mailMessages = app.james().waitForMail(user, password, 30000);
        String cofirmationLink = findCofirmationLink(mailMessages, email);
        app.registration().finis(cofirmationLink, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findCofirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    //@AfterMethod(alwaysRun = true) //переделка согласно l8_m7 05:00
    public void stopMailServer() {
        app.mail().stop();
    }
}
