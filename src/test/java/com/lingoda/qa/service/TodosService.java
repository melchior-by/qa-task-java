package com.lingoda.qa.service;

import com.codeborne.selenide.SelenideElement;
import com.lingoda.qa.pages.TodosPage;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;

public class TodosService {
    private TodosPage page;

    public TodosService() {
        page = new TodosPage();
    }

    public void addTodoElement(String elementText) {
        page.todoInput.setValue(elementText);
        page.todoInput.pressEnter();
        page.todoInput.clear();
    }

    public List<String> getTodosElements() {
        return page.todoList.stream().map(e -> e.find("label").getText()).toList();
    }

    //FIXME: it is only possible solutions due to strange behaviour of Selenium - constant element interaction exceptions
    public void editTodoElement(int elementNumber, String newValue) {
        SelenideElement element = page.getTodoInputElement(elementNumber);
        SelenideElement input = element.find("input");
        int times = element.find("label").getText().length();

        for (int i = 0; i < times; i++) {
            actions()
                    .doubleClick(input)
                    .sendKeys(Keys.ARROW_LEFT)
                    .sendKeys(Keys.DELETE)
                    .perform();
        }
        actions().sendKeys(newValue).sendKeys(Keys.ENTER).perform();
    }
}
