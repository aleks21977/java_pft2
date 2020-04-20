package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGrouCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("Group1", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }
}
